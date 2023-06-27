package br.com.etec.ariane.trabalhoApi.Respository.Cliente;

import br.com.etec.ariane.trabalhoApi.Respository.filter.ClienteFilter;
import br.com.etec.ariane.trabalhoApi.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryImpl implements ClienteRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

    @Override

    public Page<Clinte> filtrar(ClienteFilter clienteFilter, Pageable pageable) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
        Root<Cliente> root = criteria.from(Cliente.class);

        Predicate[] predicates = criarRestricoes(clienteFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nomeCliente")));

        TypedQuery<Cliente> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(clienteFilter));


    }

    private Object total(ClienteFilter clienteFilter) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Cliente> root = criteria.from(Cliente.class);

        Predicate[] predicates = criarRestricoes(clienteFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nomeCliente")));

        criteria.select(builder.count(root));
        return manager.createQuery(criteria).getSingleResult();

    }

    private void adicionarRestricoesDePaginacao(TypedQuery<Cliente> query, Pageable pageble) {

        int paginaAtual = pageble.getPageNumber();
        int totalRegistroPagina = pageble.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistroPagina;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistroPagina);

    }


    private Predicate[] criarRestricoes(ClienteFilter clienteFilter, CriteriaBuilder builder, Root<Cliente> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(clienteFilter.getNomeCliente())) {
            predicates.add(builder.like(builder.lower(root.get("nomeCliente")),
                    "%" + clienteFilter.getNomeCliente().toLowerCase() + "%"));
        }
        return predicates.toArray((new Predicate[predicates.size()]));

    }

}

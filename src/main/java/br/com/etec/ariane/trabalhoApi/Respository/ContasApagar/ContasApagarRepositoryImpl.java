package br.com.etec.ariane.trabalhoApi.Respository.ContasApagar;

import br.com.etec.ariane.trabalhoApi.Respository.filter.ContasApagarFilter;
import br.com.etec.ariane.trabalhoApi.Respository.projections.ResumoContasApagar;
import br.com.etec.ariane.trabalhoApi.model.ContasApagar;
import org.hibernate.Criteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Predicates;
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

public class ContasApagarRepositoryImpl implements ContasApagarRepositoryQuery{
    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<ResumoContasApagar> filtrar(ContasApagarFilter contasApagarFilter, Pageable pageable){
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<ResumoContasApagar> criteria = builder.createQuery(ResumoContasApagar.class);
        Root<ContasApagar> root = criteria.from(ContasApagar.class);

        criteria.select(builder.construct(ResumoContasApagar.class,
                root.get("id"),
                root.get("data"),
                root.get("datavencimento"),
                root.get("cliente").get("nomeCliente")


        ));

        Predicate[] predicates = criarRestricoes(contasApagarFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("data")));
        TypedQuery<ResumoContasApagar>query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query,pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(contasApagarFilter));

    }


    private void adicionarRestricoesDePaginacao(TypedQuery<ResumoContasApagar> query, Pageable pageable) {

        int paginaAtual= pageable.getPageNumber();
        int totalDeRegistrosPorPagina= pageable.getPageSize();
        int primeiroRegistroDaPagina= paginaAtual * totalDeRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalDeRegistrosPorPagina);

    }

    private Object total(ContasApagarFilter contasApagarFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<ContasApagar> root = criteria.from(ContasApagar.class);

        Predicate[] predicates = criarRestricoes(contasApagarFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("data")));

        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();
    }

    private Predicate[] criarRestricoes(ContasApagarFilter contasApagarFilter, CriteriaBuilder builder, Root<ContasApagar> root) {

        List<Predicate> predicates = new ArrayList<>();

        if(contasApagarFilter.getData() != null){

            predicates.add(builder.greaterThanOrEqualTo(root.get("data"),
                    contasApagarFilter.getData()));

        }

        if(contasApagarFilter.getData() != null){

            predicates.add(builder.lessThanOrEqualTo(root.get("data"),
                    contasApagarFilter.getData()));

        }

        if(contasApagarFilter.getData() != null){

            predicates.add(builder.greaterThanOrEqualTo(root.get("datavencimento"),
                    contasApagarFilter.getDatavencimento()));

        }

        if(contasApagarFilter.getData() != null){

            predicates.add(builder.lessThanOrEqualTo(root.get("datavencimento"),
                    contasApagarFilter.getDatavencimento()));

        }

        if(!StringUtils.isEmpty(contasApagarFilter.getNomeCliente())) {
            predicates.add(builder.like(builder.lower(root.get("cliente").get("nomeCliente")),
                    "%" + contasApagarFilter.getNomeCliente().toLowerCase() + "%"
            ));
        }

        return predicates.toArray((new Predicate[predicates.size()]));

    }


}

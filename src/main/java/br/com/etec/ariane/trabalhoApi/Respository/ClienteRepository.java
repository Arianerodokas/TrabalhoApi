package br.com.etec.ariane.trabalhoApi.Respository;

import br.com.etec.ariane.trabalhoApi.Respository.Cliente.ClienteRepositoryQuery;
import br.com.etec.ariane.trabalhoApi.Respository.filter.ClienteFilter;
import br.com.etec.ariane.trabalhoApi.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>, ClienteRepositoryQuery {

}

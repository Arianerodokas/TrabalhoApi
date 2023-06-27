package br.com.etec.ariane.trabalhoApi.Respository.Cliente;

import br.com.etec.ariane.trabalhoApi.Respository.filter.ClienteFilter;
import br.com.etec.ariane.trabalhoApi.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteRepositoryQuery {
    Page<Cliente> filtrar(ClienteFilter clienteFilter, Pageable pageable);
}

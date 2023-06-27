package br.com.etec.ariane.trabalhoApi.Respository.Cliente;

import br.com.etec.ariane.trabalhoApi.Respository.filter.ClienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteRepositoryQuery {
    Page<Clinte> filtrar(ClienteFilter clienteFilter, Pageable pageable);
}

package br.com.etec.ariane.trabalhoApi.Respository;

import br.com.etec.ariane.trabalhoApi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}

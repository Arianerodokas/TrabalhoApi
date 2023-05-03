package br.com.etec.ariane.trabalhoApi.Respository;

import br.com.etec.ariane.trabalhoApi.Respository.ContasApagar.ContasApagarRepositoryQuery;
import br.com.etec.ariane.trabalhoApi.model.ContasApagar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContasApagarRepository extends JpaRepository<ContasApagar, Integer>, ContasApagarRepositoryQuery {
}

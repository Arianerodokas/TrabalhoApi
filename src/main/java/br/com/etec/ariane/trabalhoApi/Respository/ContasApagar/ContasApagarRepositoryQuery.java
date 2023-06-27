package br.com.etec.ariane.trabalhoApi.Respository.ContasApagar;

import br.com.etec.ariane.trabalhoApi.Respository.filter.ContasApagarFilter;
import br.com.etec.ariane.trabalhoApi.Respository.projections.ResumoContasApagar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContasApagarRepositoryQuery {
    Page<ResumoContasApagar> filtrar(ContasApagarFilter contasApagarFilter, Pageable pageable);
}

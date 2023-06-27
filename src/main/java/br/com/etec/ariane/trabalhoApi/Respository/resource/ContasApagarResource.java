package br.com.etec.ariane.trabalhoApi.Respository.resource;


import br.com.etec.ariane.trabalhoApi.Respository.ContasApagarRepository;
import br.com.etec.ariane.trabalhoApi.Respository.filter.ContasApagarFilter;
import br.com.etec.ariane.trabalhoApi.Respository.projections.ResumoContasApagar;
import br.com.etec.ariane.trabalhoApi.model.ContasApagar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contasApagar")

public class ContasApagarResource {

    @Autowired
    private ContasApagarRepository contasApagarRepository;

    @GetMapping("/todos")
    public List<ContasApagar> listarTodasContasApagar(){
        return contasApagarRepository.findAll();
    }

    @GetMapping()
    public Page<ResumoContasApagar> pesquisar(ContasApagarFilter contasApagarFilter, Pageable pageable){
        return contasApagarRepository.filtrar(contasApagarFilter, pageable);

    }
}

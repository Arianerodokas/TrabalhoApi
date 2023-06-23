package br.com.etec.ariane.trabalhoApi.Respository.resource;


import br.com.etec.ariane.trabalhoApi.Respository.ContasApagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contasApagar")

public class ContasApagar {

    @Autowired
    private ContasApagarRepository contasApagarRepository;

    @GetMapping("/todos")
    public List<ContasApagar> listarTodasContasApagar(){
        return contasApagarRepository.findAll();
    }
}

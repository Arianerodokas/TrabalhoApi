package br.com.etec.ariane.trabalhoApi.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="cliente")

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer Id;
    private String nomeCliente;

    @OneToMany(mappedBy = "cliente")
    private List<ContasApagar> contasApagar = new ArrayList<>();

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public List<ContasApagar> getContasApagar() {
        return contasApagar;
    }

    public void setContasApagar(List<ContasApagar> contasApagar) {
        this.contasApagar = contasApagar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Id.equals(cliente.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}

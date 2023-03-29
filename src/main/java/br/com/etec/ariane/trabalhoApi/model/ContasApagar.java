package br.com.etec.ariane.trabalhoApi.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="contasapagar")

public class ContasApagar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer Id;
    private Date data;
    private Date datavencimento;
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name="idcliente")

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDatavencimento() {
        return datavencimento;
    }

    public void setDatavencimento(Date datavencimento) {
        this.datavencimento = datavencimento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContasApagar that = (ContasApagar) o;
        return Id.equals(that.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}

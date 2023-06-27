package br.com.etec.ariane.trabalhoApi.Respository.projections;

import net.bytebuddy.asm.Advice;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ResumoContasApagar {

    private Integer id;
    private LocalDate data;
    private LocalDate datavencimento;
    private BigDecimal valor;

    private String nomecliente;

    public ResumoContasApagar(Integer id, LocalDate data, LocalDate datavencimento, BigDecimal valor, String nomecliente) {
        this.id = id;
        this.data = data;
        this.datavencimento = datavencimento;
        this.valor = valor;
        this.nomecliente = nomecliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDate getDatavencimento() {
        return datavencimento;
    }

    public void setDatavencimento(LocalDate datavencimento) {
        this.datavencimento = datavencimento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }
}

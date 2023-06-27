package br.com.etec.ariane.trabalhoApi.Respository.projections;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ResumoContasApagar {

    private Integer id;
    private LocalDate data;
    private LocalDate datavencimento;
    private BigDecimal valor;
    private String nomeCliente;

    public ResumoContasApagar(Integer id, LocalDate data, LocalDate datavencimento, BigDecimal valor, String nomeCliente){

        this.id= id;
        this.data= data;
        this.datavencimento= datavencimento;
        this.valor= valor;
        this.nomeCliente= nomeCliente;
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

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}

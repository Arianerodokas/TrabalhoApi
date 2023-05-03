package br.com.etec.ariane.trabalhoApi.Respository.filter;

import java.math.BigDecimal;
import java.util.Date;

public class ContasApagarFilter {

    private Date data;
    private Date datavencimento;
    private BigDecimal valor;

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
}

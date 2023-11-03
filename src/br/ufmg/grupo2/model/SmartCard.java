package br.ufmg.grupo2.model;

public class SmartCard {
    private String codigoSmartCard;
    private Float saldo;

    public SmartCard(String codigoSmartCard) {
        this.codigoSmartCard = codigoSmartCard;
        this.saldo = 0.0f;
    }

    public SmartCard(String codigoSmartCard, float saldo) {
        this.codigoSmartCard = codigoSmartCard;
        this.saldo = saldo;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void carregarCartao(Float saldo) {
        this.saldo = this.saldo + saldo;
    }

    public void debitarValor(Float valor) {
        this.saldo = saldo - valor;
    }

    public String getCodigoSmartCard() {
        return codigoSmartCard;
    }

    public void setCodigoSmartCard(String codigoSmartCard) {
        this.codigoSmartCard = codigoSmartCard;
    }
}

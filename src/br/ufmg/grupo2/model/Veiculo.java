package br.ufmg.grupo2.model;

import br.ufmg.grupo2.commom.Valores;
import br.ufmg.grupo2.model.types.TipoVeiculo;

public class Veiculo {

    private String placa;
    private TipoVeiculo tipoVeiculo;
    private SmartCard smartCard;

    public Veiculo(String placa, TipoVeiculo tipoVeiculo) {
        this.placa = placa;
        this.tipoVeiculo = tipoVeiculo;
    }

    public Veiculo(String placa, TipoVeiculo tipoVeiculo, SmartCard smartCard) {
        this.placa = placa;
        this.tipoVeiculo = tipoVeiculo;
        this.smartCard = smartCard;
    }

    public boolean hasSmartCard() {
        return smartCard != null;
    }

    public boolean temSaldoSuficiente() {
        if(smartCard != null) {
            switch (tipoVeiculo) {
                case MOTO -> {
                    return smartCard.getSaldo() >= Valores.VALOR_MOTO;
                }
                case CARRO -> {
                    return smartCard.getSaldo() >= Valores.VALOR_CARRO;
                }
                case CAMINHAO -> {
                    return smartCard.getSaldo() >= Valores.VALOR_CAMINHAO;
                }
                default -> {
                    return true;
                }
            }
        } else return false;
    }

    public String getPlaca() {
        return placa;
    }

    public float getSaldo() {
        if(!hasSmartCard()) {
            return 0f;
        } else {
            return getSmartCard().getSaldo();
        }
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public SmartCard getSmartCard() {
        return smartCard;
    }

    public void setSmartCard(SmartCard smartCard) {
        this.smartCard = smartCard;
    }
}

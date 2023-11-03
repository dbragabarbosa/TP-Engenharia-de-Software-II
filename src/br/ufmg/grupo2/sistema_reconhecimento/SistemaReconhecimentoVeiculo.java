package br.ufmg.grupo2.sistema_reconhecimento;

import br.ufmg.grupo2.model.Veiculo;

public class SistemaReconhecimentoVeiculo {
    private Veiculo veiculo;
    private final LocalChecarLicenciamento localChecarLicenciamento = new LocalChecarLicenciamento();

    public boolean verificaSistemaBordo() {
        return veiculo.getSmartCard() != null;
    };

    public boolean temLicensaValida() {
        return localChecarLicenciamento.licensaValida(veiculo.getPlaca());
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

}

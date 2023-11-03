package br.ufmg.grupo2.model;

import br.ufmg.grupo2.commom.Valores;
import br.ufmg.grupo2.model.types.StatusPedagio;
import br.ufmg.grupo2.pedagio.IntegracaoAutoAtendimento;
import br.ufmg.grupo2.pedagio.IntegracaoSmartCard;
import br.ufmg.grupo2.sistema_reconhecimento.SistemaReconhecimentoVeiculo;

import java.util.concurrent.TimeUnit;

public class Pedagio {
    private float saldoPedagio;
    private Veiculo veiculo;
    private StatusPedagio statusPedagio;
    private Cancela cancela;

    public Pedagio() {
        this.saldoPedagio = 0.0f;
        this.statusPedagio = StatusPedagio.DISPONIVEL;
        this.cancela = new Cancela();
    }

    public Pedagio(boolean statusPedagio) {
        if(!statusPedagio) {
            this.statusPedagio = StatusPedagio.FALHA;
            this.saldoPedagio = 0.0f;
            this.cancela = new Cancela();
        }
    }

    private final SistemaReconhecimentoVeiculo sistemaReconhecimentoVeiculo = new SistemaReconhecimentoVeiculo();

    public void ativarPedagio() {
        this.statusPedagio = StatusPedagio.DISPONIVEL;
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    setVeiculo(sistemaReconhecimentoVeiculo.getVeiculo());
                    if (veiculo != null) {
                        setStatusPedagio(StatusPedagio.OCUPADO);
                        boolean statusPagamento;

                        if (sistemaReconhecimentoVeiculo.verificaSistemaBordo() && veiculo.temSaldoSuficiente()) {
                            statusPagamento = new IntegracaoSmartCard().realizarCobranca(veiculo, calculaValor(veiculo));
                        } else {
                            statusPagamento = new IntegracaoAutoAtendimento().realizarCobranca(veiculo, calculaValor(veiculo));
                        }

                        if(!statusPagamento) {
                            setStatusPedagio(StatusPedagio.FALHA);
                            setVeiculo(null);
                            sistemaReconhecimentoVeiculo.setVeiculo(null);
                            break;
                        }
                        adicionaSaldo(calculaValor(veiculo));
                        cancela.setCancelaAberta(true);
                        if (!sistemaReconhecimentoVeiculo.temLicensaValida()) {notificarLicensa();}
                        try {
                            TimeUnit.SECONDS.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        cancela.setCancelaAberta(false);

                        setStatusPedagio(StatusPedagio.DISPONIVEL);
                        setVeiculo(null);
                        sistemaReconhecimentoVeiculo.setVeiculo(null);
                    }
                }
            }
        }.start();
    }

    private Float calculaValor(Veiculo veiculo) {
        float valor = 0.0f;
        switch(veiculo.getTipoVeiculo()) {
            case CAMINHAO -> valor = Valores.VALOR_CAMINHAO;
            case CARRO -> valor = Valores.VALOR_CARRO;
            case MOTO -> valor = Valores.VALOR_MOTO;
            default -> valor = 0f;
        }
        return valor;
    }

    public void notificarLicensa() {
        System.out.println("Licença invalida!!!!!!");
    }



    // A função abaixo é utilizada somente para simular um veículo encontrado pelo sensor
    public void setVeiculoParaTeste(Veiculo veiculo) {
        this.sistemaReconhecimentoVeiculo.setVeiculo(veiculo);
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public StatusPedagio getStatusPedagio() {
        return statusPedagio;
    }

    public void setStatusPedagio(StatusPedagio statusPedagio) {
        this.statusPedagio = statusPedagio;
    }

    public float getSaldoPedagio() {
        return saldoPedagio;
    }

    public void adicionaSaldo(float saldoPedagio) {
        this.saldoPedagio += saldoPedagio;
    }
}

package br.ufmg.grupo2.pagamento;

import br.ufmg.grupo2.model.Veiculo;

public class PagamentoMaquina implements Pagamento {
    @Override
    public String tokenPagamento(Veiculo veiculo, float valor) {

        // Integração externa para casos de uso se o veiculo tem placa especifica o pagamento falha;
        if (veiculo.getPlaca().equals("ERRO123")) {
            return "ERRO123";
        }
        else return "HAX123";
    }
}

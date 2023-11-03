package br.ufmg.grupo2.pedagio;

import br.ufmg.grupo2.model.Veiculo;
import br.ufmg.grupo2.pagamento.PagamentoSmartCard;

public class IntegracaoSmartCard {
    private final PagamentoSmartCard pagamentoSmartCard = new PagamentoSmartCard();

    public boolean realizarCobranca(Veiculo veiculo, float valor) {
        String retorno = pagamentoSmartCard.tokenPagamento(veiculo, valor);
        return !retorno.equals("ERR1234");
    }
}

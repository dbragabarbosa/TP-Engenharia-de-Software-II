package br.ufmg.grupo2.pedagio;

import br.ufmg.grupo2.model.Veiculo;
import br.ufmg.grupo2.pagamento.PagamentoMaquina;

public class IntegracaoAutoAtendimento  {
    private final PagamentoMaquina pagamentoMaquina = new PagamentoMaquina();

    public boolean realizarCobranca(Veiculo veiculo, float valor) {
        String retorno = pagamentoMaquina.tokenPagamento(veiculo, valor);
        return !retorno.equals("ERRO123");
    }

}

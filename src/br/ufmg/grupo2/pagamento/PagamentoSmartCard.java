package br.ufmg.grupo2.pagamento;

import br.ufmg.grupo2.commom.Valores;
import br.ufmg.grupo2.model.SmartCard;
import br.ufmg.grupo2.model.Veiculo;

import java.util.Objects;

public class PagamentoSmartCard implements Pagamento {
    @Override
    public String tokenPagamento(Veiculo veiculo, float valor) {
        veiculo.getSmartCard().debitarValor(valor);
        System.out.println("Pagamento realizado!");

        //Implementar após sistema de token
        return "HAX123";
    }
}

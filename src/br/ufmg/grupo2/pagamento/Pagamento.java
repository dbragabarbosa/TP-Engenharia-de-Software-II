package br.ufmg.grupo2.pagamento;

import br.ufmg.grupo2.model.Veiculo;

public interface Pagamento {
    public String tokenPagamento(Veiculo veiculo, float valor);
}

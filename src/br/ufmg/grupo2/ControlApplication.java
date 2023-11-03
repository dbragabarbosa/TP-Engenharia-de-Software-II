package br.ufmg.grupo2;

import br.ufmg.grupo2.data.DadosPedagios;
import br.ufmg.grupo2.painel.Painel;

public class ControlApplication {

    public static void main(String[] args) {
        DadosPedagios.getInstance().popularDados();
        DadosPedagios.getInstance().iniciarPedagios();
        Painel painel = new Painel();
        painel.start();

    }
}

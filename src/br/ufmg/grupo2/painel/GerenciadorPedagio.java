package br.ufmg.grupo2.painel;

import br.ufmg.grupo2.commom.Colors;
import br.ufmg.grupo2.model.types.StatusPedagio;
import br.ufmg.grupo2.model.Pedagio;


public class GerenciadorPedagio extends Painel {

    public GerenciadorPedagio(){};

    public void listadorPedagio() {
        for(int count=0; count < dadosPedagios.getPedagios().size(); count++){


            Pedagio pedagio = dadosPedagios.getPedagios().get(count);
            String color;
            if (pedagio.getStatusPedagio() == StatusPedagio.FALHA) {
                color = Colors.ANSI_RED;
            } else if (pedagio.getStatusPedagio() == StatusPedagio.OCUPADO) {
                color = Colors.ANSI_YELLOW;
            } else  color = Colors.ANSI_GREEN;


                line = """
                       Pedagio : %s
                       Saldo : %s
                       Status : %s  
                       """;
                printMessage(color + line.formatted(
                        count,
                        pedagio.getSaldoPedagio(),
                        pedagio.getStatusPedagio().toString())
                        + color
                );
            }

        startMenu();
    }


    public void pedagioNaoEncontrado() {
        line = """
                Pedagio não encontrado, digite um pedagio valido!
                """;
        printMessage(Colors.ANSI_RED + line + Colors.ANSI_RED);
        reiniciarPedagio();
    }

    public void reiniciarPedagio() {
        line = """
                Bem vindo ao Reiniciador de Pedagios
                
                Digite o numero do pedágio a ser reiniciado
                (0 a 5)
                """;
        printMessage(line);
        optionSelected = scanner.nextLine();
        int option = Integer.parseInt(optionSelected);
        if(option >= 0 && option <= 5) {
            dadosPedagios.getPedagios().get(option).ativarPedagio();
            dadosPedagios.getPedagios().get(option).setStatusPedagio(StatusPedagio.DISPONIVEL);
            line = """
                Pedagio reiniciado!
                Voltando ao menu
                """;
            printMessage(Colors.ANSI_GREEN + line + Colors.ANSI_GREEN);
            startMenu();
        } else {
            pedagioNaoEncontrado();
        }
    }
}

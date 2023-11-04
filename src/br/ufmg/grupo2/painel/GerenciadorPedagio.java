package br.ufmg.grupo2.painel;

import br.ufmg.grupo2.commom.Colors;
import br.ufmg.grupo2.model.types.StatusPedagio;
import br.ufmg.grupo2.model.Pedagio;


public class GerenciadorPedagio extends Painel {

    public GerenciadorPedagio(){};

    public void listadorPedagio() {
        for (int count = 0; count < dadosPedagios.getPedagios().size(); count++) {
            printPedagioDetails(count);
        }
        startMenu();
    }
    
    private void printPedagioDetails(int count) {
        Pedagio pedagio = dadosPedagios.getPedagios().get(count);
        String color = obtainPedagioColor(pedagio.getStatusPedagio());
    
        printPedagioInformation(count, pedagio, color);
    }
    
    private String obtainPedagioColor(StatusPedagio status) {
        if (status == StatusPedagio.FALHA) {
            return Colors.ANSI_RED;
        } else if (status == StatusPedagio.OCUPADO) {
            return Colors.ANSI_YELLOW;
        }
        return Colors.ANSI_GREEN;
    }
    
    private void printPedagioInformation(int count, Pedagio pedagio, String color) {
        String line = """
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
    
        if (isOptionValid(option)) {
            restartTollBooth(option);
        } else {
            pedagioNaoEncontrado();
        }
    }
    
    private boolean isOptionValid(int option) {
        return option >= 0 && option <= 5;
    }
    
    private void restartTollBooth(int option) {
        Pedagio selectedPedagio = dadosPedagios.getPedagios().get(option);
        selectedPedagio.ativarPedagio();
        selectedPedagio.setStatusPedagio(StatusPedagio.DISPONIVEL);
        line = """
            Pedagio reiniciado!
            Voltando ao menu
            """;
        printMessage(Colors.ANSI_GREEN + line + Colors.ANSI_GREEN);
        startMenu();
    }
    
}

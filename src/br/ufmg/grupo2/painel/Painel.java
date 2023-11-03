package br.ufmg.grupo2.painel;

import br.ufmg.grupo2.commom.Colors;
import br.ufmg.grupo2.data.DadosPedagios;

import java.util.Objects;
import java.util.Scanner;

public class Painel {

    private static final Integer SIZE_SCREEN = 76;
    private static final String EMPTY = "";

    // Variaveis globais para utilização da classe e filhos.
    Scanner scanner = new Scanner(System.in);
    protected static final DadosPedagios dadosPedagios = DadosPedagios.getInstance();
    protected String optionSelected;
    protected String line;

    public void start() {
        separateScreen();
        line = """
                \t\t\t\t\t\t AutomaticTollSystem Version 1.0.0

                Seja bem-vindo ao AutomaticTollSystem, prossiga no menu abaixo para as opções no menu
                
                Pressione ESQ ou enter vazio a qualquer momento para finalizar essa sessão""";

        printMessage(line);
        separateScreen();
        startMenu();
    }

    protected void startMenu() {
        separateScreen();
        line = """
                \t\t\t\t\t\t MENU
                Digite 1 para monitorar todos os pedágios
                Digite 2 para reiniciar um pedágio
                Digite 3 para opções de desenvolvedor
                
                Insira a opção desejada: 
                """;
        printMessage(line);
        optionSelected = scanner.nextLine();

        switch(optionSelected) {
            case "1" -> new GerenciadorPedagio().listadorPedagio();
            case "2" -> new GerenciadorPedagio().reiniciarPedagio();
            case "3" -> new DesenvolvedorOpcoes().iniciarOpcoes();
            default -> endSession();
        }
    }


    //Método para finalizar o sistema
    protected void endSession() {
        separateScreen();
        printMessage("Obrigado por usar o sistema!");
        separateScreen();
    }


    //Método para separar telas nas mensagens utilizadas pelo terminal
    protected void separateScreen(){
        String repeated = new String(new char[SIZE_SCREEN]).replace("\0", "-");
        printMessage(EMPTY);
        printMessage(Colors.ANSI_BLUE + repeated + Colors.ANSI_BLUE);
        printMessage(EMPTY);
    }

    //Método para evitar boilerplate de impressão
    protected void printMessage(String message){
        System.out.println(Objects.requireNonNullElse(message, ""));
    }
}

package br.ufmg.grupo2.painel;

import br.ufmg.grupo2.commom.Colors;
import br.ufmg.grupo2.model.Veiculo;


public class DesenvolvedorOpcoes extends Painel {

    public DesenvolvedorOpcoes(){};

    public void iniciarOpcoes() {
        line = """
                Bem vindo as Opcoes de desenvolvedor
                Lista de carros disponiveis:
           
                """;
        printMessage(line);


        for(int count=0; count < dadosPedagios.getVeiculos().size(); count++){
            Veiculo veiculo = dadosPedagios.getVeiculos().get(count);

            float saldo;
            if(!veiculo.hasSmartCard()) {
                saldo = 0f;
            } else {
                saldo = veiculo.getSmartCard().getSaldo();
            }
                line = """
                       id: %s
                       Veiculo : %s
                       Tipo : %s
                       Tem SmartCard : %s
                       Saldo: %s
                       """;
                printMessage(line.formatted(
                        count,
                        veiculo.getPlaca(),
                        veiculo.getTipoVeiculo(),
                        veiculo.hasSmartCard(),
                        saldo
                        )
                );
        }
        adicionarVeiculoAPedagio();
    }


    public void adicionarVeiculoAPedagio() {
        line = """
                Selecione qual veiculo deseja utilizar:
                Digite o id:
                """;
        printMessage(line);
        optionSelected = scanner.nextLine();
        Veiculo veiculo = dadosPedagios.getVeiculos().get(Integer.parseInt(optionSelected));

        line = """
                       id: %s
                       Veiculo : %s
                       Tipo : %s
                       Tem SmartCard : %s
                       Saldo: %s
                       """;
        printMessage(line.formatted(
                optionSelected,
                veiculo.getPlaca(),
                veiculo.getTipoVeiculo(),
                veiculo.hasSmartCard(),
                veiculo.getSaldo()));

        line = """
                Selecione o pedagio que ira passar:
                Digite o id (0 a 5):
                """;
        printMessage(line);
        optionSelected = scanner.nextLine();
        int option = Integer.parseInt(optionSelected);

        if(option >= 0 && option <= 5) {
            dadosPedagios.getPedagios().get(option).setVeiculoParaTeste(veiculo);
            line = """
                Veiculo adicionado ao pedagio voltando a menu;
                """;
            printMessage(Colors.ANSI_GREEN + line + Colors.ANSI_GREEN);
            startMenu();
        } else {
            adicionarVeiculoAPedagio();
        }

    }

}

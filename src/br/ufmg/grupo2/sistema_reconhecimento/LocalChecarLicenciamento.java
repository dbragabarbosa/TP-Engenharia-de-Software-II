package br.ufmg.grupo2.sistema_reconhecimento;

public class LocalChecarLicenciamento implements ChecarLicenciamento{
    @Override
    public boolean licensaValida(String placa) {

        //Gerenciador local a fim de testes
        return !placa.equals("ERRO123");
    }
}

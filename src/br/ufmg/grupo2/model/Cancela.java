package br.ufmg.grupo2.model;

public class Cancela {
    private boolean cancelaAberta;

    public Cancela() {
        this.cancelaAberta = false;
    }


    public boolean isCancelaAberta() {
        return cancelaAberta;
    }

    public void setCancelaAberta(boolean cancelaAberta) {
        this.cancelaAberta = cancelaAberta;
    }
}


package tests;

import br.ufmg.grupo2.commom.Valores;
import br.ufmg.grupo2.model.Pedagio;
import br.ufmg.grupo2.model.types.StatusPedagio;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tests.data.DadosTeste;

import static org.junit.jupiter.api.Assertions.*;

class PedagioTest {

    @BeforeAll
    static void init() {
        DadosTeste.getInstance().popularDados();
        DadosTeste.getInstance().iniciarPedagios();
    }


    @Test
    void ativarPedagioTornaPedagioDisponivel() {
        Pedagio pedagio = new Pedagio();

        pedagio.ativarPedagio();

        Assert.assertEquals(StatusPedagio.DISPONIVEL, pedagio.getStatusPedagio());
    }

    @Test
    void iniciarPedagioComFalha() {
        Pedagio pedagio = new Pedagio(false);

        Assert.assertEquals(StatusPedagio.FALHA, pedagio.getStatusPedagio());

    }


    @Test
    void reiniciarPedagio() {
        Pedagio pedagio = new Pedagio(false);

        Assert.assertEquals(StatusPedagio.FALHA, pedagio.getStatusPedagio());

        pedagio.ativarPedagio();

        Assert.assertEquals(StatusPedagio.DISPONIVEL, pedagio.getStatusPedagio());

    }

    @Test
    void carroPassando() {
        Pedagio pedagio = new Pedagio();
        pedagio.ativarPedagio();
        pedagio.setVeiculoParaTeste(DadosTeste.getInstance().getVeiculos().get(3));
        assertEquals(0.0f, pedagio.getSaldoPedagio());
    }



    @Test
    void notificarLicensa() {
        Pedagio pedagio = new Pedagio();
        pedagio.ativarPedagio();
        pedagio.setVeiculoParaTeste(DadosTeste.getInstance().getVeiculos().get(3));
        assertEquals(0f, pedagio.getSaldoPedagio());
    }

    @Test
    void setVeiculoParaTeste() {
        Pedagio pedagio = new Pedagio();
        pedagio.ativarPedagio();
        pedagio.setVeiculoParaTeste(DadosTeste.getInstance().getVeiculos().get(3));
        Assert.assertEquals(StatusPedagio.DISPONIVEL, pedagio.getStatusPedagio());
    }

    @Test
    void getStatusPedagio() {
        Pedagio pedagio = new Pedagio();
        pedagio.ativarPedagio();
        pedagio.setVeiculoParaTeste(DadosTeste.getInstance().getVeiculos().get(3));
        Assert.assertEquals(StatusPedagio.DISPONIVEL, pedagio.getStatusPedagio());
    }

    @Test
    void setStatusPedagio() {
        Pedagio pedagio = new Pedagio();
        pedagio.setStatusPedagio(StatusPedagio.FALHA);
        Assert.assertEquals(StatusPedagio.FALHA, pedagio.getStatusPedagio());
    }

    @Test
    void getSaldoPedagio() {
        Pedagio pedagio = new Pedagio();
        pedagio.adicionaSaldo(20f);
        assertEquals(20f, pedagio.getSaldoPedagio());
    }

    @Test
    void adicionaSaldo() {
        Pedagio pedagio = new Pedagio();
        pedagio.adicionaSaldo(20f);
        assertEquals(20f, pedagio.getSaldoPedagio());
    }
}
package tests;

import br.ufmg.grupo2.model.Veiculo;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tests.data.DadosTeste;

import java.util.List;

class VeiculoTest {

    @BeforeAll
    static void init() {
        DadosTeste.getInstance().popularDados();
        DadosTeste.getInstance().iniciarPedagios();
    }

    @Test
    void hasSmartCardWithVehicleWithandWithoutSmartCard() {
        List<Veiculo> veiculoList = DadosTeste.getInstance().getVeiculos();
        Assert.assertTrue(veiculoList.get(0).hasSmartCard());
        Assert.assertFalse(veiculoList.get(2).hasSmartCard());
    }

    @Test
    void temSaldoSuficienteComSaldoSemSaldo() {
        List<Veiculo> veiculoList = DadosTeste.getInstance().getVeiculos();

        Assert.assertTrue(veiculoList.get(0).temSaldoSuficiente());
        Assert.assertFalse(veiculoList.get(1).temSaldoSuficiente());
    }

    @Test
    void getPlacaComCarroComPlaca() {
        List<Veiculo> veiculoList = DadosTeste.getInstance().getVeiculos();

        Assert.assertEquals("ERRO123", veiculoList.get(0).getPlaca());
    }

    @Test
    void getSaldoDeVeiculoComSmartCard() {
        List<Veiculo> veiculoList = DadosTeste.getInstance().getVeiculos();

        Assertions.assertEquals(200.0, veiculoList.get(0).getSaldo());
    }
}
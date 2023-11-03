package tests;

import br.ufmg.grupo2.model.SmartCard;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartCardTest {

    @Test
    void getSaldoSmartCard() {
        SmartCard smartCard = new SmartCard("TEST");
        SmartCard smartCard2 = new SmartCard("TEST2", 124f);

        assertEquals(0f, smartCard.getSaldo());
        assertEquals(124f, smartCard2.getSaldo());
    }

    @Test
    void carregarCartao() {
        SmartCard smartCard = new SmartCard("TEST");
        SmartCard smartCard2 = new SmartCard("TEST2", 124f);

        smartCard.carregarCartao(10f);
        smartCard2.carregarCartao(100f);

        assertEquals(10f, smartCard.getSaldo());
        assertEquals(224f, smartCard2.getSaldo());
    }

    @Test
    void debitarValor() {
        SmartCard smartCard = new SmartCard("TEST2", 124f);

        smartCard.debitarValor(10f);

        assertEquals(114f, smartCard.getSaldo());
    }
}
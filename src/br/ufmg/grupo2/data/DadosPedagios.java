package br.ufmg.grupo2.data;

import br.ufmg.grupo2.model.SmartCard;
import br.ufmg.grupo2.model.Veiculo;
import br.ufmg.grupo2.model.types.StatusPedagio;
import br.ufmg.grupo2.model.types.TipoVeiculo;
import br.ufmg.grupo2.model.Pedagio;

import java.util.ArrayList;
import java.util.List;


// Essa classe funciona como padrão Singleton
public class DadosPedagios {

    private static DadosPedagios uniqueInstance;
    private List<Pedagio> pedagios = new ArrayList<>();
    private List<Veiculo> veiculos = new ArrayList<>();

    private DadosPedagios() {}

    public static synchronized DadosPedagios getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new DadosPedagios();

        return uniqueInstance;
    }

    public List<Pedagio> getPedagios() {
        return pedagios;
    }

    public void setPedagios(Pedagio pedagio) {
        this.pedagios.add(pedagio);
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }


    public void iniciarPedagios() {
        for (Pedagio pedagio : pedagios) {
            if (pedagio.getStatusPedagio() != StatusPedagio.FALHA) {
                pedagio.ativarPedagio();
            }
        }
    }

    public void popularDados() {
        this.pedagios.add(new Pedagio());
        this.pedagios.add(new Pedagio());
        this.pedagios.add(new Pedagio(false));
        this.pedagios.add(new Pedagio());
        this.pedagios.add(new Pedagio(false));
        this.pedagios.add(new Pedagio());



        this.veiculos.add(new Veiculo("ERRO123", TipoVeiculo.CARRO, new SmartCard("Codigo1", 200f)));
        this.veiculos.add(new Veiculo("ERRO123", TipoVeiculo.CARRO, new SmartCard("Codigo1")));
        this.veiculos.add(new Veiculo("ERRO123", TipoVeiculo.CAMINHAO));
        this.veiculos.add(new Veiculo("HAX1234", TipoVeiculo.CARRO, new SmartCard("Codigo1", 200f)));
        this.veiculos.add(new Veiculo("HAX1234", TipoVeiculo.CARRO, new SmartCard("Codigo1")));
        this.veiculos.add(new Veiculo("HAX1234", TipoVeiculo.MOTO ));
        this.veiculos.add(new Veiculo("HAX1234", TipoVeiculo.MOTO, new SmartCard("Codigo1", 200f)));
        this.veiculos.add(new Veiculo("HAX1234", TipoVeiculo.CAMINHAO, new SmartCard("Codigo1", 200f)));
        this.veiculos.add(new Veiculo("HAX1234", TipoVeiculo.CAMINHAO, new SmartCard("Codigo1", 200f)));

    }





}

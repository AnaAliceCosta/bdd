package acceptance.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Dados;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropondoLancesSteps {
    private ArrayList<Lance> lances;
    private Leilao leilao;
    private Exception erroOcorrido;

    @Before
    public void setup() {
        this.lances = new ArrayList<>();
        this.leilao = new Leilao("tablet XPTO");
    }
    @After
    public void asdf(){
        this.leilao=null;
    }
    @Dados("um lace de {double} reais do usuario {string}")
    public void um_lace_de_reais_do_usuario(Double valor, String nomeUsuario) {
        try {
            Usuario usuario = new Usuario(nomeUsuario);
            Lance lance = new Lance(usuario, new BigDecimal(valor));
            lances.add(lance);
        } catch (IllegalArgumentException e){
            this.erroOcorrido = e;

        }
    }
    @Quando("popoe varios lances")
    public void popoe_varios_lances() {
        this.lances.forEach(lance -> leilao.propoe(lance));
        System.out.println("quantidadde de lances propostos: " + lances.size());
    }
    @Entao("os lances sao aceitos")
    public void os_lances_sao_aceitos() {
        assertEquals(this.lances.size(),leilao.getLances().size());
        assertEquals(lances.get(0).getValor(),leilao.getLances().get(0).getValor());
        assertEquals(lances.get(1).getValor(),leilao.getLances().get(1).getValor());
    }

    @Dado("os lances abaixo")
    public void os_lances_abaixo(DataTable dataTable) {
       List<Map<String, String>> valores = dataTable.asMaps();
        for (Map<String, String> mapa : valores) {
            String usuario = mapa.get("usuario");
            String valor = mapa.get("valor");
            Lance lance = new Lance(new Usuario(usuario),new BigDecimal(valor));
            lances.add(lance);

        }
    }

    @Quando("propoe um lance")
    public void propoe_um_lance() {
        this.lances.forEach(lance -> leilao.propoe(lance));
        System.out.println("quantidadde de lances propostos: " + lances.size());
    }
    @Entao("o lance é aceito")
    public void o_lance_é_aceito() {

        int lanceAtual = 1;
        int quantidadeDeLances = leilao.getLances().size();

        BigDecimal valorAtualDoLance = lances.get(0).getValor();
        BigDecimal valorEsperadoDoLance = leilao.getLances().get(0).getValor();

        assertEquals(1,leilao.getLances().size());
        assertEquals(lances.get(0).getValor(),leilao.getLances().get(0).getValor());
    }
    @Entao("o lance não é aceito")
    public void o_lance_não_é_aceito() {
        assertEquals(IllegalArgumentException.class,erroOcorrido.getClass());
    }
}

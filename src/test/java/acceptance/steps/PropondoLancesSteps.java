package acceptance.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropondoLancesSteps {
    private Leilao leilao;
    private ArrayList<Lance> lances;
    private Exception erroOcorrido;

    @Before
    public void setup() {
        this.lances = new ArrayList<Lance>();
        this.leilao = new Leilao("tablet XPTO");
    }
    @Dado("um lance valido")
    public void um_lance_valido() {
        Usuario usuario = new Usuario("fulano");
        Lance lance = new Lance(usuario, BigDecimal.TEN);
        this.lances.add(lance);
    }
    @Quando("propoe um lance")
    public void propoe_um_lance() {
        this.lances.forEach(lance -> leilao.propoe(lance));
    }
    @Entao("o lance é aceito")
    public void o_lance_eh_aceito() {
        assertEquals(1,leilao.getLances().size());
        assertEquals(lances.get(0).getValor(),leilao.getLances().get(0).getValor());
    }
    @Entao("o lance não é aceito")
    public void o_lance_não_é_aceito() {
        assertEquals(IllegalArgumentException.class,erroOcorrido.getClass());
    }

    @Dado("um lace de {double} reais do usuario {string}")
    public void um_lace_de_reais_do_usuario(Double valor, String nomeUsuario) {
        try {
            Usuario usuario = new Usuario(nomeUsuario);
            Lance lance = new Lance(usuario, new BigDecimal(valor));
            lances.add(lance);
        } catch (IllegalArgumentException e){
            erroOcorrido = e;

        }

    }

    @Dado("os lances abaixo")
    public void os_lances_abaixo(DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

        List<Map<String, String>> valores = dataTable.asMaps();
        for (Map<String, String> mapa : valores) {
            String usuario = mapa.get("usuario");
            String valor = mapa.get("valor");
            Lance lance = new Lance(new Usuario(usuario),new BigDecimal(valor));
            lances.add(lance);

        }

    }


    @Quando("popoe varios lances")
    public void popoe_varios_lances() {
        this.lances.forEach(lance -> leilao.propoe(lance));

    }

    @Entao("os lances sao aceitos")
    public void os_lances_sao_aceitos() {
        assertEquals(this.lances.size(),leilao.getLances().size());
        assertEquals(lances.get(0).getValor(),leilao.getLances().get(0).getValor());
        assertEquals(lances.get(1).getValor(),leilao.getLances().get(1).getValor());
    }

}
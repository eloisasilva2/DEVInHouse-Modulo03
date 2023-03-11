package br.senai.sc.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AvaliadorTeste {

    private  Usuario usuario;
    private  Usuario usuario2;

    private  Usuario usuario3;
    private  Usuario usuario4;
    private Lance l1;
    private Lance l2;
    private Lance l3;
    private Lance l4;
    private Leilao leilao;

    public void setup(){
        usuario = new Usuario("Eloisa", 33, "111.222.012-99");
        usuario2 = new Usuario("Ana", 53, "188.222.012-88");
        usuario3 = new Usuario("Antonio", 51, "558.211.048-78");
        usuario4 = new Usuario("João", 45, "243.562.263-57");

        l1 = new Lance(200, usuario);
        l2 = new Lance(300, usuario2);
        l3 = new Lance(400, usuario3);
        l4 = new Lance(500, usuario4);
        leilao = new Leilao();
    }
    @Test
    void deveEncontrarOMaiorEOMenorLance() {
        l1 = new Lance(200, usuario);
        l2 = new Lance(300, usuario2);
        l3 = new Lance(400, usuario3);
        l4 = new Lance(500, usuario4);
        leilao = new Leilao();
        leilao.adiciona(l1);
        leilao.adiciona(l2);
        leilao.adiciona(l3);
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        double menorLanceEsperado = 200;
        double maiorLanceEsperado = 400;
        double menorLanceEncontrado = leiloeiro.getMenorLance();
        double maiorLanceEncontrado = leiloeiro.getMaiorLance();
        assertEquals(menorLanceEsperado, menorLanceEncontrado);
        assertEquals(maiorLanceEsperado, maiorLanceEncontrado);
    }
    @Test
    void naoDeveAceitarMaisDeUmLanceComValoresIguais() {
        l1 = new Lance(200, usuario);
        l2 = new Lance(300, usuario2);
        l3 = new Lance(400, usuario3);
        l4 = new Lance(500, usuario4);
        leilao = new Leilao();
        leilao.adiciona(l1);
        leilao.adiciona(l2);
        leilao.adiciona(l3);
        List<Lance> lances = leilao.getLances();
        List<Lance> lancesIguais = new ArrayList<Lance>();
        lances.forEach(lance -> {
            if (lance.getValor() == 200) {
                lancesIguais.add(lance);
            }
        });
        int tamanhoDaLista = lancesIguais.size();
        assertEquals(1, tamanhoDaLista);
    }
    @Test
    void naoDeveAceitarLancesConsecutivos() {
        Usuario usuario = new Usuario("Eloisa", 33, "111.222.012-99");
        Lance l1 = new Lance(200, usuario);
        Lance l2 = new Lance(300, usuario);

        leilao = new Leilao();
        leilao.adiciona(l1);
        leilao.adiciona(l2);
        List<Lance> lances = leilao.getLances();
        int tamanhoDaLista = lances.size();
        assertEquals(1, tamanhoDaLista);
    }

    @Test
    void tresMaioresLances() {
        l1 = new Lance(200, usuario);
        l2 = new Lance(300, usuario2);
        l3 = new Lance(400, usuario3);
        l4 = new Lance(500, usuario4);
        leilao = new Leilao();
        leilao.adiciona(l1);
        leilao.adiciona(l2);
        leilao.adiciona(l3);
        leilao.adiciona(l4);
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        int[] expected = new int[]{500, 400, 300};
        List<Lance> actual = leilao.TopTresLances();
    }

    @Test
    void tresMenoresLances() {
        l1 = new Lance(200, usuario);
        l2 = new Lance(300, usuario2);
        l3 = new Lance(400, usuario3);
        l4 = new Lance(600, usuario4);
        leilao = new Leilao();
        leilao.adiciona(l1);
        leilao.adiciona(l2);
        leilao.adiciona(l3);
        leilao.adiciona(l4);
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        int[] expected = new int[]{300, 200, 100};
        List<Lance> actual = leilao.getTresMenores();

    }

    @Test
    public void testaLanceUnico() {
        l1 = new Lance(200, usuario);
        l2 = new Lance(300, usuario2);
        l3 = new Lance(400, usuario3);
        l4 = new Lance(500, usuario4);
        leilao = new Leilao();
        leilao.adiciona(l1);
        leilao.adiciona(l2);
        leilao.adiciona(l3);
        leilao.adiciona(l4);
        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);
        double maiorEsperado = 1000.0;
        double menorEsperado = 1000.0;
        assertEquals(maiorEsperado, avaliador.getMaiorLance(), 0.0001);
        assertEquals(menorEsperado, avaliador.getMenorLance(), 0.0001);
    }

}


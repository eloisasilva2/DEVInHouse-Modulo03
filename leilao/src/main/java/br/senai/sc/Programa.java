package br.senai.sc;

import br.senai.sc.models.Avaliador;
import br.senai.sc.models.Lance;
import br.senai.sc.models.Leilao;
import br.senai.sc.models.Usuario;

/**
 * Hello world!
 *
 */
public class Programa {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Eloisa", 33, "111.222.012-99");
        Lance l1 = new Lance(100, usuario);
        Lance l2 = new Lance(300, usuario);
        Lance l3 = new Lance(400, usuario);
        Leilao leilao = new Leilao();
        leilao.adiciona(l3);
        leilao.adiciona(l2);
        leilao.adiciona(l1);
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        System.out.println("O maior lance encontrado foi de " +
                leiloeiro.getMaiorLance());
        System.out.println("O menor lance encontrado foi de " +
                leiloeiro.getMenorLance());

        double maiorLanceEsperado = 400;
        double menorLanceEsperado = 200;
        double maiorLanceEncontrado = leiloeiro.getMaiorLance();
        double menorLanceEncontrado = leiloeiro.getMenorLance();
        System.out.println(maiorLanceEncontrado == maiorLanceEsperado);
        System.out.println(menorLanceEncontrado == menorLanceEsperado);
    }
}

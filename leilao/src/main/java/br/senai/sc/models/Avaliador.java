package br.senai.sc.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Avaliador {
    private double maiorLance = Double.NEGATIVE_INFINITY;
    private double menorLance = Double.POSITIVE_INFINITY;
    private List<Lance> maiores;
    private List<Lance> menores;

    public void avalia(Leilao leilao) {
        List<Lance> lances = leilao.getLances();
        for (Lance lance : lances) {
            if (lance.getValor() > this.maiorLance) {
                this.maiorLance = lance.getValor();
            }
            if (lance.getValor() < this.menorLance) {
                this.menorLance = lance.getValor();
            }
        }

        maiores = new ArrayList<>(leilao.getLances());
        Collections.sort(maiores, (o1, o2) -> {
            if (o1.getValor() < o2.getValor()) return 1;
            if (o1.getValor() > o2.getValor()) return -1;
            return 0;
        });
        maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());

        menores = new ArrayList<>(leilao.getLances());
        Collections.sort(menores, (o1, o2) -> {
            if (o1.getValor() > o2.getValor()) return 1;
            if (o1.getValor() < o2.getValor()) return -1;
            return 0;
        });
        menores = menores.subList(0, menores.size() > 3 ? 3 : menores.size());
    }




    public double getMaiorLance() {
        return maiorLance;
    }

    public double getMenorLance() {
        return menorLance;
    }

    public List<Lance> getTresMaiores() {
        return maiores;
    }

    public List<Lance> getTresMenores() {
        return menores;
    }
}

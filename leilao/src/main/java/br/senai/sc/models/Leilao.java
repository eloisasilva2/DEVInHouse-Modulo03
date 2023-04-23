package br.senai.sc.models;

import java.util.*;

public class Leilao {
    private List<Lance> lances;
    private Date dataRealizacao = new Date();

    public Leilao() {
        this.lances = new ArrayList<Lance>();
    }

    public void adiciona(Lance lance) {
        if (!this.lances.contains(lance)){
            this.lances.add(lance);
        }
    }

    public List<Lance> getLances() {
        return Collections.unmodifiableList(lances);
    }

    private Lance ultimoLanceDado() {
        int totalDeLances = this.lances.size();
        return this.lances.get(totalDeLances - 1);
    }

    public List<Lance> TopTresLances() {
        int valoresMaiores = lances.size();
        if (valoresMaiores == 3) {
            valoresMaiores = 3;
        }
        List<Lance> topLances = new ArrayList<Lance>(lances.subList(0, valoresMaiores));
        Collections.sort(topLances, (o1, o2) -> {
            if (o1.getValor() < o2.getValor()) return 1;
            if (o1.getValor() > o2.getValor()) return -1;
            return 0;
        });
        return topLances;
        }

    public List<Lance> getTresMenores() {
        int valoresMenores = lances.size();
        if (valoresMenores < 3) {
            valoresMenores = 3;
        }
        List<Lance> menoresLances = new ArrayList<Lance>(lances.subList(0, valoresMenores));
        Collections.sort(menoresLances, (o1, o2) -> {
            if (o1.getValor() < o2.getValor()) return 1;
            if (o1.getValor() > o2.getValor()) return -1;
            return 0;
        });
        return menoresLances;
    }


}

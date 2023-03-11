package br.senai.sc.models;

import java.util.Comparator;

public class Lance implements Comparable<Lance>, Comparator<Lance> {
    
    private double valor;
    private Usuario usuario;

    public Lance() {
    }
    public Lance(double valor, Usuario usuario) {
        super();
        this.valor = valor;
        this.usuario = usuario;
    }

    public boolean usuarioDoLance(Usuario usuario) {
        return this.usuario.equals(usuario);
    }


    @Override
    public int compareTo(Lance outroLance) {
        if (this.valor > outroLance.valor) {
            return -1;
        } else if (this.valor < outroLance.valor) {
            return 1;
        }
        return 0;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public double getValor() {
        return valor;
    }


    @Override
    public int compare(Lance o1, Lance o2) {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Lance))
            return false;
        Lance other = (Lance) obj;
        if (Double.doubleToLongBits(valor) != Double.
                doubleToLongBits(other.valor))
            return false;
        return true;
    }


}

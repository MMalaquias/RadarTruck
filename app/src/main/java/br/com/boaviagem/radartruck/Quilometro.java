package br.com.boaviagem.radartruck;


public class Quilometro {

    private boolean ativo;
    private String kmRodados;
    public Quilometro(){}

    public Quilometro(String kmRodados, boolean ativo){
        this.kmRodados = kmRodados;
        this.ativo = ativo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getKmRodados() {
        return kmRodados;
    }

    public void setKmRodados(String kmRodados) {
        this.kmRodados = kmRodados;
    }


}

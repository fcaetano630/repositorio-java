package Exercicio5;

public class Caminhao {

    private int pluviometros;

    private Tipo tipo;

    public Caminhao(){}

    public Caminhao(int pluviometros, Tipo tipo) {
        this.pluviometros = pluviometros;
        this.tipo = tipo;
    }

    public int getPluviometros() {
        return pluviometros;
    }

    public void setPluviometros(int pluviometros) {
        this.pluviometros = pluviometros;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}

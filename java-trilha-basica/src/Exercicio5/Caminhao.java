package Exercicio5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Caminhao {

    private int pluviometros;

    private List<Pluviometro> listaPluviometros = new ArrayList<>();

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

    public List<Pluviometro> getListaPluviometros() {
        return listaPluviometros;
    }

    public void setListaPluviometros(List<Pluviometro> listaPluviometros) {
        this.listaPluviometros = listaPluviometros;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void criaPluviometro() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite um numero inteiro para capacidade do pluviometro: ");
        int capacidade = entrada.nextInt();

        listaPluviometros.add(new Pluviometro(capacidade));
    }

    public int somaCapacidadePluviometro(List<Pluviometro> lista) {
        int soma = 0;
        for(Pluviometro p : lista) {
            soma+=p.getCapacidade();
        }
        return soma;
    }
}

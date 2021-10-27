package Exercicio3;
import Exercicio1.Pessoa;


public class Elevador {
    private int andarAtual;
    private int totalAndares;
    private int capacidadeTotalElevador;
    private int pessoasNoElevador;
    private Pessoa pessoa;

    public Elevador() {
    }

    public int getAndarAtual() {
        return andarAtual;
    }

    public void setAndarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
    }

    public int getTotalAndares() {
        return totalAndares;
    }

    public void setTotalAndares(int totalAndares) {
        this.totalAndares = totalAndares;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getCapacidadeTotalElevador() {
        return capacidadeTotalElevador;
    }

    public void setCapacidadeTotalElevador(int capacidadeTotalElevador) {
        this.capacidadeTotalElevador = capacidadeTotalElevador;
    }

    public int getPessoasNoElevador() {
        return pessoasNoElevador;
    }

    public void setPessoasNoElevador(int pessoasNoElevador) {
        this.pessoasNoElevador = pessoasNoElevador;
    }

    public void inicializa(int capacidadeElevador, int totalAndares) {
        setCapacidadeTotalElevador(capacidadeElevador);
        setTotalAndares(totalAndares);
    }
    public void entra(Pessoa pessoa) {
        if (getPessoasNoElevador() < getCapacidadeTotalElevador() ) {
            setPessoasNoElevador(getPessoasNoElevador() + 1);
        }else {
            System.out.println("Elevador lotado!!!");
        }
    }

    public void sai(Pessoa pessoa) {
        if (getPessoasNoElevador() > 0) {
            setPessoasNoElevador(getPessoasNoElevador() -1);
        }
    }

    public void sobeAndar() {
        if(getAndarAtual() >= 0 && getAndarAtual() < getTotalAndares()) {
            setAndarAtual(getAndarAtual() + 1);
        }else {
            System.out.println("Voce ja esta no ultimo andar!!!");
        }
    }

    public void desceAndar() {
        if(getAndarAtual() > 0 && getAndarAtual() <= getTotalAndares()) {
            setAndarAtual(getAndarAtual() - 1);
        }else {
            System.out.println("Voce ja esta no terreo!!!");
        }
    }
}

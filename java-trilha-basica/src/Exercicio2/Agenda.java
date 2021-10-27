package Exercicio2;

import Exercicio1.Pessoa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Agenda {


    private List<Pessoa> lista = new ArrayList<>();
    private Pessoa pessoa;

    public List<Pessoa> getLista() {
        return lista;
    }

    public void setLista(List<Pessoa> lista) {
        this.lista = lista;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Agenda(){}

    public void armazenaPessoaLista(Pessoa pessoa) {
        lista.add(new Pessoa(pessoa.getNome(), pessoa.calculaAniversario(), pessoa.getAltura()));
    }

    public void removePessoaLista(String nome) {
        Iterator<Pessoa> it = lista.iterator();
        while(it.hasNext()) {
            Pessoa p = it.next();
            if(p.getNome().startsWith(nome)) {
                it.remove();
            }
        }
    }

    public void imprimeAgenda() {
        for(Pessoa p : lista) {
            System.out.println("---------------");
            System.out.println(p.getNome());
            System.out.println(p.getIdade());
            System.out.println(p.getAltura());
            System.out.println("---------------");
        }
    }

    public int buscaPessoa(String nome) {
        for(Pessoa p : lista) {
            if (p.getNome().equals(nome)) {
                return lista.lastIndexOf(p);
            }
        }
        return 99;
    }

    public void imprimePessoa(Integer index) {
        Pessoa pessoaTmp = null;
        for(Pessoa p: lista) {
            pessoaTmp = lista.get(index);
        }
        System.out.println("Nome :" + pessoaTmp.getNome());
        System.out.println("Idade :" + pessoaTmp.getIdade());
        System.out.println("ALtura :" + pessoaTmp.getAltura());
    }





}

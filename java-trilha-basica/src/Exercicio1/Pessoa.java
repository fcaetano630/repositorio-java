package Exercicio1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Pessoa {

    private String nome;
    private String dataNascimento;
    private Double altura;
    private Integer idade;

    public Pessoa(){}

    public Pessoa(String nome, String dataNascimento, Double altura) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.altura = altura;
        this.idade = getIdade();
    }
    public Pessoa(String nome, Integer idade, Double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Integer getIdade() {
        return idade ;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void calculaIdade() {
        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dataNascimento = LocalDate.parse(getDataNascimento(),dataFormatada);
        LocalDate dataAtual = LocalDate.now();

        Long idade = ChronoUnit.YEARS.between(dataNascimento,dataAtual);
        System.out.println(idade + " anos de idade");
    }

    public void mostrarDados() {
        System.out.println("Nome da pessoa: " + getNome());
        System.out.println("Data nascimento da pessoa: " + getDataNascimento());
        System.out.println("Altura da pessoa: " + getAltura() );
    }

    public int calculaAniversario(){
        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(getDataNascimento(),dataFormatada);
        LocalDate dataAtual = LocalDate.now();

         Period p = Period.between(dataNascimento,dataAtual);
         return p.getYears();
    }
}

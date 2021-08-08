package br.com.projeto.cm.model;

import java.util.ArrayList;
import java.util.List;

import br.com.projeto.cm.excecao.ExplosaoException;

public class Campo {
	
	private final int linha;
	private final int coluna;
	
	private boolean aberto;
	private boolean minado;
	private boolean marcado;
	
	private List<Campo> vizinhos = new ArrayList<>();
	
	Campo(int linha,int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	
	 boolean adicionarVizinho(Campo vizinho) {
		
		boolean linhaDiferente = linha != vizinho.linha;
		boolean colunaDiferente = coluna != vizinho.coluna;
		boolean diagonal = linhaDiferente && colunaDiferente;
		
		int diferencaLinha = Math.abs(linha - vizinho.linha);
		int diferencaColuna = Math.abs(coluna - vizinho.coluna);
		int somaGeral = diferencaLinha + diferencaColuna;
		
		if(somaGeral == 1 && !diagonal ) {
			vizinhos.add(vizinho);
			return true;
		}else if(somaGeral == 2 && diagonal) {
			vizinhos.add(vizinho);
			return true;
		} else {
			return false;
		}
	}
	
	void alternarMarcacao() {
		if(!aberto) {
			marcado = !marcado;
		}
	}
	
	boolean abrir() {
		if(!aberto && !marcado) {
			aberto = true;
			
			if(minado) {
				throw new ExplosaoException();
			}
			if(redorSeguro()) {
				vizinhos.forEach(v -> v.abrir());
			}
			return true;
		} else {
		return false;
		}
	}
	
	boolean redorSeguro() {
		return vizinhos.stream().noneMatch(v -> v.minado);
	}
	
	void colocarMina() {
			minado = true;
	}
	
	public boolean isMarcado() {
		return marcado;
	}
	
	void setAberto(boolean aberto) {
		this.aberto = aberto;
	}
	
	public boolean isAberto() {
		return aberto;
	}
	
	public boolean isMinado() {
		return minado;
	}
	
	public int getLinha() {
		return linha;
	}
	
	public int getColuna() {
		return coluna;
	}
	
	 boolean objetivoAlcancado() {
		boolean desvendado = !minado && aberto;	
		boolean protegido = minado && marcado;
		
		return desvendado || protegido; 
	}
	
	long minasNaVizinhanca() {
		return vizinhos.stream().filter(v -> v.minado).count();
	}
	
	void reiniciarJogo () {
		aberto = false;
		minado = false;
		marcado = false;
	}
	
	public String toString() {
		if(marcado) {
			return "x";
		}else if(aberto && minado) {
			return "*";
		}else if(aberto && minasNaVizinhanca() > 0) {
			return Long.toString(minasNaVizinhanca());
		}else if(aberto) {
			return " ";
		}else {
			return "?";
		}
		
	}
}

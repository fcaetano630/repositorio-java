package br.com.projeto.cm;

import br.com.projeto.cm.model.Tabuleiro;
import br.com.projeto.cm.view.TabuleiroConsole;

public class Aplicacao {
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6,6,6);
		new TabuleiroConsole(tabuleiro);
	}

}

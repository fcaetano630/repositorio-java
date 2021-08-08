package br.com.projeto.cm.view;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import br.com.projeto.cm.excecao.ExplosaoException;
import br.com.projeto.cm.excecao.FecharJogoException;
import br.com.projeto.cm.model.Tabuleiro;

public class TabuleiroConsole {
	
	private Tabuleiro tabuleiro;
	private Scanner entrada = new Scanner(System.in);
	
	public TabuleiroConsole(Tabuleiro tabuleiro){
		this.tabuleiro = tabuleiro;
		executarJogo();
	}

	private void executarJogo() {
		try {
			boolean continuar = true;
			while(continuar) {
				cicloDoJogo();
				System.out.println("Quer realizar uma nova partida? [S/n] ");
				String resposta = entrada.nextLine();
				if("n".equalsIgnoreCase(resposta)) {
					continuar = false;
				} else {
					tabuleiro.reiniciarJogo();
				}
			}
			
		} catch (FecharJogoException e) {
			System.out.println("Jogo fechado! Até mais ");
		}finally {
			entrada.close();
		}
	}

	private void cicloDoJogo() {
		try {
			
			while(!tabuleiro.objetivoAlcancado()) {
				System.out.println(tabuleiro);
				
				String digitado = capturarValorDigitado("Digite (x,y):");
				
				Iterator<Integer> iterator = Arrays.stream(digitado.split(",")).map(d -> Integer.parseInt(d.trim()))
						.iterator();
				
				digitado = capturarValorDigitado("1 para abrir ou 2- para (DES)MARCAR ");
				
				if("1".equalsIgnoreCase(digitado)) {
					tabuleiro.abrir(iterator.next(),iterator.next());
				} else if("2".equalsIgnoreCase(digitado)) {
					tabuleiro.marcar(iterator.next(),iterator.next());
				}
			}
			
			System.out.println(tabuleiro);
			System.out.println("Voce ganhou!! Parabens ");
		} catch(ExplosaoException e) {
			System.out.println(tabuleiro);
			System.out.println("Voce perdeu!! Tente novamente ");
		}
	}
	
	private String capturarValorDigitado(String texto) {
		System.out.print(texto);
		String digitado = entrada.nextLine();
		
		if("sair".equalsIgnoreCase(digitado)) {
			throw new FecharJogoException();
		}
		return digitado;
	}
	
}

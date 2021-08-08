package br.com.projeto.cm.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.projeto.cm.excecao.ExplosaoException;

class CampoTeste {
	
	private Campo campo ;
	
	@BeforeEach
	void iniciarCampo() {
		 campo = new Campo(3,3);
	}

	@Test
	void testeVizinhoRealEsquerda() {
		Campo vizinho = new Campo(3,2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDireita() {
		Campo vizinho = new Campo(3,4);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealCima() {
		Campo vizinho = new Campo(2,3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealBaixo() {
		Campo vizinho = new Campo(4,3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDiagonais() {
		Campo diagonalSuperiorEsquerda = new Campo(2,2);
		boolean resultado1 = campo.adicionarVizinho(diagonalSuperiorEsquerda);
		
		
		Campo diagonalSuperiorDireita = new Campo(2,4);
		boolean resultado2 = campo.adicionarVizinho(diagonalSuperiorDireita);
		
		Campo diagonalInferiorEsquerda = new Campo(4,2);
		boolean resultado3 = campo.adicionarVizinho(diagonalInferiorEsquerda);
		
		Campo diagonalInferiorDireita = new Campo(4,4);
		boolean resultado4 = campo.adicionarVizinho(diagonalInferiorDireita);
		
		assertTrue(resultado1);
		assertTrue(resultado2);
		assertTrue(resultado3);
		assertTrue(resultado4);
	}
	
	@Test
	void testeNaoVizinho() {
		Campo vizinho = new Campo(6,3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertFalse(resultado);
	}
	
	@Test
	void atributoMarcado() {
		
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void alternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void alternarSegundaMarcacao() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void abrirCampoSemMinaSemMarcacao() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void abrirCampoSemMinaComMarcacao() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void abrirCampoComMinaMarcado() {
		campo.alternarMarcacao();
		campo.colocarMina();
		assertFalse(campo.abrir());
	}
	
	@Test
	void abrirCampoMinado() {
		campo.colocarMina();
		
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});
	}
	
	@Test
	void abrirComVizinho() {
		Campo campo1 = new Campo(1,1);
		Campo campo2 = new Campo(2,2);
		
		campo2.adicionarVizinho(campo1);
		campo.adicionarVizinho(campo2);
		campo.abrir();
		
		assertTrue(campo2.isAberto() && campo1.isAberto());
	}
	
	@Test
	void abrirComVizinhoMinado() {
		Campo campo1 = new Campo(1,1);
		Campo campo2 = new Campo(1,2);
		campo2.colocarMina();
		
		Campo campo3 = new Campo(2,2);
		
		campo3.adicionarVizinho(campo1);
		campo3.adicionarVizinho(campo2);
		campo.adicionarVizinho(campo3);
		
		campo.abrir();
		
		assertTrue(campo3.isAberto() && !campo1.isAberto());
	}




}

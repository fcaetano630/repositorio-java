package br.com.alura.forum.repository;

import br.com.alura.forum.controller.dto.TopicoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.forum.modelo.Topico;

import java.util.List;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {


    List<Topico> findByCursoNome(String nomeCurso);
    
    List<Topico> findByCurso_Categoria(String nomeCategoria);
}

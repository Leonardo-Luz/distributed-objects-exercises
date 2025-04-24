package br.edu.ifrs.osorio.tads.aula07.repository;

import br.edu.ifrs.osorio.tads.aula07.entity.Colaborador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ColaboradorRepository extends CrudRepository<Colaborador, Integer> {
    @Query("SELECT c FROM Colaborador c WHERE c.nome = ?1")
    List<Colaborador> buscaColaboradorPorNome(String nome);


    @Query("SELECT c.nome FROM Colaborador c WHERE c.especialidade = :especialidade")
    List<String> buscaColaboradorPorEspecialidade(@Param("especialidade") String especialidade);



}



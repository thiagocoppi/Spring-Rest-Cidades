package com.example.cidades.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.cidades.demo.model.Cidade;

@Repository
public interface CidadeRepository extends CrudRepository<Cidade, Long> {
	public List<Cidade> findByCapitalOrderByNomeAsc(boolean capital);
	
	@Query("select a, COUNT(a) FROM Cidade a GROUP BY a.estado")
	public List<Object[]> getQtdCidadesPorEstado();
	
	public Cidade findByIdIbge(long idibge);
	
	public long countByEstado(String estado);
	
	public List<Cidade> findByEstado(String estado);
}

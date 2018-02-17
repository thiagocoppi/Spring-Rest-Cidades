package com.example.cidades.demo.services;

import java.util.List;

import com.example.cidades.demo.model.Cidade;

public interface CidadeService {
	Iterable<Cidade> listAll();
	
	Cidade listById(Long id);

	void deletarCidade(Long id);
	
	Cidade inserirCidade(Cidade cidade);
	
	Cidade alterarCidade(Cidade cidade);
	
	Long contarCidadePorEstado(String Estado);
	
	List<Cidade> listAllCapital(boolean isCapital);
	
	List<Cidade> listCidadesPorEstado(String estado);
	
	void removeCidade(long id);
	
	List<Object[]> getQtdCidadesEstado();
	
	
	
}

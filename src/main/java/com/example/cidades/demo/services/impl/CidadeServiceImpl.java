package com.example.cidades.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cidades.demo.model.Cidade;
import com.example.cidades.demo.repository.CidadeRepository;
import com.example.cidades.demo.services.CidadeService;

@Service
public class CidadeServiceImpl implements CidadeService{
	@Autowired
	private CidadeRepository cidadeRP;

	@Override
	public Iterable<Cidade> listAll() {
		return this.cidadeRP.findAll();
	}

	@Override
	public Cidade listById(Long id) {
		return this.cidadeRP.findByIdIbge(id);
	}

	@Override
	public Long contarCidadePorEstado(String estado) {
		return this.cidadeRP.countByEstado(estado);
	}

	@Override
	public List<Cidade> listAllCapital(boolean isCapital) {
		return this.cidadeRP.findByCapitalOrderByNomeAsc(true);
	}

	@Override
	public void deletarCidade(Long id) {
		this.cidadeRP.delete(id);
	}

	@Override
	public Cidade inserirCidade(Cidade cidade) {
		return cidadeRP.save(cidade);
	}

	@Override
	public Cidade alterarCidade(Cidade cidade) {
		return this.cidadeRP.save(cidade);
	}

	@Override
	public List<Cidade> listCidadesPorEstado(String estado) {
		return this.cidadeRP.findByEstado(estado);
	}

	@Override
	public void removeCidade(long id) {
		this.cidadeRP.delete(id);
	}

	@Override
	public List<Object[]> getQtdCidadesEstado() {
		return this.cidadeRP.getQtdCidadesPorEstado();
	}


}

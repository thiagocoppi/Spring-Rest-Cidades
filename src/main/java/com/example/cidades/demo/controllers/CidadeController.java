package com.example.cidades.demo.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.cidades.demo.model.Cidade;
import com.example.cidades.demo.model.Estados;
import com.example.cidades.demo.response.Responses;
import com.example.cidades.demo.services.CidadeService;


@RestController
@RequestMapping(path = "/api/cidade")
public class CidadeController {
	@Autowired
	private CidadeService cidadeService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Responses<Iterable<Cidade>>> listarTodos() {
		return ResponseEntity.ok(new Responses<Iterable<Cidade>>(this.cidadeService.listAll()));
	}

	@RequestMapping(path = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Responses<Cidade>> getCidadeId(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok(new Responses<Cidade>(this.cidadeService.listById(id)));
	}

	 @RequestMapping(path = "/capitais", method = RequestMethod.GET)
	 public ResponseEntity<Responses<List<Cidade>>> getCapitais(){
		 return ResponseEntity.ok(new Responses<List<Cidade>>(this.cidadeService.listAllCapital(true)));
	 }
	
	@RequestMapping(path = "/count/{estado}",method = RequestMethod.GET)
	public ResponseEntity<Responses<Long>> getQtdCidades(@PathVariable(name = "estado") String estadoParam) {
		if(estadoParam.isEmpty()) return ResponseEntity.ok(new Responses<Long>(Long.MIN_VALUE));
		return ResponseEntity.ok(new Responses<Long>(this.cidadeService.contarCidadePorEstado(estadoParam)));
	}
	
	@RequestMapping(path = "/listar/{estado}",method = RequestMethod.GET)
	public ResponseEntity<Responses<List<Cidade>>> getCidadesPorEstado(@PathVariable(name = "estado") String estado){
		return ResponseEntity.ok(new Responses<List<Cidade>>(this.cidadeService.listCidadesPorEstado(estado)));
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Responses<Cidade>> inserirCidade(@RequestBody Cidade cidade) {
		return ResponseEntity.ok(new Responses<Cidade>(this.cidadeService.inserirCidade(cidade)));
	}
	
	@RequestMapping(path = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Responses<Cidade>> alterarCidade(@PathVariable(name = "id") Long id,@RequestBody Cidade cidade) {
		cidade.setIdIbge(id);
		return ResponseEntity.ok(new Responses<Cidade>(this.cidadeService.alterarCidade(cidade)));
	}

	@RequestMapping(path = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Responses<Integer>> removerCidade(@PathVariable(name = "id") Long id) {
		this.cidadeService.removeCidade(id);
		return ResponseEntity.ok(new Responses<Integer>(1));
	}
	
	@RequestMapping(path = "/count",method = RequestMethod.GET)
	public ResponseEntity<Responses<Long>> getQtdTotal() {
		return ResponseEntity.ok(new Responses<Long>(this.cidadeService.listAll().spliterator().getExactSizeIfKnown()));
	}
	
	@RequestMapping(path = "/estadomaiormenor",method = RequestMethod.GET)
	public ResponseEntity<String> getMaiorMenorUF(){
		List<Object[]> qtdCity = this.cidadeService.getQtdCidadesEstado();
		String retorno = "";
		Object[] first = qtdCity.get(0);
		
		long maior = (long) first[1];
		long menor = (long) first[1];
		
		Cidade esMaior = (Cidade)first[0];
		Cidade esMenor = (Cidade)first[0];
		for(Object[] x : qtdCity){
			Cidade estadoAtu = (Cidade)x[0];
			long atual = (long) x[1];
			//maior
			if(atual > maior){
				maior = atual;
				esMaior = estadoAtu;
			}
			//menor
			if(atual < menor){
				menor = atual;
				esMenor = estadoAtu;
			}
			
		}
		retorno = "O maior estado é " + esMaior.getEstado() + " e o menor é " + esMenor.getEstado();
		return ResponseEntity.ok(retorno);
	}
	
	@RequestMapping(path = "/populardb",method = RequestMethod.GET)
	public String popular() {
		String caminho = System.getProperty("user.home", "/Desktop");
		caminho += "/Desktop/cidades.csv";
		BufferedReader br = null;
		String cidade = "";
		try {
			br = new BufferedReader(new FileReader(caminho));
			cidade = br.readLine();// pular o cabeçalho
			while ((cidade = br.readLine()) != null) {
				String[] arrayCidades = cidade.split(",");
				Cidade cidadeInserir = new Cidade();
				cidadeInserir.setIdIbge(Long.parseLong(arrayCidades[0]));
				cidadeInserir.setNome(arrayCidades[2]);
				cidadeInserir.setEstado(this.getEstado(arrayCidades[1].toUpperCase()));
				cidadeInserir.setCapital(new Boolean(arrayCidades[3]));
				cidadeInserir.setLongitude(Double.parseDouble(arrayCidades[4]));
				cidadeInserir.setLatitude(Double.parseDouble(arrayCidades[5]));
				cidadeInserir.setNoAccents(arrayCidades[6]);
				cidadeInserir.setAlternativenames(arrayCidades[7]);
				cidadeInserir.setMicroregion(arrayCidades[8]);
				cidadeInserir.setMesoregion(arrayCidades[9]);
				cidadeInserir = this.cidadeService.inserirCidade(cidadeInserir);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Populado com sucesso !";
	}

	private Estados getEstado (String estado){
		switch (estado) {
		case "AC":
			return Estados.AC;
		case "AL":
			return Estados.AL;
		case "AM":
			return Estados.AM;
		case "AP":
			return Estados.AP;
		case "BA":
			return Estados.BA;
		case "ES":
			return Estados.ES;
		case "CE":
			return Estados.CE;
		case "DF":
			return Estados.DF;
		case "GO":
			return Estados.GO;
		case "MA":
			return Estados.MA;
		case "MT":
			return Estados.MT;
		case "MS":
			return Estados.MS;
		case "MG":
			return Estados.MG;
		case "PA":
			return Estados.PA;
		case "PB":
			return Estados.PB;
		case "PR":
			return Estados.PR;
		case "PE":
			return Estados.PE;
		case "PI":
			return Estados.PI;
		case "RJ":
			return Estados.RJ;
		case "RN":
			return Estados.RN;
		case "RS":
			return Estados.RS;
		case "RO":
			return Estados.RO;
		case "RR":
			return Estados.RR;
		case "SC":
			return Estados.SC;
		case "SP":
			return Estados.SP;
		case "SE":
			return Estados.SE;
		case "TO":
			return Estados.TO;
		default :
			return null;
	}
	}
}

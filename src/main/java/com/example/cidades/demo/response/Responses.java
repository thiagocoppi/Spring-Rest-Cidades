package com.example.cidades.demo.response;

import java.util.List;

/**
 * Classe genérica para devolução de requests
 *
 * @param <T> 
 */
public class Responses<T> {	
	private T data;
	private List<String> erros;
	private String oneResult;
	
	public Responses(T data){
		this.data = data;
	}
	
	public Responses(List<String> erros) {
		this.erros = erros;
	}
	
	public Responses(String result) {
		this.oneResult = result;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public List<String> getErros() {
		return erros;
	}
	
	public void setErros(List<String> erros) {
		this.erros = erros;
	}

	public String getOneResult() {
		return oneResult;
	}

	public void setOneResult(String oneResult) {
		this.oneResult = oneResult;
	}

}
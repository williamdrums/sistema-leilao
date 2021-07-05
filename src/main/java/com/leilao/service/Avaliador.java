package com.leilao.service;

import com.leilao.dominio.Lance;
import com.leilao.dominio.Leilao;

public class Avaliador {

	private Double maiorDeTodos = Double.NEGATIVE_INFINITY;//constante que guarda o menor valor dentro de um Double
	private Double menorDeTodos = Double.POSITIVE_INFINITY;//constante que guarda o maior valor dentro de um Double 

	public void avalia(Leilao leilao) {

		for(Lance lance : leilao.getLances()) {
			if(lance.getValor() > maiorDeTodos) maiorDeTodos = lance.getValor();
			if(lance.getValor() < menorDeTodos ) menorDeTodos = lance.getValor();
		}
	}

	public Double getMaiorLance() {
		return maiorDeTodos;
	}

	public Double getMenorLance() {
		return menorDeTodos;
	}
}

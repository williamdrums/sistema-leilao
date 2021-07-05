package com.leilao.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.leilao.dominio.Lance;
import com.leilao.dominio.Leilao;

public class Avaliador {

	private Double maiorDeTodos = Double.NEGATIVE_INFINITY;//constante que guarda o menor valor dentro de um Double
	private Double menorDeTodos = Double.POSITIVE_INFINITY;//constante que guarda o maior valor dentro de um Double 
	private List<Lance> maiores;

	public void avalia(Leilao leilao) {

		for(Lance lance : leilao.getLances()) {
			if(lance.getValor() > maiorDeTodos) maiorDeTodos = lance.getValor();
			if(lance.getValor() < menorDeTodos ) menorDeTodos = lance.getValor();
		}

		maiores = new ArrayList<Lance>(leilao.getLances());
		Collections.sort(maiores,new Comparator<Lance>() {

			@Override //ordena de forma decrescente
			public int compare(Lance o1, Lance o2) {

				if(o1.getValor() < o2.getValor()) return 1;
				if(o1.getValor() > o2.getValor()) return -1;

				return 0;
			}
		});
		maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size()); // 0 pra pegar o primeiro elemento da lista e 3 referente a quantidade de elementos que serão pegos
	}

	public List<Lance> getTresMaiores() {
		return maiores;
	}

	public Double getMaiorLance() {
		return maiorDeTodos;
	}

	public Double getMenorLance() {
		return menorDeTodos;
	}
}

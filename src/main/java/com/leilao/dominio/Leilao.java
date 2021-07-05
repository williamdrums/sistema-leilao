package com.leilao.dominio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private Long leilaoId;
	private String descricao;
	private List<Lance> lances;

	public Leilao(Long leilaoId,String descricao) {

		this.leilaoId =  leilaoId;
		this.descricao =  descricao;
		this.lances =  new ArrayList<Lance>();
	}


	public void propoe(Lance lance) {
		if(lances.isEmpty() || podeDarLance(lance.getUsuario())) {
			lances.add(lance);
		}
	}


	private boolean podeDarLance(Usuario usuario) {
		return !ultimoLanceDado().getUsuario().equals(usuario) && qtdLancesDoUsuario(usuario) < 5;
	}

	private int qtdLancesDoUsuario(Usuario usuario) {
		int total = 0;
		for(Lance l : lances) {
			if(l.getUsuario().equals(usuario)) total++;
		}
		return total;
	}

	private Lance ultimoLanceDado() {
		return lances.get(lances.size()- 1);
	}

	public Long getLeilaoId() {
		return leilaoId;
	}

	public void setLeilaoId(Long leilaoId) {
		this.leilaoId = leilaoId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

	public void setLances(List<Lance> lances) {
		this.lances = lances;
	}



}

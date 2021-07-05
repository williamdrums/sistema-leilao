package com.leilao.builder;

import com.leilao.dominio.Lance;
import com.leilao.dominio.Leilao;
import com.leilao.dominio.Usuario;

public class CriadorDeLeilao {

	private Leilao leilao;

	public CriadorDeLeilao para(Long id,String descricao) {
		this.leilao =  new Leilao(id,descricao);
		return this;
	}

	public CriadorDeLeilao lance(Long lanceId,Usuario usuario,Double valor) {
		leilao.propoe(new Lance(lanceId,usuario,valor));
		return this;
	}

	public Leilao constroi() {
		return leilao;
	}

}

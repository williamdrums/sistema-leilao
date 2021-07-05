package com.leilao.teste;

import org.junit.Test;

import com.leilao.dominio.Lance;
import com.leilao.dominio.Leilao;
import com.leilao.dominio.Usuario;
import com.leilao.service.Avaliador;

import org.junit.Assert;

public class TesteDoAvaliador {

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		
		Usuario joao = new Usuario(1L,"João");
		Usuario jose = new Usuario(2L,"José");
		Usuario maria = new Usuario(2L,"Maria");
		
		
		Leilao leilao = new Leilao(1L,"Playstation 5 Novo");
		
		leilao.propoe(new Lance(1L,joao,250.0));
		leilao.propoe(new Lance(2L,jose,300.0));
		leilao.propoe(new Lance(3L,maria,400.0));
		
		Avaliador leiloeira = new Avaliador();
		leiloeira.avalia(leilao);
		
		Double maiorEsperado = 400.0;
		Double menorEsperado = 250.0;
		
		Assert.assertEquals(maiorEsperado,leiloeira.getMaiorLance(),0.00001);
		Assert.assertEquals(menorEsperado,leiloeira.getMenorLance(),0.00001);
		
		
	}
}

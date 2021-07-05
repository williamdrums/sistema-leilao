package com.leilao.teste;

import org.junit.Test;

import com.leilao.dominio.Lance;
import com.leilao.dominio.Leilao;
import com.leilao.dominio.Usuario;
import com.leilao.service.Avaliador;

import static org.junit.Assert.assertEquals;

import java.util.List;;

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

		assertEquals(maiorEsperado,leiloeira.getMaiorLance(),0.00001);
		assertEquals(menorEsperado,leiloeira.getMenorLance(),0.00001);


	}

	@Test
	public void deveEntenderLeilaoComApenasUmLance() {

		Usuario joao = new Usuario(1L,"João");

		Leilao leilao = new Leilao(1L,"Playstation 5 Novo");

		leilao.propoe(new Lance(1L,joao,1000.0));

		Avaliador leiloeiro =  new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(1000.0, leiloeiro.getMaiorLance(),0.00001);
		assertEquals(1000.0, leiloeiro.getMenorLance(),0.00001);
	}

	@Test
	public void deveEncontrarOsTresMaioresLances() {

		Usuario joao = new Usuario(1L,"João");
		Usuario maria = new Usuario(2L,"Maria");

		Leilao leilao = new Leilao(1L,"Playstation 5 Novo");

		leilao.propoe(new Lance(1L,joao,100.0));
		leilao.propoe(new Lance(2L,joao,200.0));
		leilao.propoe(new Lance(3L,joao,300.0));
		leilao.propoe(new Lance(4L,joao,400.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		leiloeiro.getTresMaiores();
		
		List<Lance> maiores = leiloeiro.getTresMaiores();
		
		assertEquals(3, maiores.size());
		assertEquals(400, maiores.get(0).getValor(),0.00001);
		assertEquals(300, maiores.get(1).getValor(),0.00001);
		assertEquals(200, maiores.get(2).getValor(),0.00001);



	}

}

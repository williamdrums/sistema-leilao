package com.leilao.teste;

import org.junit.Before;
import org.junit.Test;

import com.leilao.builder.CriadorDeLeilao;
import com.leilao.dominio.Lance;
import com.leilao.dominio.Leilao;
import com.leilao.dominio.Usuario;
import com.leilao.service.Avaliador;

import static org.junit.Assert.assertEquals;

import java.util.List;;

public class TesteDoAvaliador {

	private Avaliador leiloeiro;
	private Usuario joao;
	private Usuario jose;
	private Usuario maria;


	@Before
	public void criaAvaliador() {
		this.leiloeiro = new Avaliador();
		this.joao = new Usuario(1L,"João");
		this.jose = new Usuario(2L,"José");
		this.maria =  new Usuario(3L,"Maria");
	}

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {

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

		Leilao leilao = new Leilao(1L,"Playstation 5 Novo");

		leilao.propoe(new Lance(1L,joao,1000.0));

		Avaliador leiloeiro =  new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(1000.0, leiloeiro.getMaiorLance(),0.00001);
		assertEquals(1000.0, leiloeiro.getMenorLance(),0.00001);
	}

	@Test
	public void deveEncontrarOsTresMaioresLances() {

		Leilao leilao = new CriadorDeLeilao().para(1L,"Playstation 5 Novo")
		.lance(1L,joao,100.0)
		.lance(2L,maria,200.0)
		.lance(1L,joao,300.0)
		.lance(2L,maria,400.0)
		.constroi();
		
		
		leiloeiro.avalia(leilao);

		leiloeiro.getTresMaiores();

		List<Lance> maiores = leiloeiro.getTresMaiores();

		assertEquals(3, maiores.size());
		assertEquals(400, maiores.get(0).getValor(),0.00001);
		assertEquals(300, maiores.get(1).getValor(),0.00001);
		assertEquals(200, maiores.get(2).getValor(),0.00001);

	}

}

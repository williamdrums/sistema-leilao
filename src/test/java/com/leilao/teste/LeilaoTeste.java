package com.leilao.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.leilao.dominio.Lance;
import com.leilao.dominio.Leilao;
import com.leilao.dominio.Usuario;

public class LeilaoTeste {

	@Test
	public void deveReceberUmLance() {

		Leilao leilao = new Leilao(1L,"Macbook Pro 16 M1");

		//testa nenhum lance dado
		assertEquals(0, leilao.getLances().size());

		leilao.propoe(new Lance(1L,new Usuario(1L,"Steve Jobs"),2000.0));

		assertEquals(1, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(0).getValor(),0.00001);

	}

	@Test
	public void deveReceberVariosLances() {
		Leilao leilao = new Leilao(1L,"Macbook Pro 16 M1");
		leilao.propoe(new Lance(1L,new Usuario(1L,"Steve Jobs"),2000.0));
		leilao.propoe(new Lance(2L,new Usuario(1L,"Steve Wozniak"),3000.0));

		assertEquals(2, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(0).getValor());
		assertEquals(3000.0, leilao.getLances().get(1).getValor());


	}

	@Test
	public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {

		Leilao leilao = new Leilao(1L,"Macbook Pro 16 M1");
		Usuario stevejobs = new Usuario(1L,"Steve Jobs");

		leilao.propoe(new Lance(1L,stevejobs,2000.0));
		leilao.propoe(new Lance(1L,stevejobs,3000.0));

		assertEquals(1,leilao.getLances().size());
		assertEquals(2000.0,leilao.getLances().get(0).getValor(),0.00001);
	}

	@Test
	public void naoDeveAceitarMaisDoQueCincoLancesDeUmMesmoUsuario() {

		Leilao leilao = new Leilao(1L,"Macbook Pro 16 M1");
		Usuario steveJobs = new Usuario(1L,"Steve Jobs");
		Usuario billGates = new Usuario(2L,"Bill Gates");

		leilao.propoe(new Lance(1L,steveJobs,2000.0));
		leilao.propoe(new Lance(1L,billGates,3000.0));

		leilao.propoe(new Lance(1L,steveJobs,4000.0));
		leilao.propoe(new Lance(1L,billGates,5000.0));

		leilao.propoe(new Lance(1L,steveJobs,6000.0));
		leilao.propoe(new Lance(1L,billGates,7000.0));

		leilao.propoe(new Lance(1L,steveJobs,8000.0));
		leilao.propoe(new Lance(1L,billGates,9000.0));

		leilao.propoe(new Lance(1L,steveJobs,10000.0));
		leilao.propoe(new Lance(1L,billGates,11000.0));

		//lance que deve ser ignorado
		leilao.propoe(new Lance(1l,steveJobs,12000.0));

		assertEquals(10,leilao.getLances().size());
		assertEquals(11000,leilao.getLances().get(leilao.getLances().size() - 1).getValor(),0.00001);
	}

}

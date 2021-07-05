package com.leilao.dominio;

public class Usuario {

	private Long usuarioId;
	private String nome;

	public Usuario(Long usuarioId, String nome) {
		this.usuarioId = usuarioId;
		this.nome = nome;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}

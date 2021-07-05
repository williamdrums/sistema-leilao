package com.leilao.dominio;

public class Lance {

	private Long lanceId;
	private Usuario usuario;
	private Double valor;

	public Lance(Long lanceId, Usuario usuario, Double valor) {

		this.lanceId = lanceId;
		this.usuario = usuario;
		this.valor = valor;
	}


	public Long getLanceId() {
		return lanceId;
	}
	public void setLanceId(Long lanceId) {
		this.lanceId = lanceId;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

}

package br.edu.unoesc.trabalhopos;

public class KartItem {
	
	private Produto produto;
	private Integer quantidade;
	
	public KartItem() {
		super();
	}

	public KartItem(Produto produto, Integer quantidade) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}

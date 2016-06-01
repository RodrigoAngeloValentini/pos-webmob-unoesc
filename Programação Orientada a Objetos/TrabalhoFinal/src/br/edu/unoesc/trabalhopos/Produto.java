package br.edu.unoesc.trabalhopos;

public class Produto {
	
	private String nome;
	private Double preco;
	private Tipo tipo;
	
	public Produto(){
		super();
	}
	
	public Produto(String nome, Double preco, Tipo tipo) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public Double getDesconto(){
		String tipo = this.getTipo().getNome();
		double preco = 0.0;
		
		if(tipo=="Bebida"){
			preco = this.getPreco() - (this.getPreco() * 0.05);
			return preco;
		}
		
		if(tipo=="Vestuario"){
			preco = this.getPreco() - (this.getPreco() * 0.25);
			return preco;
		}
		
		preco = this.getPreco();
		return preco;
		
	}
	
	
}

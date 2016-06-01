package br.edu.unoesc.trabalhopos;

import java.util.ArrayList;
import java.util.List;

public class Kart {
	
	private List<KartItem> items;
	
	public Kart() {
		items = new ArrayList<>();
	}
	
	public Kart(List<KartItem> items) {
		this.items = items;
	}
	
	public List<KartItem> getItens() {
		return items;
	}

	public void setItens(List<KartItem> items) {
		this.items = items;
	}
	
	public void addKartItem(KartItem item) {
	
		this.items.add(item);
	}
	
	public Double getValorTotal(){
		Double total = 0.0;
		
		for (KartItem item : getItens()) {
			Double preco = item.getProduto().getDesconto();
			total += preco * item.getQuantidade();
		}
		
		return total;
	}
}

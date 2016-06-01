package br.edu.unoesc.trabalhopos;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class KartTest {
	

	private Tipo bebida;
	private Tipo vestuario;
	private Tipo mobilia;
	
	
	private Produto vodka;
	private Produto sofa;
	private Produto camisa;
	
	@Before
	public void before(){
		bebida = new Tipo("Bebida");
		vestuario = new Tipo("Vestuario");
		mobilia = new Tipo("Mobilia");
		
		vodka = new Produto("Vodka",20.00,bebida);
		sofa = new Produto("Sofá",300.00,mobilia);
		camisa = new Produto("Camisa",60.00,vestuario);
	}
	
	@Test
	public void testIncluirProdutos(){
		KartItem item1 = new KartItem(vodka,2);
		KartItem item2 = new KartItem(sofa,1);
		KartItem item3 = new KartItem(camisa,3);
		
		Kart kart = new Kart();

		kart.addKartItem(item1);
		kart.addKartItem(item2);
		kart.addKartItem(item3);	
	}
	
	@Test
	public void testValorProduto(){
		assertThat(sofa.getPreco(), is(300.0));
	}
	
	@Test
	public void testValorTotalKart(){
		KartItem item1 = new KartItem(vodka,2);
		KartItem item2 = new KartItem(sofa,1);
		KartItem item3 = new KartItem(camisa,3);
		
		Kart kart = new Kart();

		kart.addKartItem(item1);
		kart.addKartItem(item2);
		kart.addKartItem(item3);
		
		Double total = kart.getValorTotal();
	}
	
	@Test
	public void testVerificaDescontoBebida(){
		KartItem item = new KartItem(vodka, 1);

		Kart carrinho = new Kart();
		carrinho.addKartItem(item);

		// o preço da vodka é 20.0 porém com desconto fica 19.0
		assertThat(carrinho.getValorTotal(), is(19.0));
	}
	
	@Test
	public void testVerificaDescontoVestuario(){
		KartItem item = new KartItem(camisa, 2);

		Kart carrinho = new Kart();
		carrinho.addKartItem(item);

		// o preço de duas camisas é 120 porém com desconto de 25% fica 90
		assertThat(carrinho.getValorTotal(), is(90.00));
	}
}

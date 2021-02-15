package br.edu.maratona.generics.classesgenericas;

import java.util.ArrayList;
import java.util.List;

public class GenericClassTeste 
{	public static void main(String[] args) 
	{	CarroAlugavel ca = new CarroAlugavel();
		Carro carroAlugado = ca.getCarroDipsonivel();
		System.out.println("Usando o carro por um mês");
		ca.devolverCarro(carroAlugado);
	}
}
/*Criação de objetos que possam ser alugados, sabemos
 *que só podemos alugar se estiver disponível.*/
class CarroAlugavel
{	private List<Carro> carrosDisponíveis = new ArrayList<>();
	
	/*Bloco de inicialização*/
	{	this.carrosDisponíveis.add(new Carro("Gol"));
		this.carrosDisponíveis.add(new Carro("BMW"));
	}
	
	public Carro getCarroDipsonivel()
	{	Carro carro = this.carrosDisponíveis.remove(0);
		System.out.println("Alugando carro: " + carro);
		System.out.println("Carros disponíveis " + this.carrosDisponíveis);
		return carro;
	}
	
	public void devolverCarro(Carro carro)
	{	System.out.println("Devolvendo carro " + carro);
		this.carrosDisponíveis.add(carro);
		System.out.println("Carros disponíveis " + this.carrosDisponíveis);
	}
}
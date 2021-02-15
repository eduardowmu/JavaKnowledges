package br.edu.maratona.generics.classesgenericas;

import java.util.ArrayList;
import java.util.List;

public class GenericClassTeste 
{	public static void main(String[] args) 
	{	CarroAlugavel ca = new CarroAlugavel();
		Carro carroAlugado = ca.getCarroDipsonivel();
		System.out.println("Usando o carro por um m�s");
		ca.devolverCarro(carroAlugado);
	}
}
/*Cria��o de objetos que possam ser alugados, sabemos
 *que s� podemos alugar se estiver dispon�vel.*/
class CarroAlugavel
{	private List<Carro> carrosDispon�veis = new ArrayList<>();
	
	/*Bloco de inicializa��o*/
	{	this.carrosDispon�veis.add(new Carro("Gol"));
		this.carrosDispon�veis.add(new Carro("BMW"));
	}
	
	public Carro getCarroDipsonivel()
	{	Carro carro = this.carrosDispon�veis.remove(0);
		System.out.println("Alugando carro: " + carro);
		System.out.println("Carros dispon�veis " + this.carrosDispon�veis);
		return carro;
	}
	
	public void devolverCarro(Carro carro)
	{	System.out.println("Devolvendo carro " + carro);
		this.carrosDispon�veis.add(carro);
		System.out.println("Carros dispon�veis " + this.carrosDispon�veis);
	}
}
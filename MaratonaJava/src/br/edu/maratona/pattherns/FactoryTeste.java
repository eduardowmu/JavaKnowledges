package br.edu.maratona.pattherns;

import br.edu.maratona.pattherns.entities.Moeda;
import br.edu.maratona.pattherns.entities.Pais;

public class FactoryTeste 
{	public static void main(String[] args) 
	{	Moeda moeda = MoedaFactory.createCoin(Pais.BRASIL);
		Moeda moeda2 = MoedaFactory.createCoin(Pais.EUA);
		System.out.println(moeda.getSimbolo());
		System.out.println(moeda2.getSimbolo());
	}
}
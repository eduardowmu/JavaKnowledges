package br.edu.maratona.comportamento.strategy;

import br.edu.maratona.comportamento.Carro;

public class CarrosCorVerdePredicate implements CarroPredicate 
{	@Override public boolean teste(Carro carro) 
	{	return false;
	}

}

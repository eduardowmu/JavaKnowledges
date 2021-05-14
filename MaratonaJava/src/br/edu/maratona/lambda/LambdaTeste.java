package br.edu.maratona.lambda;

import br.edu.maratona.comportamento.Carro;
import br.edu.maratona.comportamento.strategy.CarroPredicate;

public class LambdaTeste 
{	public static void main(String[] args)
	{ /*
		 * CarroPredicate carroPredicate = new CarroPredicate() { @Override public
		 * boolean teste(Carro carro) {return carro.getCor().equals("verde");} };
		 * System.out.println(carroPredicate.teste(new Carro("verde", 2011)));
		 */
		CarroPredicate carroPredicate = (Carro carro) -> carro.getCor().equals("verde");
		//ou CarroPredicate carroPredicate = (Carro carro) -> {return carro.getCor().equals("verde");}
		System.out.println(carroPredicate.teste(new Carro("verde", 2011)));
		Runnable run = () -> System.out.println("Dentro da run");
		new Thread(run).start();
	}
}
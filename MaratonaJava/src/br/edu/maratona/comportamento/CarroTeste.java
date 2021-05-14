package br.edu.maratona.comportamento;

import java.util.List;
import java.util.function.Predicate;

import br.edu.maratona.comportamento.strategy.CarroPredicate;
import br.edu.maratona.comportamento.strategy.CarrosCorVerdePredicate;
import br.edu.maratona.comportamento.strategy.CarrosDezAnosRecentePredicate;

import static java.util.Arrays.asList;

import java.util.ArrayList;

public class CarroTeste 
{	private static List<Carro> filtroCarrosVerdes(List<Carro> carros, String cor)
	{	List<Carro> result = new ArrayList<>();
		for(Carro carro:carros)
		{	if(carro.getCor().equalsIgnoreCase(cor))
			{result.add(carro);}
		}
		return result;
	}

	public static List<Carro> filtrarCarros(List<Carro> carros, CarroPredicate carroPredicate)
	{	List<Carro> result = new ArrayList<>();
		for(Carro carro:carros)
		{	if(carroPredicate.teste(carro))
			{result.add(carro);}
		}
		return result;
	}
	/*um método bem genérico*/
	public static <T> List<T> filtrar(List<T> lista, Predicate<T> predicate)
	{	List<T> result = new ArrayList<>();
		for(T e:lista)
		{	if(predicate.test(e))
			{result.add(e);}
		}
		return result;
	}

	public static void main(String[] args) 
	{	List<Carro> carros = asList(new Carro("verde", 2011), 
									new Carro("vermelho", 1995),
									new Carro("preto", 2017));
		List<Integer> numeros = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println(filtroCarrosVerdes(carros, "vermelho"));
		/*Agora, ao invés de ficar fazendo chamadas de vários métodos
		 *iremos sempre chamar por um único método*/
		System.out.println(filtrarCarros(carros, new CarrosCorVerdePredicate()));
		System.out.println(filtrarCarros(carros, new CarrosDezAnosRecentePredicate()));
		/*Podemos também utilizar classes anonimas*/
		System.out.println(filtrarCarros(carros, new CarroPredicate()
		{	@Override public boolean teste(Carro carro) 
			{return carro.getCor().equals("verde");}	
		}));
		
		System.out.println(filtrar(carros, new Predicate<Carro>()
		{	@Override public boolean test(Carro carro) 
			{return carro.getCor().equals("verde");}
		}));
		
		System.out.println(filtrar(numeros, new Predicate<Integer>()
		{	@Override public boolean test(Integer numero) 
			{return numero % 2 == 0;}
		}));
	}
}
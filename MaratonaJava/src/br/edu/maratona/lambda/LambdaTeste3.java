package br.edu.maratona.lambda;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import br.edu.maratona.comportamento.Carro;

public class LambdaTeste3 
{	public static void main(String[] args) 
	{	forEach(asList("Willian", "DevDojo", "facebook.com/devedojo"), 
			//(String s) -> System.out.println(s));
			System.out::println);
	
		List<Carro> carros = asList(new Carro("vermelho", 2011), 
			new Carro("preto", 2010), new Carro("verde", 2009));
		
		/*Deixando nossa lista de carros em órdem por cor*/
		/*Collections.sort(carros, new Comparator<Carro>()
		{	@Override public int compare(Carro c1, Carro c2) 
			{return c1.getCor().compareToIgnoreCase(c2.getCor());}	
		}); OU PODEMOS FAZER DE UMA FORMA MAIS SIMPLIFICADA, COMO ABAIXO*/
		
		//Collections.sort(carros, (c1, c2) -> c1.getCor().compareToIgnoreCase(c2.getCor()));
		
		//de forma mais simplificada: referencia para um método estatico
		Collections.sort(carros, ComparadorCarro::compareByColor);
		System.out.println(carros);
		
		//Referencia a uma intancia de metodo de um objeto particular
		ComparadorCarro cc = new ComparadorCarro();
		Collections.sort(carros, cc::compareByYear);
		System.out.println(carros);
		
		//referência a um método de instância de um objeto arbitrário de um tipo particular
		List<String> nomes = asList("Eduardo", "Amanda", "Willian", "Fabio");
		//nomes.sort((n1, n2) -> n1.compareToIgnoreCase(n2)); OU ENTÃO...
		/*
		nomes.sort((String::compareToIgnoreCase));
		System.out.println(nomes);
		*/
		nomes.sort((n1, n2) -> n2.compareToIgnoreCase(n1));
		System.out.println(nomes);
		
		//Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s); OU...
		Function<String, Integer> stringToInteger = Integer::parseInt;
		
		/*BiPredicate<List<String>, String> contains = (lista, elemento) -> lista.contains(elemento);
		OU...*/
		BiPredicate<List<String>, String> contains = List::contains;
		
		System.out.println(stringToInteger.apply("100"));
		System.out.println(contains.test(nomes, "Eduardo"));
		
		//Referencia dos construtores.
		Supplier<ComparadorCarro> comparadorCarroSupplier = ComparadorCarro::new;
		System.out.println(comparadorCarroSupplier.get());
		
		//BiFunction<String, Integer, Carro> carroBiFunction = (s, i) -> new Carro(s, i); OU...
		BiFunction<String, Integer, Carro> carroBiFunction = Carro::new;
		System.out.println(carroBiFunction.apply("Marrom", 2020));
	}

	public static <T> void forEach(List<T> list, Consumer<T> c)
	{for(T t:list)	{c.accept(t);}}
	
	public static <T, R> List<R> map(List<T> list, Function<T, R> f)
	{	List<R> result = new ArrayList<>();
		for(T t:list) {result.add(f.apply(t));}
		return result;
	}
}
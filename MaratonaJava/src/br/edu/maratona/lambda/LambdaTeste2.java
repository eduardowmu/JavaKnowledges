package br.edu.maratona.lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

import br.edu.maratona.comportamento.Carro;

import static java.util.Arrays.asList;
public class LambdaTeste2 
{	public static void main(String[] args) 
	{	forEach(asList("Willian", "DevDojo", "facebook.com/devedojo"), 
			(String s) -> System.out.println(s));
	
		List<Integer> list = map(asList("Willian", "DevDojo", 
				"facebook.com/devedojo"), (String s) -> s.length());
		
		List<String> listCores = map(asList(new Carro("preto", 2011), 
				new Carro("verde", 2010), new Carro("vermelho", 2009)), 
				(Carro carro) -> carro.getCor());
		
		System.out.println(list);
		System.out.println(listCores);
		
		Predicate<Integer> pares = (Integer i) -> i % 2 == 0;
		System.out.println(pares.test(1000));
		//ou podemos escrever dessa forma
		IntPredicate impar = (int i) -> i % 2 > 0;
		System.out.println(impar.test(1001));
		
		/*Usos de Predicate e Consumer*/
		Predicate<String> p = (String s) -> listCores.add(s);
		//p.and("Verde");
		System.out.println(listCores);
		Consumer<String> c = (String s) -> listCores.add(s);
		c.accept("Amarelo");
		System.out.println(listCores);
		//Interface Supplier
		Supplier<String> supp = () -> "Eduardo";
		System.out.println(supp.get());
		Supplier<Carro> supp1 = () -> new Carro("Verde", 2011);
		System.out.println(supp1.get().getAno());
	}

	public static <T> void forEach(List<T> list, Consumer<T> c)
	{for(T t:list)	{c.accept(t);}}
	
	public static <T, R> List<R> map(List<T> list, Function<T, R> f)
	{	List<R> result = new ArrayList<>();
		for(T t:list) {result.add(f.apply(t));}
		return result;
	}
}
package br.edu.maratona.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class StreamTeste2 
{	public static void main(String[] args) 
	{	List<List<String>> nomes = new ArrayList<>();
		nomes.add(asList("Eduardo", "Osamu", "Rodrigo", 
				"Camila", "Marie"));
		System.out.println(nomes);
		//nomes.stream().flatMap(Collection::stream); OU
		//nomes.stream().flatMap(s->s.stream());
		List<String> stringStream = nomes.stream()
			.flatMap(Collection::stream).collect(Collectors.toList());
		System.out.println(stringStream);
		
		/*Exemplificando outros métodos*/
		List<String> palavras = asList("Ola", "Eduardo");
		//separação de cada caractere da String com ','
		String[] split = palavras.get(0).split("");
		System.out.println(Arrays.toString(split));
		//usando Stream
		List<String[]> collect1 = palavras.stream().map(p->p.split(""))
				.collect(Collectors.toList());
		Stream<String> stream = Arrays.stream((String[])palavras.toArray());
		//até aqui temos um Stream<Sting[]>
		List<String> collect2 = palavras.stream().map(p->p.split(""))
		//aqui teremos um Stream<String>
		.flatMap(Arrays::stream).collect(Collectors.toList());
		System.out.println(collect2);
	}
}
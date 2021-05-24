package br.edu.maratona.stream;
import static java.util.Arrays.asList;

import java.util.Optional;
import java.util.stream.Stream;

import br.edu.maratona.stream.classes.Pessoa;
public class StreamTeste4Reduce 
{	public static void main(String[] args) 
	{	//Stream<Integer> numeros = getStream();
		Optional<Integer> reduce = 
				/*isso retorna um Optional<Integer>, pois não tem como ter certeza
				 *absoluta de que vai ter algum valor para fazermos o reduce da stream*/
				getStream().reduce((x, y) -> x + y);
		System.out.println(reduce.get());
		/*Podemos também fazer da seguinte maneira, porém temos que comentar a stream
		 *de cima, pois quando temos uma stream, só podemos operá-lo apenas uma vez, ou
		 *podemos também simplesmente repetir a mesma stream após seu uso*/
		//numeros = getStream();
		Integer soma = getStream().reduce(0, (x, y) -> x + y);
		System.out.println(soma);
		
		//numeros = getStream();
		Optional<Integer> soma2 = getStream().reduce(Integer::sum);
		System.out.println(soma2.get());
		
		Optional<Integer> produto = getStream().reduce((x,y)->x*y);
		System.out.println(produto.get());
		
		/*Duas maneiras de obter o valor máximo:
		 *1 - usando operador ternário*/
		Optional<Integer> max = getStream().reduce((x,y)-> x > y ? x:y);
		System.out.println(max.get());
		
		//2 - Usando métodos da classe Integer mesmo
		Optional<Integer> max2 = getStream().reduce(Integer::max);
		System.out.println(max2.get());
		
		/*vamos através da classe de pessoas, achar todas as pessoas com salário
		acima de 4000.*/
		Stream<Pessoa> streamPessoas = Pessoa.bancoDePessoas().stream();
		Optional<Double> salarioSoma = streamPessoas.filter(p -> p.getSalario() > 4000)
			.map(Pessoa::getSalario)
			.reduce(Double::sum);
		
		System.out.println(salarioSoma.get());
	}

	private static Stream<Integer> getStream() {return asList(1,2,3,4,5,6,7,8,9).stream();}
}
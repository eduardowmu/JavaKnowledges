package br.edu.maratona.stream;
import static java.util.Arrays.asList;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.maratona.stream.classes.Pessoa;
public class StreamTeste6Collectors 
{	//Redução e sumarização de streams em um valor unico
	public static void main(String[] args) 
	{	List<Pessoa> pessoas = Pessoa.bancoDePessoas();
		//se quisermos contar uma quantidade de pessoas da lista
		System.out.println(pessoas.size());//OU
		System.out.println(pessoas.stream().count());//OU, usando Collectors
		System.out.println(pessoas.stream().collect(Collectors.counting()));
		
		//encontrando a pessoa com valor maior de salario
		System.out.println(pessoas.stream().max(Comparator.comparing(
				Pessoa::getSalario)).get());//OU, usando Collectors
		
		System.out.println(pessoas.stream().collect(Collectors.maxBy(
				Comparator.comparing(Pessoa::getSalario))).get());
		
		//encontrando o valor minimo
		System.out.println(pessoas.stream().min(Comparator.comparing(
				Pessoa::getSalario)).get());//OU, usando Collectors
		
		System.out.println(pessoas.stream().collect(Collectors.minBy(
				Comparator.comparing(Pessoa::getSalario))).get());
		
		//soma dos salarios
		System.out.println(pessoas.stream().mapToDouble(Pessoa::getSalario).sum());//OU
		System.out.println(pessoas.stream().collect(Collectors.summingDouble(
				Pessoa::getSalario)));
		
		//media, cujo metodo retorna um Optional.
		System.out.println(pessoas.stream().mapToDouble(Pessoa::getSalario)
				.average().getAsDouble());//OU, para não retornar um Optional
		System.out.println(pessoas.stream().collect(Collectors.averagingDouble(
				Pessoa::getSalario)));
		
		//summarizing de Collectors
		System.out.println(pessoas.stream().collect(Collectors.summarizingDouble(
				Pessoa::getSalario)));
		
		//concatenações de Strings
		System.out.println(pessoas.stream().map(Pessoa::getNome).collect(
				Collectors.joining()));//OU inserindo delimitador
		System.out.println(pessoas.stream().map(Pessoa::getNome).collect(
				Collectors.joining(", ")));
	}
} 
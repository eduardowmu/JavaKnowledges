package br.edu.maratona.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import br.edu.maratona.stream.classes.Genero;
import br.edu.maratona.stream.classes.Maioridade;
import br.edu.maratona.stream.classes.Pessoa;

public class StreamTeste7Agrupando 
{	public static void main(String[] args) 
	{	List<Pessoa> pessoas = Pessoa.bancoDePessoas();
	
		Map<Genero, List<Pessoa>> generoListMap = new HashMap<>();
		//resolvendo a moda antiga
		List<Pessoa> masculinos = new ArrayList<>();
		List<Pessoa> femininos = new ArrayList<>();
		
		for(Pessoa pessoa:pessoas)
		{	if(pessoa.getGenero().equals(Genero.FEMININO))
			{femininos.add(pessoa);}
		
			else {masculinos.add(pessoa);}
		}
		
		generoListMap.put(Genero.FEMININO, femininos);
		generoListMap.put(Genero.MASCULINO, masculinos);
		System.out.println(generoListMap);
		
		//agora usando stream de agrupamento, por genero
		System.out.println(pessoas.stream().collect(Collectors.groupingBy(
				Pessoa::getGenero)));
		
		//agrupando por maioridade
		System.out.println("----------------Agrupando maioridade--------------");
		Map<Maioridade, List<Pessoa>> grupoMaioridade = pessoas.stream().collect(
			Collectors.groupingBy(p -> {
				if(p.getIdade() < 18) {return Maioridade.MENOR;}
				else {return Maioridade.ADULTO;}
			}));
		System.out.println(grupoMaioridade);
		
		//agrupando por genero e maioridade
		System.out.println("--------------Agrupando por genero e maioridade--------------");
		
		Map<Genero, Map<Maioridade, List<Pessoa>>> genMaiGroup =
		pessoas.stream().collect(Collectors.groupingBy(Pessoa::getGenero, 
			Collectors.groupingBy(p -> {
				if(p.getIdade() < 18) {return Maioridade.MENOR;}
				else {return Maioridade.ADULTO;}
			})));
		System.out.println(genMaiGroup);
		
		//agrupando por genero e quantidade
		System.out.println("--------------Agrupando por genero e quantidade--------------");
		Map<Genero, Long> genQtdGroup = pessoas.stream().collect(Collectors.groupingBy(
				Pessoa::getGenero, Collectors.counting()));
		System.out.println(genQtdGroup);
		
		//agrupando por genero e maior salario
		System.out.println("-------------Agrupando por genero e maior salario-------------");
		Map<Genero, Optional<Pessoa>> genSalGroup =
		pessoas.stream().collect(Collectors.groupingBy(Pessoa::getGenero,
				//lembrando que o Comparator retorna um Optional.
				Collectors.maxBy(Comparator.comparing(Pessoa::getSalario))));
		
		System.out.println(genSalGroup);
		
		//retirando o Optional como retorno
		System.out.println("-------------retirando o Optional como retorno-------------");
		Map<Genero, Pessoa> genSalGroup2 = 
		pessoas.stream().collect(Collectors.groupingBy(Pessoa::getGenero, 
			Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(
					Pessoa::getSalario)), Optional::get)));
		System.out.println(genSalGroup2);
		
		//Agrupando por genero e estatistica com summarizing
		System.out.println("--------Agrupando por genero e estatistica com summarizing--------");
		Map<Genero, DoubleSummaryStatistics> genSalEstGroup =
		pessoas.stream().collect(Collectors.groupingBy(Pessoa::getGenero, 
				Collectors.summarizingDouble(Pessoa::getSalario)));
		System.out.println(genSalEstGroup);
		
		//para finalizar, faremos um agrupamento por genero e maioridade simples
		System.out.println("--------agrupamento por genero e maioridade simples--------");
		Map<Genero, Set<Maioridade>> genMaioridadeGroup = 
		pessoas.stream().collect(Collectors.groupingBy(Pessoa::getGenero, 
			Collectors.mapping(p -> {
			if(p.getIdade() < 18) {return Maioridade.MENOR;}
			else {return Maioridade.ADULTO;}
		}, Collectors.toSet())));
		
		System.out.println(genMaioridadeGroup);
		
		//para titulo de resultado melhor, usaremos o LinkedHashSet
		Map<Genero, Set<Maioridade>> genMaioridadeGroup2 = 
		pessoas.stream().collect(Collectors.groupingBy(Pessoa::getGenero, 
			Collectors.mapping(p -> {
			if(p.getIdade() < 18) {return Maioridade.MENOR;}
			else {return Maioridade.ADULTO;}
		}, Collectors.toCollection(LinkedHashSet::new))));
		
		System.out.println(genMaioridadeGroup2);
	}
}
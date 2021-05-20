package br.edu.maratona.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.maratona.stream.classes.Pessoa;
/*Aqui queremos pegar as 3 primeiras pessoas, ordenadas, 
com menos de 50 anos*/
public class StreamTeste 
{	public static void main(String[] args) 
	{	//com java 7
		List<Pessoa> pessoas = Pessoa.bancoDePessoas();
		//Organizando em ordem
		Collections.sort(pessoas, new Comparator<Pessoa>() 
		{	@Override public int compare(Pessoa p1, Pessoa p2) 
			{return p1.getNome().compareToIgnoreCase(p2.getNome());}
		});
		//limitando a 3 com menos de 50 anos
		List<String> nomes = new ArrayList<>();
		for(Pessoa pessoa:pessoas)
		{	if(pessoa.getIdade() < 50)
			{	nomes.add(pessoa.getNome());
				if(nomes.size() >= 4)	break;
			}
		}
		System.out.println(nomes);
		
		//com java 8, usando stream
		List<String> nomes2 = pessoas.stream()
				//filtrando pela idade < 50
				.filter(p->p.getIdade() < 50)
				//ordenando por nome
				.sorted(Comparator.comparing(Pessoa::getNome))
				//limitado a 3 pessoas
				.limit(4)
				//coletando todos pelo nome em uma lista
				.map(Pessoa::getNome).collect(Collectors.toList());
		
		System.out.println(nomes2);
		
		//com java 8, usando stream
		Long qtd = pessoas.stream()
				//irá fazer uma distinção de acordo com o filtro.
				.distinct()
				//filtrando pela idade < 50
				.filter(p->p.getIdade() < 50)
				//ordenando por nome
				.sorted(Comparator.comparing(Pessoa::getNome))
				//coletando todos pelo nome em uma lista
				.map(Pessoa::getNome)
				/*outro método, que equivale ao size() do collections, com a diferença
				 *este retorna um Long e não in inteiro*/
				.count();
		
		System.out.println(qtd);
		
		//Para fechar, um método do tipo Terminal
		pessoas.stream().forEach(p->System.out.println(p.getNome()));
	}
}
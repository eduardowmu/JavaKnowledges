package br.edu.maratona.optional;

import java.util.Optional;

import br.edu.maratona.optional.classes.Seguradora;

public class SeguradoraOptionalTeste 
{	public static void main(String[] args) 
	{	Seguradora seg = new Seguradora("Hello");
		System.out.println(obterNomeSeguradoraOptional(seg));
	}

	private static String obterSeguradora(Seguradora seg)
	{	String nome = null;
		if(seg.getNome() != null)	{
			//nome = seg.getNome();
		}
		return nome;
	}
	
	public static String obterNomeSeguradoraOptional(Seguradora seg)
	{	/*Esse flatMap(), diferente do map(), extrai diretamente a String
	 	do getNome() e podemos usar o orElse()*/
		System.out.println(Optional.ofNullable(seg).flatMap(
			Seguradora::getNome).orElse("Vazio"));
		return "";
	}
}
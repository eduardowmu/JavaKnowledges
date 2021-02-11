package br.edu.maratona.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsTeste 
{	public static void main(String[] args) 
	{	List<String> lista = new ArrayList<>();
	
		lista.add("Ola");
		lista.add("Edu");
		
		for(String word:lista)
		{System.out.print(word + " ");}
		
		add(lista, 1L);
		
		for(String word:lista)
		{System.out.print(word + " ");}
	}

	public static void add(List lista, Long l)
	{lista.add(l);}
}
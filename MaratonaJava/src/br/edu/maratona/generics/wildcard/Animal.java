package br.edu.maratona.generics.wildcard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Animal 
{public abstract void consulta();}

class Cachorro extends Animal
{	@Override public void consulta() 
	{System.out.println("Consultando Cachorro");}
}

class Gato extends Animal
{	@Override public void consulta() 
	{System.out.println("Consultando Gato");}
}

class WildCardTest
{	public static void main(String[] args)
	{	Cachorro[] cachorros = {new Cachorro(), new Cachorro()};
		Gato[] gatos = {new Gato(), new Gato()};
		consultarAnimais(cachorros);
		consultarAnimais(gatos);
		
		List<Cachorro> cachorroList = new ArrayList<>();
		cachorroList.add(new Cachorro());
		List<Gato> gatoList = new ArrayList<>();
		gatoList.add(new Gato());
		
		consultaAnimaisLista(cachorroList);
		consultaAnimaisLista(gatoList);
	}
	
	public static void consultarAnimais(Animal[] animais)
	{	for(Animal animal:animais)
		{animal.consulta();}
	}
	
	/*O java em tempo de compila��o, por si s� n�o
	 *n�o consegue identificar o tipo de objeto da classe
	 *que pertence, ent�o pra isso foi inventado o wildcard '?'
	 *Isso diz para o java que estamos inserindo qualquer lista
	 *que seja da subclasse de Animal, mas garante que n�o
	 *iremos inserir nada*/
	public static void consultaAnimaisLista(
		List<? extends Animal> animais)
	{	for(Animal animal:animais)
		{animal.consulta();}
	}
	
	/*Aqui garantimos que podemos inserir qualquer classe
	 *m�e de cachorro, al�m de si mesmo.*/
	public static void consultaCachorrosLista(
		List<? super Cachorro> cachorros)
	{	Cachorro c1 = new Cachorro();
		Animal a = new Cachorro();
		Object o = new Cachorro();
		cachorros.add(new Cachorro());
	}
	
	/*aqui podemos garantir que podemos inserir qualquer 
	 *coisa*/
	public static void consultarLista(
		List<? extends Comparable> lista)
	{Collections.sort(lista);}
}
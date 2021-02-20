package br.edu.maratona.anonimas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.edu.maratona.generics.classesgenericas.Carro;

class Animal
{	public void caminhar()
	{System.out.println("Caminhando");}
}

class CarroComparator implements Comparator<Carro>
{	@Override public int compare(Carro arg0, Carro arg1) 
	{return arg0.getNome().compareTo(arg1.getNome());}
}

public class ClassesAnonimasTeste 
{	public static void main(String[] args) 
	{	/*Temos uma variável de referência do tipo
	 	animal, que está fazendo referência pra um
	 	objeto animal, que é uma subclasse de animal
	 	e que não possui nenhum nome.*/
		Animal animal = new Animal() 
		{	public void caminhar()
			{System.out.println("Andando mais rapidamente");}
		};
		/*Estamos aqui fazendo uma referência a subclasse
		 *sem nome, que é a classe anônima que foi criada.*/
		animal.caminhar();
		
		/*Digamos que queiramos ordenar esses carros.*/
		List<Carro> carros = new ArrayList<>();
		carros.add(new Carro("BMW"));
		carros.add(new Carro("Audi"));
		/*Sabemos que não podemos criar um objeto direto de uma
		 *interface, mas aqui estamos criando um objeto anonimo
		 *que implementa uma interface*/
		Collections.sort(carros, new Comparator<Carro>() 
		{	@Override public int compare(Carro o1, Carro o2) 
			{return o1.getNome().compareTo(o2.getNome());}
		});
		System.out.println(carros);
	}
}
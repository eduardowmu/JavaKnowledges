package br.edu.maratona.optional;

import java.util.Optional;

public class OptionalTeste1 
{	private String nome;
	public static void main(String[] args) 
	{	OptionalTeste1 op1 = new OptionalTeste1();
		/*A string ela pode tanto existir como n�o e como podemos
		 *encapsular um atributo dentro de um optional? Temos 3 op��es
		 *1 - Quando temos certeza absoluta de que a vari�vel que queremos
		 *encapsular n�o ser� nula.*/
		Optional<String> optional = Optional.empty();
		//System.out.println(optional);
		
		/*2 - Se quisermos inicializar que um optional seja vazio...*/
		Optional<String> optional2 = Optional.empty();
		System.out.println(optional2);
		
		/*3 - Quando temos uma vari�vel e n�o temos certeza se � nula ou n�o*/
		Optional<String> optional3 = Optional.ofNullable(op1.nome);
		System.out.println(optional3);
		
		/*Podemos fazer o seguinte, quando quisermos desprezar valores 
		 *nulos ou vazios*/
		System.out.println(optional.orElse("Hello World"));
		System.out.println(optional2.orElse("Eduardo"));
		System.out.println(optional3.orElse("Murakoshi"));
	}
}
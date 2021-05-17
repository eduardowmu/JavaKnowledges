package br.edu.maratona.optional;

import java.util.Optional;

public class OptionalTeste1 
{	private String nome;
	public static void main(String[] args) 
	{	OptionalTeste1 op1 = new OptionalTeste1();
		/*A string ela pode tanto existir como não e como podemos
		 *encapsular um atributo dentro de um optional? Temos 3 opções
		 *1 - Quando temos certeza absoluta de que a variável que queremos
		 *encapsular não será nula.*/
		Optional<String> optional = Optional.empty();
		//System.out.println(optional);
		
		/*2 - Se quisermos inicializar que um optional seja vazio...*/
		Optional<String> optional2 = Optional.empty();
		System.out.println(optional2);
		
		/*3 - Quando temos uma variável e não temos certeza se é nula ou não*/
		Optional<String> optional3 = Optional.ofNullable(op1.nome);
		System.out.println(optional3);
		
		/*Podemos fazer o seguinte, quando quisermos desprezar valores 
		 *nulos ou vazios*/
		System.out.println(optional.orElse("Hello World"));
		System.out.println(optional2.orElse("Eduardo"));
		System.out.println(optional3.orElse("Murakoshi"));
	}
}
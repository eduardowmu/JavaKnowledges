package br.edu.maratona;

public class StringBuilderTest 
{	public static void main(String[] args) 
	{	String frase = "Uma frase comum";
		
		//cria��o de uma String com 10 caracteres
		StringBuilder sb = new StringBuilder(10);
		
		//m�todo com sobrecarga, mas normalmente usamos
		//a que recebe String
		sb.append(frase);
		
		//isso funciona pois automaticamente e indiretamente
		//o java estar� usando o m�todo toString() da classe
		//StringBuilder
		System.out.println(sb);
		
		//metodo reverse, reverte a ordem da string
		//System.out.println(sb.reverse());
		
		//delete
		System.out.println(sb.delete(0, 4));
		
		//insert
		System.out.println(sb.insert(11, " hello world"));
	}
}
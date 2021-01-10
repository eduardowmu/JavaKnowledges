package br.edu.maratona.token;

public class TokenTest 
{	public static void main(String[] args) 
	{	String nomes = "Willian, Paulo, Joana, Camila, Anna, John, Matheus";
		
		//pelo método String, passando um regex ou apenas String
		String[] tokens = nomes.split(",");
		
		//iteração com array de String
		for(String nome:tokens) {System.out.print(nome);}
	}	
}
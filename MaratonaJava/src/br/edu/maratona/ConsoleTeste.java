package br.edu.maratona;

import java.io.Console;

public class ConsoleTeste 
{	public static void main(String[] args) 
	{	Console c = System.console();
		
		//retorna uma String
		//c.readLine();
		
		//retorna um Character
		//c.reader();
	
		char[] pw = c.readPassword("%s", "pw: ");
		
		for(char pass:pw) {c.format("%c", pass);}
		c.format("\n");
	}

	public static String retorno(String arg1)
	{return "Entrada de dados " + arg1;}
}
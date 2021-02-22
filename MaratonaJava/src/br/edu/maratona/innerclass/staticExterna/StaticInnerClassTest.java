package br.edu.maratona.innerclass.staticExterna;

class Externa
{	private static String nome = "Ola";
	static class Interna
	{	public void imprimir()
		{System.out.println(nome);}
	}
}

public class StaticInnerClassTest 
{	public static void main(String[] args) 
	{	Externa.Interna interna = new Externa.Interna();
		interna.imprimir();
		Interna2 interna2 = new Interna2();
		interna2.imprimir();
	}

	static class Interna2
	{	public void imprimir()
		{System.out.println("Nova classe interna");}
	}
}
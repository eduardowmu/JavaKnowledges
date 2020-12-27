package br.edu.maratona;

public class Valor implements AutoCloseable
{	private String nome;
	
	public Valor(String nome) 
	{	this.nome = nome;
		System.out.println(this.nome + " criado");
	}

	@Override public void close() throws Exception {}
}
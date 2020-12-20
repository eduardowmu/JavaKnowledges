package br.edu.maratona.finalmodify;

public class Carro 
{	public static final double VELOCIDADE_LIMITE = 130;
	private String nome;
	private String marca;
	private final Comprador comprador = new Comprador();
	
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	
	public String getMarca() {return marca;}
	public void setMarca(String marca) {this.marca = marca;}
	
	public Comprador getComprador() {return comprador;}
	
	public final void descreverCarro() {this.toString();}
	
	@Override public String toString() 
	{return "Carro [nome=" + nome + ", marca=" + marca + "]";}
}
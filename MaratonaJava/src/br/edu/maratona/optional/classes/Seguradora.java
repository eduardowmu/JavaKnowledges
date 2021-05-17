package br.edu.maratona.optional.classes;

import java.util.Optional;

public class Seguradora 
{	private String nome;

	public Seguradora() {}
	public Seguradora(String nome) {this.nome = nome;}
	
	public Optional<String> getNome() {return Optional.ofNullable(nome);}
	public void setNome(String nome) {this.nome = nome;}
}
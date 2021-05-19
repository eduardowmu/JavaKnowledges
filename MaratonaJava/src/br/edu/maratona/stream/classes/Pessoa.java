package br.edu.maratona.stream.classes;

import java.util.List;
import static java.util.Arrays.asList;
public class Pessoa 
{	private String nome;
	private int idade;
	private double salario;
	
	public Pessoa(String nome, int idade, double salario) 
	{	this.nome = nome;
		this.idade = idade;
		this.salario = salario;
	}

	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}

	public int getIdade() {return idade;}
	public void setIdade(int idade) {this.idade = idade;}

	public double getSalario() {return salario;}
	public void setSalario(double salario) {this.salario = salario;}
	
	public static List<Pessoa> bancoDePessoas()
	{	return asList(new Pessoa("Eduardo Murakoshi", 37, 4000.0),
					  new Pessoa("Rodrigo Murakoshi", 41, 20000.0),
					  new Pessoa("Osamu Murakoshi", 73, 10000.0),
					  new Pessoa("Marie Murakoshi", 67, 10000.0),
					  new Pessoa("Camila da Costa", 31, 4000.0));
	}
}
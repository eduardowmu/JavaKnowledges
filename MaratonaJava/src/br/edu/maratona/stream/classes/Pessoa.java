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
					  new Pessoa("Camila da Costa", 31, 4000.0),
					  new Pessoa("Camila da Costa", 32, 5000.0));
	}

	@Override public int hashCode() 
	{	final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override public boolean equals(Object obj) 
	{	if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
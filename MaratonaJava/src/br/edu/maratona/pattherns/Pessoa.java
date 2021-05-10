package br.edu.maratona.pattherns;

public class Pessoa 
{	private String nome;
	private String ultimoNome;
	private String meioNome;
	private String apelido;
	private String nomePai;
	
	private Pessoa(String nome, String ultimoNome, 
			String meioNome, String apelido, String nomePai) 
	{	this.nome = nome; 
		this.ultimoNome = ultimoNome;
		this.meioNome = meioNome; 
		this.apelido = apelido; 
		this.nomePai = nomePai; 
	}
	 
	
	public static class PessoaBuilder
	{	private String nome;
		private String ultimoNome;
		private String meioNome;
		private String apelido;
		private String nomePai;
		
		public PessoaBuilder() {}
		
		public PessoaBuilder nome(String nome)
		{	this.nome = nome;
			return this;
		}
		
		public PessoaBuilder ultimoNome(String ultimoNome)
		{	this.ultimoNome = ultimoNome;
			return this;
		}
		
		public PessoaBuilder meioNome(String meioNome)
		{	this.meioNome = meioNome;
			return this;
		}
		
		public PessoaBuilder apelido(String apelido)
		{	this.apelido = apelido;
			return this;
		}
		
		public PessoaBuilder nomePai(String nomePai)
		{	this.nomePai = nomePai;
			return this;
		}
		
		public Pessoa createPessoa()
		{	return new Pessoa(nome, ultimoNome, meioNome, 
				apelido, nomePai);
		}
	}

	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}

	public String getUltimoNome() {return ultimoNome;}
	public void setUltimoNome(String ultimoNome) {this.ultimoNome = ultimoNome;}

	public String getMeioNome() {return meioNome;}
	public void setMeioNome(String meioNome) {this.meioNome = meioNome;}

	public String getApelido() {return apelido;}
	public void setApelido(String apelido) {this.apelido = apelido;}

	public String getNomePai() {return nomePai;}
	public void setNomePai(String nomePai) {this.nomePai = nomePai;}
	
	@Override public String toString() 
	{	return "Pessoa [nome=" + nome + ", ultimoNome=" + ultimoNome 
				+ ", meioNome=" + meioNome + ", apelido=" + apelido
				+ ", nomePai=" + nomePai + "]";
	}
}
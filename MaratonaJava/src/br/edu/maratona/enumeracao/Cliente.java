package br.edu.maratona.enumeracao;
public class Cliente 
{	private String nome;
	//public static final int PESSOA_FISICA = 1;
	//public static final int PESSOA_JURIDICA = 2;
	//public enum EnumCliente {PESSOA_FISICA, PESSOA_JURIDICA;}
	private EnumCliente tipo;
	
	public Cliente(String nome, EnumCliente tipo) 
	{	this.nome = nome;
		this.tipo = tipo;
	}
	
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	
	public EnumCliente getTipo() {return tipo;}
	public void setTipo(EnumCliente tipo) {this.tipo = tipo;}

	@Override public String toString() 
	{	String tipoPessoa = "";
		if(this.getTipo() == EnumCliente.PESSOA_FISICA)	
		{tipoPessoa = "FISICA";}
		else {tipoPessoa = "JURIDICA";}
		return "Cliente: nome = " + this.nome + 
				", tipo = " + tipoPessoa + ", numeroTipo = " + 
				this.tipo.getTipo() + ", tipoPessoa = " +
				this.tipo.getTipoPessoa();
	}
}
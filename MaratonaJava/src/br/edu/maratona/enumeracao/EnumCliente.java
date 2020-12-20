package br.edu.maratona.enumeracao;

public enum EnumCliente 
{	PESSOA_FISICA(1, "Fisica"), PESSOA_JURIDICA(2, "Juridica");
	
	private int tipo;
	private String tipoPessoa;
	
	private EnumCliente(int tipo, String tipoPessoa)
	{	this.tipo = tipo;
		this.tipoPessoa = tipoPessoa;
	}

	public int getTipo() {return tipo;}
	public String getTipoPessoa() {return tipoPessoa;}
}
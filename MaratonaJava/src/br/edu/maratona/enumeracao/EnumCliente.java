package br.edu.maratona.enumeracao;

public enum EnumCliente 
{	PESSOA_FISICA(1, "Fisica"),
	//para essa constante iremos sobrescrever esse método
	PESSOA_JURIDICA(2, "Juridica")
	{	public String getId()
		{return "B";}
	};/*esse ponto e vírgula é obrigatório ou teremos erro 
		de compilação*/
	
	private int tipo;
	private String tipoPessoa;
	
	private EnumCliente(int tipo, String tipoPessoa)
	{	this.tipo = tipo;
		this.tipoPessoa = tipoPessoa;
	}
	
	public String getId()	{return "A";}

	public int getTipo() {return tipo;}
	public String getTipoPessoa() {return tipoPessoa;}
}
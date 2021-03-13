package br.edu.maratona.sincronismo;

public class Conta 
{	private int saldo = 50;

	public int getSaldo() {return saldo;}
	
	public void saque(int valor) {saldo -= valor;}
}
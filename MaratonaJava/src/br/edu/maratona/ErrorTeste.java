package br.edu.maratona;

public class ErrorTeste 
{	public static void main(String[] args) 
	{stackOverFlowError();}
	
	/*Isso é uma recursividade infinita, até
	que seja lançado um erro chamado stack*/
	public static void stackOverFlowError()
	{stackOverFlowError();}
}
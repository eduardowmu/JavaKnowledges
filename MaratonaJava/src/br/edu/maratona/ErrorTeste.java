package br.edu.maratona;

public class ErrorTeste 
{	public static void main(String[] args) 
	{stackOverFlowError();}
	
	/*Isso � uma recursividade infinita, at�
	que seja lan�ado um erro chamado stack*/
	public static void stackOverFlowError()
	{stackOverFlowError();}
}
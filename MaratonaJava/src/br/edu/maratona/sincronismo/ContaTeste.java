package br.edu.maratona.sincronismo;

public class ContaTeste implements Runnable
{	private final Conta conta = new Conta();
	
	public static void main(String[] args)
	{	ContaTeste contaTeste = new ContaTeste();
		/*Criando threads para cada usuário que tentarão
		 *realizar saques*/
		Thread willian = new Thread(contaTeste, "Willian");
		Thread ana = new Thread(contaTeste, "Ana");
		/*Iniciando ambas as threads*/
		willian.start();
		ana.start();
	}
	
	private static void imprime()
	{	/*veremos mais para frente uma classe
	 	que chamamos de literal, que é uma forma
	 	que temos do compilador dizer para a JVM 
	 	olhar para cada instância dessa classe*/
		synchronized(ContaTeste.class)
		{System.out.println("blablabla");}
	}
	
	/*Teremos nesse método a sequinte regra:
	 *1 - Iremos verificar se o saldo é maior que a quantidade
	 *de que queremos efetuar;
	 *
	 *2 - Se for maior, iremos efetuar o saque;
	 *
	 *3 - Caso contrário, isso não será possível*/
	private void saque(int valor)
	{	synchronized(conta)
		{	if(conta.getSaldo() >= valor)
			{	System.out.println(
					Thread.currentThread().getName() + 
					" esta indo sacar");
				
				conta.saque(valor);
				System.out.println(
					Thread.currentThread().getName() + 
					" saque realizado com sucesso");
			}  
			
			else
			{	System.out.println(
					Thread.currentThread().getName() + 
					" saldo indisponível para o valor de saque");
			}
		}
		/*
		 * if(conta.getSaldo() >= valor) { System.out.println(
		 * Thread.currentThread().getName() + " esta indo sacar");
		 * 
		 * conta.saque(valor); System.out.println( Thread.currentThread().getName() +
		 * " saque realizado com sucesso"); }
		 * 
		 * else { System.out.println( Thread.currentThread().getName() +
		 * " saldo indisponível para o valor de saque"); }
		 */
	}
	
	/*Supondo que as notas disponíveis são apenas no valor de
	 *R$10,00. Como o saldo é de R$50,00*/
	@Override public void run() 
	{	for(int i = 0; i < 5; i++)
		{	saque(10);
			if(conta.getSaldo() < 0)
			{System.out.println("Algo de errado não está certo");}
		}
	}
}
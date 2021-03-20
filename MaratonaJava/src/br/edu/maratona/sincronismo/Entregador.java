package br.edu.maratona.sincronismo;

public class Entregador implements Runnable 
{	private ListaMembros listaMembros;
	
	public Entregador(ListaMembros listaMembros) 
	{this.listaMembros = listaMembros;}

	@Override public void run() 
	{	String nomeThread = Thread.currentThread().getName();
		System.out.println("Come�ando o trabalho de entrega");
		int qtdePendente = listaMembros.getEmailsPendentes();
		boolean aberta = this.listaMembros.isAberta();
		while(aberta || qtdePendente > 0)
		{	try
			{	String email = this.listaMembros.obterEmailMembro();
				if(email != null)	
				{	System.out.println(nomeThread 
						+ " Enviando email para " + email);
					Thread.sleep(2000);
					System.out.println("Envio para " + email 
							+ " conclu�do com sucesso");
				}
				
			}
			catch(InterruptedException ie)
			{System.out.println(ie.getMessage());}
			aberta = this.listaMembros.isAberta();
		}
		System.out.println("Atividade finalizada");
	}
}
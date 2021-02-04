package br.edu.maratona.nio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class InOutPutStreamTeste 
{	public static void main(String[] args) 
	{	//save();
		bufferedSave();
		//read();
		readBuffered();
	}

	private static void save()
	{	byte[] dados = {65, 66, 67, 68, 69};
		try(FileOutputStream gravador = 
			new FileOutputStream("files/arquivo.txt"))
		{	for(Byte b:dados) {gravador.write(b);}
			System.out.println("Dados salvo com sucesso");
		}
		catch(IOException ioe)
		{System.out.println(ioe.getMessage());}
	}
	
	private static void bufferedSave()
	{	byte[] dados = {65, 66, 67, 68, 69};
		/*O buffer tem por padrão 8142 bytes*/
		try(BufferedOutputStream gravadorBuffer = 
				new BufferedOutputStream(//limitação do numero de byte
					new FileOutputStream("files/arquivo.txt"), 4098))
		{	for(Byte b:dados) {gravadorBuffer.write(b);}
			/*como estamos trabalhando com streaming de bytes, 
			 *existe a possibilidade de fecharmos aquele streaming 
			 *antes de pegarmos todos os dados que estavam passando
			 *pelo tunel (buffer)*/
			gravadorBuffer.flush();
			System.out.println("Dados salvo com sucesso");
		}
		catch(IOException ioe)
		{System.out.println(ioe.getMessage());}
	}
	
	/*Para leitura de dados, o código é um pouco
	 *maior, pois para fazer leitura fazemos a leitura
	 *byte a byte e quando chegar no final do arquivo
	 *vai nos retornar -1*/
	private static void read()
	{	try(FileInputStream leitor = 
			new FileInputStream("files/arquivo.txt"))
		{	/*variavel para saber quando não há mais
		 	byte para leitura*/
			int leitura;
			while((leitura = leitor.read()) != -1)
			{	byte b = (byte)leitura;
				System.out.print(" "+b);
			}
		}
		catch(IOException ioe)
		{System.out.println(ioe.getMessage());}
	}
	
	private static void readBuffered()
	{	try(BufferedInputStream leitorBuffer = new
				BufferedInputStream(new 
				FileInputStream("files/arquivo.txt"), 4098))
		{	/*variavel para saber quando não há mais
		 	byte para leitura*/
			int leitura;
			while((leitura = leitorBuffer.read()) != -1)
			{	byte b = (byte)leitura;
				System.out.print(" "+b);
			}
		}
		catch(IOException ioe)
		{System.out.println(ioe.getMessage());}
	}
}
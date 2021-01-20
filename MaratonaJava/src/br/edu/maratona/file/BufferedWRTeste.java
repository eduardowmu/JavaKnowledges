package br.edu.maratona.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWRTeste 
{	public static void main(String[] args) 
	{ // criando um arquivo
		File file = new File("files\\arquivo.txt");
		if (file.exists()) 
		{	try (BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				 BufferedReader br = new BufferedReader(new FileReader(file));) 
			{	bw.write("Escrevendo uma mensagem no arquivo" + 
				 "\nEscrevendo mais mensagem.");
				/*
				 * este método irá se encarregar de encontrar o caractere especial que vai pular
				 * linha baseado no sistema operacional.
				 */
				bw.newLine();
				bw.write("Pulando uma linha");
				bw.flush();

				String str;
				// enquanto não houver linha nula...
				while ((str = br.readLine()) != null) {
					System.out.println(str);
				}

			} 
			catch (IOException e) {System.out.println(e.getMessage());}
			/*
			 * try { FileWriter fw = new FileWriter(file, true); BufferedWriter bw = new
			 * BufferedWriter(fw);
			 * 
			 * bw.write("Escrevendo uma mensagem no arquivo" +
			 * "\nEscrevendo mais mensagem."); este método irá se encarregar de encontrar o
			 * caractere especial que vai pular linha baseado no sistema operacional.
			 * bw.newLine(); bw.write("Pulando uma linha"); bw.flush(); //fecha o arquivo.
			 * bw.close();
			 * 
			 * //leitura do arquivo FileReader fr = new FileReader(file);
			 * 
			 * //Buffered Reader muda um pouco as coisas BufferedReader br = new
			 * BufferedReader(fr); //este método, ao invés de ler caractere por //caractere,
			 * este faz leitura linha a linha br.readLine();
			 * 
			 * String str = null; //enquanto não houver linha nula... while((str =
			 * br.readLine()) != null) {System.out.println(str);} Não há necessidade de
			 * fechar os files mais internos, quando temos os mais externos fechando , pois
			 * estes já se encarregam de fechar os mais internos ao mesmo tempo, se houver.
			 * br.close(); } catch (IOException e) {System.out.println(e.getMessage());}
			 */
		} 
		else 
		{	try {file.createNewFile();} 
			catch (IOException e) {System.out.println(e.getMessage());}
		}
	}
}
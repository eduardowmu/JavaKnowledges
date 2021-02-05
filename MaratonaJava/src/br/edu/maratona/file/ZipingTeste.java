package br.edu.maratona.file;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipingTeste 
{	public static void main(String[] args) 
	{	//definindo diretório do ZIP
		Path zipPath = Paths.get("F:\\Users"
			+ "\\eduardowmu\\Desktop\\meusdoc"
			+ "\\estudo\\FATEC\\7 - OUTROS SEMESTRES"
			+ "\\YOUTUBE\\Maratona java\\Repositorio"
			+ "\\JavaKnowledges");
		
		//criando diretório
		Path filePath = Paths.get("F:\\Users\\eduardowmu"
			+ "\\Desktop\\meusdoc\\estudo\\FATEC"
			+ "\\7 - OUTROS SEMESTRES\\YOUTUBE\\Maratona java"
			+ "\\Repositorio");
		
		//definindo nome do arquivo zip
		Path zipFile = zipPath.resolve("file.zip");
		
		/*usando a classe ZipOutPutStream para 
		 *compimir arquivos*/
		try(ZipOutputStream zip = new ZipOutputStream(
				new FileOutputStream(zipFile.toFile()));
			DirectoryStream<Path> stream = 
				Files.newDirectoryStream(filePath))
		{	for(Path path:stream)
			{	/*Inserindo entradas dentro desse zip*/
				ZipEntry zipEntry = new ZipEntry(
						path.getFileName().toString());
				/*inserindo arquivos ou pastas dentro
				 *zip*/
				zip.putNextEntry(zipEntry);
				
				/*Leitura de arquivos*/
				FileInputStream fis = new FileInputStream(
						path.toFile());
				
				/*Trbalhando com Buffer*/
				BufferedInputStream bf = new BufferedInputStream(fis);
				
				//byte[] b = new byte[2048];
				//int bytesRead;
				
				zip.write(bf.read());
				
				/*
				while((bytesRead = fis.read(b)) > 0)
				{zip.write(b, 0, bytesRead);}
				*/
				
				zip.flush();
				zip.closeEntry();
				//fis.close();
				bf.close();
			}
		}
		catch(IOException ioe)	
		{System.out.println(ioe.getMessage());}
	}
}
package br.edu.maratona.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BasicAttributesTest 
{	public static void main(String[] args) 
	{	Date primeiroDezembro = new GregorianCalendar(2015, 
			Calendar.DECEMBER, 1).getTime();
	
		File file = new File("files\\arquivo2.txt");
		try 
		{	if(!file.exists() && file.createNewFile())
			{	file.setLastModified(primeiroDezembro.getTime());
				System.out.println(file.lastModified());
				file.delete();
				
				//usando Path
				Path path = Paths.get("folder\\file.txt");
				
				Files.createFile(path);
				FileTime fileTime = FileTime.fromMillis(
						primeiroDezembro.getTime());
				
				Files.setLastModifiedTime(path, fileTime);
				System.out.println(Files.getLastModifiedTime(path));
				Files.deleteIfExists(path);
				
				path = Paths.get("F:\\Users\\eduardowmu\\Desktop\\"
						+ "meusdoc\\estudo\\FATEC\\7 - OUTROS SEMESTRES\\"
						+ "YOUTUBE\\Maratona java\\Repositorio\\JavaKnowledges\\"
						+ "MaratonaJava\\src\\br\\edu\\maratona\\CarroTeste.java");
				
				System.out.println(Files.isReadable(path));
				System.out.println(Files.isWritable(path));
				System.out.println(Files.isExecutable(path));
				
				//BasicFilesAttributes, PosixFileAttributes, DosFileAttributes
				BasicFileAttributes basicFiles = Files.readAttributes(path, 
						BasicFileAttributes.class);
				
				System.out.println(basicFiles.creationTime());
				System.out.println(basicFiles.lastAccessTime());
				System.out.println(basicFiles.lastModifiedTime());
				System.out.println("------------------------------------");
				/*
				System.out.println(basicFiles.isDirectory());
				System.out.println(basicFiles.isSymbolicLink());
				System.out.println(basicFiles.isRegularFile());
				*/
				
				FileTime lastModified = basicFiles.lastModifiedTime();
				FileTime created = basicFiles.creationTime();
				FileTime lastAccess = FileTime.fromMillis(System.currentTimeMillis());
				
				//Para modificação: 
				//BasicAttributeView, PosyxFileAttribureView, DosFileAttributesView
				//FileOwnerAttributeView, AclFileAttribureView
				BasicFileAttributeView basicFileView = Files.getFileAttributeView(
						path, BasicFileAttributeView.class);
				
				//alterando time do path
				basicFileView.setTimes(lastModified, lastAccess, created);
				
				System.out.println(basicFiles.creationTime());
				System.out.println(basicFiles.lastAccessTime());
				System.out.println(basicFiles.lastModifiedTime());
			} 
		}
		catch (IOException e) 
		{System.out.println(e.getMessage());}
	}
}
package br.edu.maratona;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SimpleDateFormatTeste 
{	public static void main(String[] args) 
	{	Calendar calendar = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("dd/MM/YYYY");
		System.out.println(df.format(calendar.getTime()));
		
		//tudo que estiver dentro de aspas simples, 
		//será desconsiderado
		DateFormat df2 = new SimpleDateFormat(
				"dd/MM/YYYY 'at' HH:mm:ss");
		
		System.out.println(df2.format(calendar.getTime()));
	}
}
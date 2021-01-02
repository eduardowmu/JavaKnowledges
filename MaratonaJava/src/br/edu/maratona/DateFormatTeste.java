package br.edu.maratona;

import java.text.DateFormat;
import java.util.Calendar;

public class DateFormatTeste 
{	public static void main(String[] args) 
	{	Calendar calendar = Calendar.getInstance();
		DateFormat[] df = new DateFormat[6];
		
		//1º formato
		df[0] = DateFormat.getInstance();
		
		//2º formato
		df[1] = DateFormat.getDateInstance();
		
		//3º formato
		df[2] = DateFormat.getDateInstance(DateFormat.SHORT);
		
		//4º formato
		df[3] = DateFormat.getDateInstance(DateFormat.MEDIUM);
		
		//5º formato
		df[4] = DateFormat.getDateInstance(DateFormat.LONG);
		
		//6º formato
		df[5] = DateFormat.getDateInstance(DateFormat.LONG);
		
		for(int i = 0; i < df.length; i++)
		{System.out.println(df[i].format(calendar.getTime()));}
	}
}
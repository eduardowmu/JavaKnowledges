package br.edu.maratona;

import java.util.Calendar;
import java.util.Date;
//pegando a hora atual
public class ManipulacaoDatasTeste 
{	public static void main(String[] args) 
	{	Date date = new Date();
		date.setTime(date.getTime() + 3600000);
		System.out.println(date);
		
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		
		//ojeto calendar recebendo um tipo date
		calendar.setTime(date);
		System.out.println(calendar.getTimeInMillis());
		System.out.println(calendar.getTimeZone().getDisplayName());
		System.out.println(calendar.getTime());
		System.out.println(calendar.getFirstDayOfWeek());
		System.out.println(calendar.DAY_OF_WEEK);
		
		//um Date recebendo um tipo Calendar através do método
		//getTime()
		Date date2 = calendar.getTime();
		System.out.println(date2);
		
		//add horas no tempo
		calendar.add(Calendar.HOUR, 2);
		System.out.println(calendar.getTime());
		
		//este mostra os meses do ano de 0 a 11
		calendar.roll(Calendar.MONTH, 11);
		Date date3 = calendar.getTime();
		System.out.println(date3);
	}
}
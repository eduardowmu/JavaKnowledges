package br.edu.maratona.token;

import java.util.Scanner;

public class ScannerTest 
{	public static void main(String[] args) 
	{	Scanner scan = new Scanner("1 true 100 oi");
		while(scan.hasNext())	{System.out.print(scan.next()+" ");}
		System.out.println("\n");
		Scanner scan2 = new Scanner("1 true 100 oi");
		while(scan2.hasNext())
		{	if(scan2.hasNextInt())
			{	int i = Integer.parseInt(scan2.next());
				System.out.print(i + " ");
			}
			
			else if(scan2.hasNextBoolean())
			{	boolean bol = Boolean.parseBoolean(scan2.next());
				System.out.print(bol + " ");
			}
		
			else {System.out.print(scan2.next() + " ");}
		}
	}
}
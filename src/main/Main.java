package main;

import java.util.Scanner;

import model.CountryData;


public class Main {
public static Scanner reader = new Scanner(System.in);
	public static void main(String[] args) {
	
		CountryData data = new CountryData();
		data.loadTXT();
		data.ordenarMasc();
		data.ordenarFem();
		data.ordenarTotal();
		
		
		
		
		
	}	
}

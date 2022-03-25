package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CountryData {

	private ArrayList<Pais> countryData;
	private int totalOro;
	private int totalPlata;
	private int totalBronce;

	public CountryData() {
		countryData = new ArrayList<>();
	}

	public void loadTXT() {
		try {
			FileInputStream fis = new FileInputStream("paises.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			String txt = "";
			String line;
			while ((line = reader.readLine()) != null) {
				txt += line + "\n";
			}
			String[] lines = txt.split("\n");
			for (int i = 1; i < lines.length; i++) {
				String[] params = lines[i].split(";");
				totalOro = Integer.parseInt(params[1]) + Integer.parseInt(params[4]);
				totalPlata = Integer.parseInt(params[2]) + Integer.parseInt(params[5]);
				totalBronce = Integer.parseInt(params[3]) + Integer.parseInt(params[6]);
				Pais pais = new Pais(params[0], Integer.parseInt(params[1]), Integer.parseInt(params[2]),
						Integer.parseInt(params[3]), Integer.parseInt(params[4]), Integer.parseInt(params[5]),
						Integer.parseInt(params[6]), totalOro, totalPlata, totalBronce);
				countryData.add(pais);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ordenarFem() {
		Collections.sort(countryData);
		System.out.println("Femenino");
		for (Pais pais : countryData) {
			System.out.println(
					pais.getNombre() + " " + pais.getOroFem() + " " + pais.getPlataFem() + " " + pais.getBronceFem());
		}
		System.out.println("----------");

	}

	public void ordenarMasc() {
		Collections.sort(countryData, (A, B) -> {
			int oro = B.getOroMasc() - A.getOroMasc();
			if (oro == 0) {
				int plata = B.getPlataMasc() - A.getPlataMasc();
				if (plata == 0) {
					int bronce = B.getBronceMasc() - A.getBronceMasc();
					if (bronce == 0) {
						return B.getNombre().compareTo(A.getNombre());
					} else
						return bronce;
				} else
					return plata;
			} else
				return oro;
		});
		System.out.println("Masculino");
		for (Pais pais : countryData) {
			System.out.println(pais.getNombre() + " " + pais.getOroMasc() + " " + pais.getPlataMasc() + " "
					+ pais.getBronceMasc());
		}
		System.out.println("----------");

	}

	public void ordenarTotal() {
		Pais p = null;
		for (int i = 0; i < countryData.size(); i++) {
			for (int j = 1; j < countryData.size(); j++) {
				if (countryData.get(j).getTotalOro() > countryData.get(j - 1).getTotalOro()) {
					p = countryData.get(j - 1);
					countryData.set(j - 1, countryData.get(j));
					countryData.set(j, p);
				} else if (countryData.get(j).getTotalOro() == countryData.get(j - 1).getTotalOro()) {
					if (countryData.get(j).getTotalPlata() > countryData.get(j - 1).getTotalPlata()) {
						p = countryData.get(j - 1);
						countryData.set(j - 1, countryData.get(j));
						countryData.set(j, p);
					} else if (countryData.get(j).getTotalPlata() == countryData.get(j - 1).getTotalPlata()) {
						if (countryData.get(j).getTotalBronce() > countryData.get(j - 1).getTotalBronce()) {
							p = countryData.get(j - 1);
							countryData.set(j - 1, countryData.get(j));
							countryData.set(j, p);
						}
					}
				}
			}
		}

		System.out.println("Combinado");
		for (Pais pais : countryData) {
			System.out.println(pais.getNombre() + " " + pais.getTotalOro() + " " + pais.getTotalPlata() + " "
					+ pais.getTotalBronce());
		}
	}

}

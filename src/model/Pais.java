package model;

public class Pais implements Comparable<Pais> {
	
	private String nombre;
	private int oroMasc;
	private int plataMasc;
	private int bronceMasc;
	private int oroFem;
	private int plataFem;
	private int bronceFem;
	private int totalOro;
	private int totalPlata;
	private int totalBronce;

	//constructor
	public Pais(String nombre, int oroMasc, int plataMasc, int bronceMasc, int oroFem, int plataFem, int bronceFem,
			int totalOro, int totalPlata, int totalBronce) {
		this.nombre = nombre;
		this.oroMasc = oroMasc;
		this.plataMasc = plataMasc;
		this.bronceMasc = bronceMasc;
		this.oroFem = oroFem;
		this.plataFem = plataFem;
		this.bronceFem = bronceFem;
		this.totalOro = totalOro;
		this.totalPlata = totalPlata;
		this.totalBronce = totalBronce;
	}
	
	
	//setters & getters
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getOroMasc() {
		return oroMasc;
	}
	public void setOroMasc(int oroMasc) {
		this.oroMasc = oroMasc;
	}
	public int getPlataMasc() {
		return plataMasc;
	}
	public void setPlataMasc(int plataMasc) {
		this.plataMasc = plataMasc;
	}
	public int getBronceMasc() {
		return bronceMasc;
	}
	public void setBronceMasc(int bronceMasc) {
		this.bronceMasc = bronceMasc;
	}
	public int getOroFem() {
		return oroFem;
	}
	public void setOroFem(int oroFem) {
		this.oroFem = oroFem;
	}
	public int getPlataFem() {
		return plataFem;
	}
	public void setPlataFem(int plataFem) {
		this.plataFem = plataFem;
	}
	public int getBronceFem() {
		return bronceFem;
	}
	public void setBronceFem(int bronceFem) {
		this.bronceFem = bronceFem;
	}
	
	public int getTotalOro() {
		return totalOro;
	}


	public void setTotalOro(int totalOro) {
		this.totalOro = totalOro;
	}


	public int getTotalPlata() {
		return totalPlata;
	}


	public void setTotalPlata(int totalPlata) {
		this.totalPlata = totalPlata;
	}


	public int getTotalBronce() {
		return totalBronce;
	}


	public void setTotalBronce(int totalBronce) {
		this.totalBronce = totalBronce;
	}


	@Override
	public int compareTo(Pais o) {
		Pais A = this;
		Pais B = o;
		int oro = A.oroFem-B.oroFem;
		if(oro == 0) {
			int plata = A.plataFem-B.plataFem;
			if(plata == 0) {
				return A.bronceFem-B.bronceFem;
			}else {
				return plata;
			}
		}else {
			return oro;
		}
	}
	
	


}

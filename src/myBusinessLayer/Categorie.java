package myBusinessLayer;

public class Categorie {
	private int refCat;
	private String categorie;
	
	
	
	public Categorie() {
		super();
	}
	public Categorie(int refCat, String categorie) {
		super();
		this.refCat = refCat;
		this.categorie = categorie;
	}
	public int getRefCat() {
		return refCat;
	}
	public void setRefCat(int refCat) {
		this.refCat = refCat;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	

}

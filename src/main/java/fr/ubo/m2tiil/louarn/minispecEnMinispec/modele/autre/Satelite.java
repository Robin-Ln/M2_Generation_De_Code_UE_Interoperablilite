package fr.ubo.m2tiil.louarn.minispecEnMinispec.modele.autre;
public class Satelite {
	public String nom;
	public Flotte parent;
	public Satelite() {
		super();
	}
	public String getNom(){
		return this.nom;
		
	}
	public void setNom(String nom){
		this.nom = nom;
		
	}
	public Flotte getParent(){
		return this.parent;
		
	}
	public void setParent(Flotte parent){
		this.parent = parent;
		
	}
}

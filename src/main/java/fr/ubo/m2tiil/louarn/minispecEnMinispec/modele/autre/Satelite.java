package fr.ubo.m2tiil.louarn.minispecEnMinispec.modele.autre;
public class Satelite {
	public String nom;
	public Integer id;
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
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Flotte getParent(){
		return this.parent;
	}
	public void setParent(Flotte parent){
		this.parent = parent;
	}
}

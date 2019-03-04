package fr.ubo.m2tiil.louarn.minispecEnMinispec.modele.minispec;
import java.util.List;
public class Modele {
	public String name;
	public List<Entite> entites;
	public Modele() {
		super();
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public List<Entite> getEntites(){
		return this.entites;
	}
	public void setEntites(List<Entite> entites){
		this.entites = entites;
	}
}

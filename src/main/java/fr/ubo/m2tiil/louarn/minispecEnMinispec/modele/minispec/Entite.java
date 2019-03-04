package fr.ubo.m2tiil.louarn.minispecEnMinispec.modele.minispec;
import java.util.List;
public class Entite {
	public String name;
	public String subype;
	public List<Attribute> attributs;
	public Entite() {
		super();
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getSubype(){
		return this.subype;
	}
	public void setSubype(String subype){
		this.subype = subype;
	}
	public List<Attribute> getAttributs(){
		return this.attributs;
	}
	public void setAttributs(List<Attribute> attributs){
		this.attributs = attributs;
	}
}

package fr.ubo.m2tiil.louarn.minispecEnMinispec.modele.autre;
import java.util.List;
public class Flotte {
	public List<Satelite> satelites;
	public Flotte() {
		super();
	}
	public List<Satelite> getSatelites(){
		return this.satelites;
	}
	public void setSatelites(List<Satelite> satelites){
		this.satelites = satelites;
	}
}

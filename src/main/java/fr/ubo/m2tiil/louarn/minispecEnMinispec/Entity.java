package fr.ubo.m2tiil.louarn.minispecEnMinispec;
import java.util.List;
public class Entity {
	public String name;
	public Integer subype;
	public List<Attribute> attributs;
	public Entity() {
		super();
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public Integer getSubype(){
		return this.subype;
	}
	public void setSubype(Integer subype){
		this.subype = subype;
	}
	public List<Attribute> getAttributs(){
		return this.attributs;
	}
	public void setAttributs(List<Attribute> attributs){
		this.attributs = attributs;
	}
}

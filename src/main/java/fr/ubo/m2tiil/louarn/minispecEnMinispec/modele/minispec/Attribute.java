package fr.ubo.m2tiil.louarn.minispecEnMinispec.modele.minispec;
public class Attribute {
	public String name;
	public Type type;
	public Attribute() {
		super();
	}
	public String getName(){
		return this.name;
		
	}
	public void setName(String name){
		this.name = name;
		
	}
	public Type getType(){
		return this.type;
		
	}
	public void setType(Type type){
		this.type = type;
		
	}
}

package fr.ubo.m2tiil.louarn.minispecEnMinispec.modele.minispec;
public class Collection extends Type {
	public String typeCollection;
	public Type type;
	public Collection() {
		super();
	}
	public String getTypeCollection(){
		return this.typeCollection;
		
	}
	public void setTypeCollection(String typeCollection){
		this.typeCollection = typeCollection;
		
	}
	public Type getType(){
		return this.type;
		
	}
	public void setType(Type type){
		this.type = type;
		
	}
}

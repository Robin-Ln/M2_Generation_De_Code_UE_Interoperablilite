package fr.ubo.m2tiil.louarn.minispecEnMinispec.modele.minispec;
public class Array extends Type {
	public Type type;
	public Integer size;
	public Array() {
		super();
	}
	public Type getType(){
		return this.type;
		
	}
	public void setType(Type type){
		this.type = type;
		
	}
	public Integer getSize(){
		return this.size;
		
	}
	public void setSize(Integer size){
		this.size = size;
		
	}
}

package meta.modele;

import java.util.ArrayList;
import java.util.List;

import visiteurs.Visitable;
import visiteurs.Visitor;

public class Entity implements Visitable{
	
	/*
	 * Attributs
	 */
	private String name;
	private String subtype;
	private List<Attribute> attributes;
	
	/*
	 * Constructeur
	 */
	public Entity(String name) {
		super();
		this.name = name;
		this.attributes = new ArrayList<>();
	}
	
	/*
	 * Methodes
	 */
	@Override
	public void accept(Visitor visiteur) {
		visiteur.visite(this);
	}
	
	/*
	 * Accesseurs
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}
	
	

}

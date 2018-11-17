package meta.modele.generateClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
	public Entity() {
		super();
		this.attributes = new ArrayList<>();
	}
	
	/*
	 * Methodes
	 */
	@Override
	public void accept(Visitor visitor) {
		visitor.visite(this);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Entity entity = (Entity) o;
		return Objects.equals(name, entity.name);
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

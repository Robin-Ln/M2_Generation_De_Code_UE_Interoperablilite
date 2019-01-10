package fr.ubo.m2tiil.louarn.modele.minispec;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fr.ubo.m2tiil.louarn.visiteurs.minispec.VisitableMinispec;
import fr.ubo.m2tiil.louarn.visiteurs.minispec.VisitorMinispec;

public class Entity implements VisitableMinispec {
	
	/*
	 * Attributs
	 */
	private String name;
	private String subtype;
	private List<AttributeMinispec> attributeMinispecs;
	
	/*
	 * Constructeur
	 */
	public Entity() {
		super();
		this.attributeMinispecs = new ArrayList<>();
	}
	
	/*
	 * Methodes
	 */
	@Override
	public void accept(VisitorMinispec visitorMinispec) {
		visitorMinispec.visite(this);
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

	public List<AttributeMinispec> getAttributeMinispecs() {
		return attributeMinispecs;
	}

	public void setAttributeMinispecs(List<AttributeMinispec> attributeMinispecs) {
		this.attributeMinispecs = attributeMinispecs;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}
	
	

}

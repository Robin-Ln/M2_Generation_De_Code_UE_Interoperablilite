package visiteurs;

import java.util.ArrayList;
import java.util.List;

import meta.modele.Array;
import meta.modele.Attribute;
import meta.modele.Collection;
import meta.modele.Entity;
import meta.modele.Modele;

public class VisitorCheckHeritage implements Visitor {

	/*
	 * Attributs
	 */
	private List<Exception> exceptions;
	private Boolean valide;

	/*
	 * Constructeur
	 */
	public VisitorCheckHeritage() {
		super();
		this.exceptions = new ArrayList<>();
	}

	/*
	 * Merhode de l'interface Visitor
	 */
	@Override
	public void visite(Modele modele) {
		for(Entity entity : modele.getEntities()) {
			entity.accept(this);
		}
	}

	@Override
	public void visite(Entity entity) {
		if(entity.getSubtype() == null){
			return;
		}


	}

	@Override
	public void visite(Attribute attribute) {
	}

	@Override
	public void visite(Array array) {// initile
	}


	@Override
	public void visite(Collection associationMultiple) {// inutile
	}

	/*
	 * Accesseurs
	 */
	public List<Exception> getExceptions() {
		return exceptions;
	}

	public void setExceptions(List<Exception> exceptions) {
		this.exceptions = exceptions;
	}

	public Boolean getValide() {
		return valide;
	}

	public void setValide(Boolean valide) {
		this.valide = valide;
	}

}

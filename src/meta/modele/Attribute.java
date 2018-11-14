package meta.modele;

import visiteurs.Visitable;
import visiteurs.Visitor;

public class Attribute implements Visitable {

	/*
	 * Attributs
	 */
	private String name;
	private String type;

	/*
	 * Constructeur
	 */
	public Attribute(String name, String type) {
		super();
		this.name = name;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}

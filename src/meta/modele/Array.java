package meta.modele;

import visiteurs.Visitor;

public class Array extends Attribute{
	
	/*
	 * Attributs
	 */
	private Integer size;
	private String typeElements;
	
	/*
	 * Constructeurs
	 */
	public Array(String name, String type, Integer size, String typeElements) {
		super(name, type);
		this.size = size;
		this.typeElements = typeElements;
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
	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getTypeElements() {
		return typeElements;
	}

	public void setTypeElements(String typeElements) {
		this.typeElements = typeElements;
	}
}

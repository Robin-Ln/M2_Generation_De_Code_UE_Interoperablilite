package meta.modele;

import visiteurs.Visitor;

public class Collection extends Attribute{
	
	/*
	 * Attributs
	 */
	private String typeElements;
	private Integer min;
	private Integer max;
	
	/*
	 * Constructeurs
	 */
	public Collection(String name, String type, String typeElements) {
		super(name, type);
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
	public String getTypeElements() {
		return typeElements;
	}

	public void setTypeElements(String typeElements) {
		this.typeElements = typeElements;
	}
	
	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}
	
}

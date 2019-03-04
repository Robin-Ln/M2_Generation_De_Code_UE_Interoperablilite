package fr.ubo.m2tiil.louarn.modele.commun;

import fr.ubo.m2tiil.louarn.visiteurs.commun.VisitorCommun;

public class Collection implements Type {

    /*
     * Attributs
     */
	private String typeCollection;
    private Type type;
    private Integer min;
    private Integer max;

    /*
     * Constructeurs
     */
    public Collection() {
        super();
    }

    /*
     * Methodes
     */
    @Override
    public void accept(VisitorCommun visitorCommun) {
        visitorCommun.visite(this);
    }

    /*
     * Accesseurs
     */
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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

	public String getTypeCollection() {
		return typeCollection;
	}

	public void setTypeCollection(String typeCollection) {
		this.typeCollection = typeCollection;
	}

}
package fr.ubo.m2tiil.louarn.modele.commun;

import fr.ubo.m2tiil.louarn.visiteurs.commun.VisitorCommun;

import java.util.Objects;

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

    public Collection(String typeCollection, Type type) {
        this.typeCollection = typeCollection;
        this.type = type;
    }

    /*
     * Methodes
     */
    @Override
    public void accept(VisitorCommun visitorCommun) {
        visitorCommun.visite(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collection that = (Collection) o;
        return typeCollection.equals(that.typeCollection) &&
                type.equals(that.type) &&
                Objects.equals(min, that.min) &&
                Objects.equals(max, that.max);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeCollection, type, min, max);
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

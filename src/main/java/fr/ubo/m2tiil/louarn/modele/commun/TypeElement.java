package fr.ubo.m2tiil.louarn.modele.commun;

import fr.ubo.m2tiil.louarn.visiteurs.commun.VisitorCommun;

import java.util.Objects;

public class TypeElement implements Type {

    /*
     * Attributs
     */
    private String type;


    /*
     * Constructeurs
     */
    public TypeElement() {
        super();
    }

    public TypeElement(String type) {
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
        TypeElement that = (TypeElement) o;
        return type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    /*
     * Accesseurs
     */
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

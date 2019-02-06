package fr.ubo.m2tiil.louarn.modele.commun;

import fr.ubo.m2tiil.louarn.visiteurs.commun.VisitorCommun;

public class Array implements Type {

    /*
     * Attributs
     */
    private Integer size;
    private Type type;

    /*
     * Constructeurs
     */
    public Array() {
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
    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}

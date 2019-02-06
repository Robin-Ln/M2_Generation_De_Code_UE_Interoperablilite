package fr.ubo.m2tiil.louarn.modele.commun;

import fr.ubo.m2tiil.louarn.visiteurs.commun.VisitorCommun;

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
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

package fr.ubo.m2tiil.louarn.modele.dependance;

import fr.ubo.m2tiil.louarn.visiteurs.dependance.VisitorDependance;

public class Primitive extends Dependance {
    /*
     * Attributte
     */
    private String type;

    /*
     * Constructeur
     */
    public Primitive() {
        super();
    }

    /*
     * Méthodes
     */

    @Override
    public void accept(VisitorDependance visitorDependance) {
        visitorDependance.visite(this);
    }

    /*
     * Accesseurs
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

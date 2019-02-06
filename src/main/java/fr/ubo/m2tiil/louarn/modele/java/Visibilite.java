package fr.ubo.m2tiil.louarn.modele.java;

import fr.ubo.m2tiil.louarn.visiteurs.commun.VisitorCommun;
import fr.ubo.m2tiil.louarn.visiteurs.javacode.VisitableJava;
import fr.ubo.m2tiil.louarn.visiteurs.javacode.VisitorJava;

public enum Visibilite implements VisitableJava {

    /*
     * Valueurs énumérées
     */

    PRIVATE ("private"),
    PROTECTED ("protected"),
    PUBLIC ("public");

    /*
     * Attributs
     */
    private String visibilite;

    /*
     * Constructeurs
     */
    Visibilite(String visibilite) {
        this.visibilite = visibilite;
    }

    /*
     * Valueurs énumérées
     */
    public String getVisibilite() {
        return visibilite;
    }


    /*
     * Métode visitable
     */
    @Override
    public void accept(VisitorJava visitorJava) {
        visitorJava.visite(this);
    }
}

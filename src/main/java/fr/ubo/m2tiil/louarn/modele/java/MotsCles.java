package fr.ubo.m2tiil.louarn.modele.java;

import fr.ubo.m2tiil.louarn.visiteurs.java.VisitableJava;
import fr.ubo.m2tiil.louarn.visiteurs.java.VisitorJava;

public enum MotsCles implements VisitableJava {
    /*
     * Valueurs énumérées
     */

    CLASS ("class"),
    ENUM ("enum"),
    ABSTRACT ("abstract"),
    INTERFACE ("interface"),

    IMPLEMETNS("implements"),
    EXTENDS ("extends"),


    PRIVATE ("private"),
    PROTECTED ("protected"),
    PUBLIC ("public");

    /*
     * Attributs
     */
    private String motCle;

    /*
     * Constructeurs
     */
    MotsCles(String motCle) {
        this.motCle = motCle;
    }

    /*
     * Valueurs énumérées
     */

    public String getMotCle() {
        return motCle;
    }

    /*
     * Métodes
     */
    @Override
    public void accept(VisitorJava visitorJava) {
        visitorJava.visite(this);
    }

}

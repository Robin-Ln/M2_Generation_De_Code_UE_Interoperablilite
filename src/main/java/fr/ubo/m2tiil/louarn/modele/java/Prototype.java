package fr.ubo.m2tiil.louarn.modele.java;

import fr.ubo.m2tiil.louarn.visiteurs.java.VisitableJava;
import fr.ubo.m2tiil.louarn.visiteurs.java.VisitorJava;

public enum Prototype implements VisitableJava {

    /*
     * Valueurs énumérées
     */

    CLASS ("class"),
    ABSTRACT_CLASS ("abstract class"),
    INTERFACE ("interface"),
    ENUM ("enum");

    /*
     * Attributs
     */
    private String prototype;

    /*
     * Constructeurs
     */
    Prototype(String prototype) {
        this.prototype = prototype;
    }

    /*
     * Valueurs énumérées
     */

    public String getPrototype() {
        return prototype;
    }

    /*
     * Métode visitable
     */
    @Override
    public void accept(VisitorJava visitorJava) {
        visitorJava.visite(this);
    }
}

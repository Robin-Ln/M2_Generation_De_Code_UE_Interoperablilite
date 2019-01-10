package fr.ubo.m2tiil.louarn.modele.java;

import fr.ubo.m2tiil.louarn.modele.minispec.AttributeMinispec;
import fr.ubo.m2tiil.louarn.visiteurs.javacode.VisitableJava;
import fr.ubo.m2tiil.louarn.visiteurs.javacode.VisitorJava;

import java.util.List;

public class Class implements VisitableJava {

    /*
     * Attributs
     */
    private String name;
    private String subtype;
    private List<AttributeMinispec> attributeMinispecs;

    /*
     * Constructeur
     */


    /*
     * Methodes
     */
    @Override
    public void accept(VisitorJava visitorJava) {
        visitorJava.visite(this);
    }


    /*
     * Accesseurs
     */

}

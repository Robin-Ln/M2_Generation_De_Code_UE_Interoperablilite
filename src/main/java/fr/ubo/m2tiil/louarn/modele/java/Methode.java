package fr.ubo.m2tiil.louarn.modele.java;

import fr.ubo.m2tiil.louarn.modele.commun.Type;
import fr.ubo.m2tiil.louarn.visiteurs.javacode.VisitableJava;
import fr.ubo.m2tiil.louarn.visiteurs.javacode.VisitorJava;

import java.util.ArrayList;
import java.util.List;

public class Methode implements VisitableJava {

    /*
     * Attributs
     */

    private Visibilite visibilite;
    private String name;
    private Type type;
    private List<Argument> arguments;


    /*
     * Constructeurs
     */

    public Methode() {
        this.arguments = new ArrayList<>();
    }

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

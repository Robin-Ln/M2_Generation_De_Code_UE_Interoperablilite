package fr.ubo.m2tiil.louarn.modele.java;

import fr.ubo.m2tiil.louarn.visiteurs.java.VisitableJava;
import fr.ubo.m2tiil.louarn.visiteurs.java.VisitorJava;

import java.util.ArrayList;
import java.util.List;

public class Bloc implements VisitableJava {
    /*
     * Attributs
     */
    StringBuilder lignes;

    /*
     * Constructeurs
     */

    public Bloc() {
        this.lignes = new StringBuilder();
    }

    public Bloc(StringBuilder bloc) {
        this.lignes = bloc;
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

    public StringBuilder getLignes() {
        return lignes;
    }

    public void setLignes(StringBuilder lignes) {
        this.lignes = lignes;
    }
}

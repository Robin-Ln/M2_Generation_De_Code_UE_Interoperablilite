package fr.ubo.m2tiil.louarn.modele.java;

import fr.ubo.m2tiil.louarn.visiteurs.javacode.VisitableJava;
import fr.ubo.m2tiil.louarn.visiteurs.javacode.VisitorJava;

public class Constructeur implements VisitableJava {
    /*
     * Attributs
     */
    private Visibilite visibilite;
    private Class aClass;

    /*
     * Constructeurs
     */

    public Constructeur() {
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

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public Visibilite getVisibilite() {
        return visibilite;
    }

    public void setVisibilite(Visibilite visibilite) {
        this.visibilite = visibilite;
    }
}

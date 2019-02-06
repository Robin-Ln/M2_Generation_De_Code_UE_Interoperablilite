package fr.ubo.m2tiil.louarn.modele.java;

import fr.ubo.m2tiil.louarn.visiteurs.javacode.VisitableJava;
import fr.ubo.m2tiil.louarn.visiteurs.javacode.VisitorJava;

import java.util.ArrayList;
import java.util.List;

public class ModeleJava implements VisitableJava {
    /*
     * Attributs
     */
    List<Class> aClasses;

    /*
     * Constructeurs
     */

    public ModeleJava() {
        this.aClasses = new ArrayList<>();
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

    public List<Class> getaClasses() {
        return aClasses;
    }

    public void setaClasses(List<Class> aClasses) {
        this.aClasses = aClasses;
    }
}

package fr.ubo.m2tiil.louarn.modele.java;

import fr.ubo.m2tiil.louarn.visiteurs.java.VisitableJava;
import fr.ubo.m2tiil.louarn.visiteurs.java.VisitorJava;

import java.util.ArrayList;
import java.util.List;

public class ModeleJava implements VisitableJava {
    /*
     * Attributs
     */
    private String name;
    private List<Class> aClasses;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Class> getaClasses() {
        return aClasses;
    }

    public void setaClasses(List<Class> aClasses) {
        this.aClasses = aClasses;
    }
}

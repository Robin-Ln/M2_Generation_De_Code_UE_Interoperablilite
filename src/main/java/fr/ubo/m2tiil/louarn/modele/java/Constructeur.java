package fr.ubo.m2tiil.louarn.modele.java;

import fr.ubo.m2tiil.louarn.visiteurs.java.VisitableJava;
import fr.ubo.m2tiil.louarn.visiteurs.java.VisitorJava;

import java.util.ArrayList;
import java.util.List;

public class Constructeur implements VisitableJava {
    /*
     * Attributs
     */
    private List<MotsCles> motsCles;
    private Class aClass;
    private List<Argument> arguments;

    /*
     * Constructeurs
     */

    public Constructeur() {
        this.motsCles = new ArrayList<>();
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

    public List<MotsCles> getMotsCles() {
        return motsCles;
    }

    public void setMotsCles(List<MotsCles> motsCles) {
        this.motsCles = motsCles;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public List<Argument> getArguments() {
        return arguments;
    }

    public void setArguments(List<Argument> arguments) {
        this.arguments = arguments;
    }
}

package fr.ubo.m2tiil.louarn.modele.java;

import fr.ubo.m2tiil.louarn.modele.commun.Type;
import fr.ubo.m2tiil.louarn.modele.commun.TypeElement;
import fr.ubo.m2tiil.louarn.visiteurs.java.VisitableJava;
import fr.ubo.m2tiil.louarn.visiteurs.java.VisitorJava;

public class Argument implements VisitableJava {
    /*
     * Attributs
     */

    private Type type;
    private String name;


    /*
     * Constructeurs
     */

    public Argument() {
    }

    public Argument(String type, String name) {
        this.type = new TypeElement(type);
        this.name = name;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

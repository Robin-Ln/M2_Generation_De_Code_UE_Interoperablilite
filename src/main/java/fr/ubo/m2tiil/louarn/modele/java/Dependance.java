package fr.ubo.m2tiil.louarn.modele.java;

import fr.ubo.m2tiil.louarn.visiteurs.java.VisitableJava;
import fr.ubo.m2tiil.louarn.visiteurs.java.VisitorJava;

public class Dependance implements VisitableJava {

    /*
     * Attributte
     */
    private String name;
    private String packageName;
    private String type;

    /**
     * Constructeur
     */

    public Dependance(String name, String packageName) {
        this.name = name;
        this.packageName = packageName;
    }

    public Dependance() {
        super();
    }

    /**
     * Méthodes
     */
    @Override
    public void accept(VisitorJava visitorJava) {
        visitorJava.accept(this);
    }

    /**
     * Accesseurs
     */

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

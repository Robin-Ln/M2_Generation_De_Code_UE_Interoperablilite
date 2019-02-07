package fr.ubo.m2tiil.louarn.modele.java;

import fr.ubo.m2tiil.louarn.modele.dependance.Dependance;
import fr.ubo.m2tiil.louarn.visiteurs.javacode.VisitableJava;
import fr.ubo.m2tiil.louarn.visiteurs.javacode.VisitorJava;

import java.util.ArrayList;
import java.util.List;

public class Class implements VisitableJava {

    /*
     * Attributs
     */

    private String name;
    private String subtype;
    private List<AttributeJava> attributeJavas;
    private List<Constructeur> constructeurs;
    private List<Methode> methodes;
    private List<Dependance> dependances;

    /*
     * Constructeur
     */

    public Class() {
        super();
        this.attributeJavas = new ArrayList<>();
        this.constructeurs = new ArrayList<>();
        this.methodes = new ArrayList<>();
    }

    public Class(String name, String subtype) {
        this.name = name;
        this.subtype = subtype;
        this.attributeJavas = new ArrayList<>();
        this.constructeurs = new ArrayList<>();
        this.methodes = new ArrayList<>();
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

    public List<Dependance> getDependances() {
        return dependances;
    }

    public void setDependances(List<Dependance> dependances) {
        this.dependances = dependances;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public List<AttributeJava> getAttributeJavas() {
        return attributeJavas;
    }

    public void setAttributeJavas(List<AttributeJava> attributeJavas) {
        this.attributeJavas = attributeJavas;
    }

    public List<Constructeur> getConstructeurs() {
        return constructeurs;
    }

    public void setConstructeurs(List<Constructeur> constructeurs) {
        this.constructeurs = constructeurs;
    }

    public List<Methode> getMethodes() {
        return methodes;
    }

    public void setMethodes(List<Methode> methodes) {
        this.methodes = methodes;
    }
}

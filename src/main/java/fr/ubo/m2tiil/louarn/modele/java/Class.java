package fr.ubo.m2tiil.louarn.modele.java;

import fr.ubo.m2tiil.louarn.modele.dependance.Dependance;
import fr.ubo.m2tiil.louarn.visiteurs.java.VisitableJava;
import fr.ubo.m2tiil.louarn.visiteurs.java.VisitorJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Class implements VisitableJava {

    /*
     * Attributs
     */
    private List<MotsCles> motsCles;

    private String aPackage;

    private List<Dependance> dependances;

    private String name;

    private String supertype;

    private List<String> generiqueClasses;

    private List<AttributeJava> attributeJavas;

    private List<Constructeur> constructeurs;

    private List<Methode> methodes;

    /*
     * Constructeur
     */

    public Class() {
        super();
        this.attributeJavas = new ArrayList<>();
        this.constructeurs = new ArrayList<>();
        this.methodes = new ArrayList<>();
        this.dependances = new ArrayList<>();
        this.generiqueClasses = new ArrayList<>();
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

    public String getaPackage() {
        return aPackage;
    }

    public void setaPackage(String aPackage) {
        this.aPackage = aPackage;
    }

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

    public String getSupertype() {
        return supertype;
    }

    public void setSupertype(String supertype) {
        this.supertype = supertype;
    }

    public List<String> getGeneriqueClasses() {
        return generiqueClasses;
    }

    public void setGeneriqueClasses(List<String> generiqueClasses) {
        this.generiqueClasses = generiqueClasses;
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

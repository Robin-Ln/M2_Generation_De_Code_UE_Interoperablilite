package fr.ubo.m2tiil.louarn.modele.repesitory;

import fr.ubo.m2tiil.louarn.modele.java.Class;

public class Instance {
    /*
     * Attributs
     */
    private String name;
    private Reference reference;
    private Class aClass;

    /*
     * Constructeurs
     */

    public Instance() {
        super();
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

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }
}

package fr.ubo.m2tiil.louarn.modele.repesitory;

import fr.ubo.m2tiil.louarn.modele.java.ModeleJava;

import java.util.List;

public class Repesitory {
    /*
     * Attributs
     */
    List<Instance> instances;
    List<ModeleJava> modeles;

    /*
     * Constructeurs
     */

    public Repesitory() {
        super();
    }

    /*
     * Accesseurs
     */

    public List<Instance> getInstances() {
        return instances;
    }

    public void setInstances(List<Instance> instances) {
        this.instances = instances;
    }

    public List<ModeleJava> getModeles() {
        return modeles;
    }

    public void setModeles(List<ModeleJava> modeles) {
        this.modeles = modeles;
    }
}

package fr.ubo.m2tiil.louarn.visiteurs.dependance;

import fr.ubo.m2tiil.louarn.modele.commun.Array;
import fr.ubo.m2tiil.louarn.modele.commun.Collection;
import fr.ubo.m2tiil.louarn.modele.commun.TypeElement;
import fr.ubo.m2tiil.louarn.modele.java.*;
import fr.ubo.m2tiil.louarn.visiteurs.commun.VisitorCommun;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VisitorDependance implements VisitorCommun {

    /*
     * Attributs
     */

    List<Dependance> dependances;
    Set<Dependance> resultat;

    /*
     * Constructeur
     */
    public VisitorDependance(List<Dependance> dependancesRef) {
        super();
        this.dependances = dependancesRef;
    }

    /*
     * Merhode de l'interface VisitorJava
     */

    @Override
    public void visite(Array array) {
        array.getType().accept(this);
    }

    @Override
    public void visite(Collection collection) {
        collection.getType().accept(this);

        Dependance dependance = this.findDepeandanceByName(collection.getTypeCollection());
        if (dependance != null) {
            this.resultat.add(dependance);
        }
    }

    @Override
    public void visite(TypeElement typeElement) {
        Dependance dependance = this.findDepeandanceByName(typeElement.getType());
        if (dependance != null) {
            this.resultat.add(dependance);
        }
    }


    public void getAttributeDependances(AttributeJava attributeJava) {
        attributeJava.getType().accept(this);
    }

    public void getConstructeurDependances(Constructeur constructeur) {
        for (Argument argument : constructeur.getArguments()) {
            argument.getType().accept(this);
        }
    }

    private void getMethodesDependances(Methode methode) {
        // depandance de type de retoure
        methode.getType().accept(this);

        // dependance des argument
        for (Argument argument : methode.getArguments()) {
            argument.getType().accept(this);
        }
    }

    public List<Dependance> getClazzDependances(Clazz clazz) {
        this.resultat = new HashSet<>();

        Dependance dependance = this.findDepeandanceByName(clazz.getSupertype());
        if (dependance != null) {
            this.resultat.add(dependance);
        }

        for (AttributeJava attributeJava : clazz.getAttributeJavas()) {
            this.getAttributeDependances(attributeJava);
        }

        for (Constructeur constructeur : clazz.getConstructeurs()) {
            this.getConstructeurDependances(constructeur);
        }

        for (Methode methode : clazz.getMethodes()) {
            this.getMethodesDependances(methode);
        }


        return new ArrayList<>(this.resultat);
    }


    private Dependance findDepeandanceByName(String name) {
        //TODO il faut géré les null
        for (Dependance dependance : this.dependances) {
            if (dependance.getName().equals(name)) {
                return dependance;
            }
        }
        return null;
    }



}

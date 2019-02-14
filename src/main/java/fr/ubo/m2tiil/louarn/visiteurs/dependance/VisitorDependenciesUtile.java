package fr.ubo.m2tiil.louarn.visiteurs.dependance;

import fr.ubo.m2tiil.louarn.modele.commun.Array;
import fr.ubo.m2tiil.louarn.modele.commun.Collection;
import fr.ubo.m2tiil.louarn.modele.commun.TypeElement;
import fr.ubo.m2tiil.louarn.modele.dependance.Dependance;
import fr.ubo.m2tiil.louarn.modele.java.Class;
import fr.ubo.m2tiil.louarn.modele.java.*;
import fr.ubo.m2tiil.louarn.visiteurs.commun.VisitorCommun;
import fr.ubo.m2tiil.louarn.visiteurs.java.VisitorJava;

import java.util.ArrayList;
import java.util.List;

public class VisitorDependenciesUtile implements VisitorJava, VisitorCommun {

    /*
     * Attributs
     */

    List<Dependance> dependancesRef;
    List<Dependance> dependancesUtile;


    /*
     * Constructeur
     */
    public VisitorDependenciesUtile(List<Dependance> dependancesRef) {
        super();
        this.dependancesRef = dependancesRef;
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
        this.addDependanceUtile(collection.getTypeCollection());
    }

    @Override
    public void visite(TypeElement typeElement) {
        this.addDependanceUtile(typeElement.getType());
    }

    @Override
    public void visite(Argument argument) {
        argument.getType().accept(this);
    }

    @Override
    public void visite(AttributeJava attributeJava) {
        attributeJava.getType().accept(this);
    }

    @Override
    public void visite(Class aClass) {
        this.dependancesUtile = new ArrayList<>();

        this.addDependanceUtile(aClass.getSupertype());
        for (AttributeJava attributeJava : aClass.getAttributeJavas()){
            attributeJava.accept(this);
        }

        aClass.setDependances(this.dependancesUtile);
    }

    @Override
    public void visite(Constructeur constructeur) {
        for (Argument argument : constructeur.getArguments()) {
            argument.accept(this);
        }
    }

    @Override
    public void visite(Methode methode) {
        methode.getType().accept(this);
        for (Argument argument : methode.getArguments()) {
            argument.accept(this);
        }
    }

    @Override
    public void visite(ModeleJava modeleJava) {
        for (Class aClass : modeleJava.getaClasses()) {
            aClass.accept(this);
        }
    }

    @Override
    public void visite(Visibilite visibilite) {
    }

    @Override
    public void visite(Bloc bloc) {
    }

    /*
     * Methodes
     */
    private void addDependanceUtile(String name) {
        for (Dependance dependanceRef : this.dependancesRef) {
            if (dependanceRef.getName().equals(name)) {
                this.dependancesUtile.add(dependanceRef);
                return;
            }
        }
    }

    /*
     * Accesseurs
     */

    public List<Dependance> getDependancesRef() {
        return dependancesRef;
    }

    public void setDependancesRef(List<Dependance> dependancesRef) {
        this.dependancesRef = dependancesRef;
    }

    public List<Dependance> getDependancesUtile() {
        return dependancesUtile;
    }

    public void setDependancesUtile(List<Dependance> dependancesUtile) {
        this.dependancesUtile = dependancesUtile;
    }
}

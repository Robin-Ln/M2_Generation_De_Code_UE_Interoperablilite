package fr.ubo.m2tiil.louarn.visiteurs.repository;

import fr.ubo.m2tiil.louarn.modele.commun.Array;
import fr.ubo.m2tiil.louarn.modele.commun.Collection;
import fr.ubo.m2tiil.louarn.modele.commun.TypeElement;
import fr.ubo.m2tiil.louarn.modele.java.Class;
import fr.ubo.m2tiil.louarn.modele.java.*;
import fr.ubo.m2tiil.louarn.visiteurs.commun.VisitorCommun;

import java.util.ArrayList;
import java.util.List;

public class VisitorCreerInstance implements VisitorCommun {

    /**
     * Attributes
     */


    private Boolean isCollection;

    /**
     * Constructeurs
     */
    public VisitorCreerInstance() {
        this.isCollection = false;
    }

    /**
     * Methodes
     */

    @Override
    public void visite(Array array) {
        this.isCollection = true;
    }

    @Override
    public void visite(Collection collection) {
        this.isCollection = true;
    }

    @Override
    public void visite(TypeElement typeElement) {
        this.isCollection = false;
    }


    public void visite(AttributeJava attributeJava) {
        attributeJava.getType().accept(this);
    }

    public Class creerInstanceClass(Class aClass) {

        Class instance = new Class();
        instance.setName(aClass.getName() + "Instance");

        for (AttributeJava attributeJava : aClass.getAttributeJavas()) {
            attributeJava.getType().accept(this);
            instance.getAttributeJavas().add(this.getAttribute(attributeJava.getName()));
        }
        return instance;
    }



    public ModeleJava creerInstanceModele(ModeleJava modeleJava) {

        ModeleJava modeleJavaInstance = new ModeleJava();
        modeleJavaInstance.setName("fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance");

        List<Class> instances = new ArrayList<>();

        for (Class aClass : modeleJava.getaClasses()) {
            Class instance = this.creerInstanceClass(aClass);
            instance.setaPackage("fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance");
            instances.add(instance);
        }

        modeleJavaInstance.setaClasses(instances);
        return modeleJavaInstance;
    }


    /**
     * Methode utilile
     */

    AttributeJava getAttribute(String name) {
        AttributeJava attributeJava = new AttributeJava();
        attributeJava.setName(name);
        attributeJava.setVisibilite(Visibilite.PUBLIC);

        TypeElement typeElement = new TypeElement();
        typeElement.setType("String");

        if (this.isCollection) {
            Collection collection = new Collection();
            collection.setType(typeElement);
            collection.setTypeCollection("List");
            attributeJava.setType(collection);

        } else {
            attributeJava.setType(typeElement);
        }

        return attributeJava;
    }
}

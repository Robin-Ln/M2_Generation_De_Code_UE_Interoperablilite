package fr.ubo.m2tiil.louarn.repository;

import fr.ubo.m2tiil.louarn.modele.commun.TypeElement;
import fr.ubo.m2tiil.louarn.modele.java.Class;
import fr.ubo.m2tiil.louarn.modele.java.*;

import java.util.ArrayList;
import java.util.List;

public class CreerInstance {

    private static final String P_NAME = "fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance";


    /**
     * Constructeurs
     */
    public CreerInstance() {
        super();
    }

    /**
     * Methodes
     */


    private Class creerInstanceClass(Class aClass) {

        Class instance = new Class();
        instance.setName(aClass.getName() + "Instance");

        for (AttributeJava attributeJava : aClass.getAttributeJavas()) {
            instance.getAttributeJavas().add(this.getAttribute(attributeJava.getName()));
        }
        return instance;
    }



    public ModeleJava creerInstanceModele(ModeleJava modeleJava) {

        ModeleJava modeleJavaInstance = new ModeleJava();
        modeleJavaInstance.setName(CreerInstance.P_NAME);

        List<Class> instances = new ArrayList<>();

        for (Class aClass : modeleJava.getaClasses()) {
            Class instance = this.creerInstanceClass(aClass);
            instance.setaPackage(CreerInstance.P_NAME);
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


        attributeJava.setType(typeElement);


        return attributeJava;
    }
}

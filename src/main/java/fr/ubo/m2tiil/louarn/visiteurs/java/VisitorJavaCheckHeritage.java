package fr.ubo.m2tiil.louarn.visiteurs.java;

import fr.ubo.m2tiil.louarn.modele.java.Class;
import fr.ubo.m2tiil.louarn.modele.java.*;

import java.util.ArrayList;
import java.util.List;

public class VisitorJavaCheckHeritage implements VisitorJava {

    /*
     * Attributs
     */
    private List<Exception> exceptions;
    private ModeleJava modeleJava;

    /*
     * Constructeur
     */
    public VisitorJavaCheckHeritage() {
        super();
        this.exceptions = new ArrayList<>();
    }

    /*
     * Merhode de l'interface VisitorJava
     */
    @Override
    public void visite(ModeleJava modeleJava) {
        this.modeleJava = modeleJava;

        for (Class aClass : this.modeleJava.getaClasses()) {
            aClass.accept(this);
        }
    }

    @Override
    public void visite(Class aClass) {

        // verifier le bouclage
        // si pas de super class pas de bouclage
        if (aClass.getSupertype() != null) {
            List<Class> superClasses = this.getSuperClasses(aClass.getName());

            for (Class superClass : superClasses) {
                // si egaliter il y a un bouclage
                if (aClass.getSupertype().equals(superClass.getName())) {
                    this.exceptions.add(new Exception("Bouclage entre : " + aClass.getName() + " et " + superClass.getName()));
                }
            }
        }

        // verifier les doublons des attributs
        List<AttributeJava> superAttributes = this.getSuperAttributes(aClass.getName());
        for (AttributeJava attribute : aClass.getAttributeJavas()) {
            for (AttributeJava superAttribute : superAttributes) {
                if (attribute.getName().equals(superAttribute.getName())) {
                    this.exceptions.add(new Exception("doublon l'attibut : " + attribute.getName() + " de la classe " + aClass.getName()));
                }
            }
        }
    }

    @Override
    public void visite(Argument argument) {
    }

    @Override
    public void visite(AttributeJava attributeJava) {
    }

    @Override
    public void visite(Constructeur constructeur) {
    }

    @Override
    public void visite(Methode methode) {
    }

    @Override
    public void visite(Visibilite visibilite) {
    }

    @Override
    public void visite(Bloc bloc) {
    }

    /*
     * Methode prive
     */
    private List<Class> getSuperClasses(String name) {
        List<Class> classes = new ArrayList<>();

        for (Class aClass : this.modeleJava.getaClasses()) {
            if (name.equals(aClass.getSupertype())) {
                classes.add(aClass);
            }
        }
        return classes;
    }

    private List<AttributeJava> getSuperAttributes(String name) {
        List<AttributeJava> attributes = new ArrayList<>();

        for (Class aClass : this.modeleJava.getaClasses()) {
            if (name.equals(aClass.getSupertype())) {
                attributes.addAll(aClass.getAttributeJavas());
            }
        }
        return attributes;
    }

    /*
     * Accesseurs
     */

    public List<Exception> getExceptions() {
        return exceptions;
    }

    public void setExceptions(List<Exception> exceptions) {
        this.exceptions = exceptions;
    }
}

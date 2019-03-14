package fr.ubo.m2tiil.louarn.utils;

import fr.ubo.m2tiil.louarn.modele.java.Clazz;
import fr.ubo.m2tiil.louarn.modele.java.*;

import java.util.ArrayList;
import java.util.List;

public class CheckHeritage {

    /*
     * Attributs
     */
    private List<Exception> exceptions;
    private ModeleJava modeleJava;

    /*
     * Constructeur
     */
    public CheckHeritage() {
        super();
        this.exceptions = new ArrayList<>();
    }

    /*
     * Merhode de l'interface VisitorJava
     */
    public void checkHeritage(ModeleJava modeleJava) {
        this.modeleJava = modeleJava;

        for (Clazz aClazz : this.modeleJava.getClazzes()) {
            checkHeritageFor(aClazz);
        }
    }

    public void checkHeritageFor(Clazz aClazz) {

        // verifier le bouclage
        // si pas de super class pas de bouclage
        if (aClazz.getSupertype() != null) {
            List<Clazz> superClazzes = this.getSuperClasses(aClazz.getName());

            for (Clazz superClazz : superClazzes) {
                // si egaliter il y a un bouclage
                if (aClazz.getSupertype().equals(superClazz.getName())) {
                    this.exceptions.add(new Exception("Bouclage entre : " + aClazz.getName() + " et " + superClazz.getName()));
                }
            }
        }

        // verifier les doublons des attributs
        List<AttributeJava> superAttributes = this.getSuperAttributes(aClazz.getName());
        for (AttributeJava attribute : aClazz.getAttributeJavas()) {
            for (AttributeJava superAttribute : superAttributes) {
                if (attribute.getName().equals(superAttribute.getName())) {
                    this.exceptions.add(new Exception("doublon l'attibut : " + attribute.getName() + " de la classe " + aClazz.getName()));
                }
            }
        }
    }

    /*
     * Methode prive
     */
    private List<Clazz> getSuperClasses(String name) {
        List<Clazz> clazzes = new ArrayList<>();

        for (Clazz aClazz : this.modeleJava.getClazzes()) {
            if (name.equals(aClazz.getSupertype())) {
                clazzes.add(aClazz);
            }
        }
        return clazzes;
    }

    private List<AttributeJava> getSuperAttributes(String name) {
        List<AttributeJava> attributes = new ArrayList<>();

        for (Clazz aClazz : this.modeleJava.getClazzes()) {
            if (name.equals(aClazz.getSupertype())) {
                attributes.addAll(aClazz.getAttributeJavas());
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

package fr.ubo.m2tiil.louarn.visiteurs.javacode;

import fr.ubo.m2tiil.louarn.modele.commun.Array;
import fr.ubo.m2tiil.louarn.modele.commun.Collection;
import fr.ubo.m2tiil.louarn.modele.commun.TypeElement;
import fr.ubo.m2tiil.louarn.modele.java.*;
import fr.ubo.m2tiil.louarn.modele.java.Class;

import java.io.PrintStream;

public class VisitorJavaPrinter implements VisitorJava {

    /*
     * Attributs
     */
    private PrintStream out;

    /*
     * Constructeur
     */
    public VisitorJavaPrinter(PrintStream out) {
        this.out = out;
    }

    /*
     * Merhode de l'interface Visotor
     */

    @Override
    public void visite(Array array) {

    }

    @Override
    public void visite(Collection collection) {

    }

    @Override
    public void visite(TypeElement typeElement) {

    }

    @Override
    public void visite(Argument argument) {

    }

    @Override
    public void visite(AttributeJava attributeJava) {

    }

    @Override
    public void visite(Class Class) {

    }

    @Override
    public void visite(Constructeur constructeur) {

    }

    @Override
    public void visite(Methode methode) {

    }

    @Override
    public void visite(ModeleJava modeleJava) {

    }
}

package fr.ubo.m2tiil.louarn.visiteurs.javacode;

import fr.ubo.m2tiil.louarn.modele.java.Class;
import fr.ubo.m2tiil.louarn.modele.java.*;
import fr.ubo.m2tiil.louarn.visiteurs.commun.VisitorCommun;
import fr.ubo.m2tiil.louarn.visiteurs.commun.VisitorCommunPrinter;

import java.io.PrintStream;

public class VisitorJavaPrinter implements VisitorJava {

    /*
     * Attributs
     */
    private PrintStream out;
    private VisitorCommun visitorCommun;

    /*
     * Constructeur
     */
    public VisitorJavaPrinter(PrintStream out) {
        this.out = out;
        this.visitorCommun = new VisitorCommunPrinter(this.out);
    }

    /*
     * Merhode de l'interface Visotor
     */

    @Override
    public void visite(Argument argument) {
        argument.getType().accept(this.visitorCommun);
        this.out.print(" " +argument.getName());
    }

    @Override
    public void visite(AttributeJava attributeJava) {
        attributeJava.getVisibilite().accept(this);
        this.out.print(" ");
        attributeJava.getType().accept(this.visitorCommun);
        this.out.print(" ");
        this.out.print(attributeJava.getName());
    }

    @Override
    public void visite(Visibilite visibilite) {
        this.out.print(visibilite.getVisibilite());
    }

    @Override
    public void visite(Class aClass) {
        out.print("public class " + aClass.getName());
        if (aClass.getSubtype() == null || aClass.getSubtype().equals("")) {
            out.print(" extends " + aClass.getSubtype());
        }

        out.println(" {");

        for (AttributeJava attributeJava : aClass.getAttributeJavas()) {
            attributeJava.accept(this);
        }

        for (Constructeur constructeur : aClass.getConstructeurs()) {
            constructeur.accept(this);
        }

        out.println("}");
    }

    @Override
    public void visite(Constructeur constructeur) {
        constructeur.getVisibilite().accept(this);
        out.print(" " + constructeur.getaClass().getName());
    }

    @Override
    public void visite(Methode methode) {
        methode.getVisibilite().accept(this);
        this.out.print(" ");
        methode.getType().accept(this.visitorCommun);
        this.out.print(" " + methode.getName());
    }

    @Override
    public void visite(ModeleJava modeleJava) {
        for (Class aClass : modeleJava.getaClasses()){
            aClass.accept(this);
        }
    }

    /*
     * méthodes privées
     */


}

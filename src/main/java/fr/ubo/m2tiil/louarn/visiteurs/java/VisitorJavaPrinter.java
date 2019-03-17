package fr.ubo.m2tiil.louarn.visiteurs.java;

import fr.ubo.m2tiil.louarn.modele.java.*;
import fr.ubo.m2tiil.louarn.visiteurs.commun.VisitorCommun;
import fr.ubo.m2tiil.louarn.visiteurs.commun.VisitorCommunPrinter;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Iterator;
import java.util.List;

public class VisitorJavaPrinter implements VisitorJava {

    /*
     * Attributs
     */
    private String pathCible;
    private PrintStream out;
    private VisitorCommun visitorCommun;

    /*
     * Constructeur
     */
    public VisitorJavaPrinter(String pathCible) {
        this.pathCible = pathCible;
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
        // affichage des mots clés
        this.out.print("\t");
        this.visite(attributeJava.getMotsCles());

        // affichage du type de l'attribut
        attributeJava.getType().accept(this.visitorCommun);
        this.out.print(" ");

        // fin de ligne
        this.out.print(attributeJava.getName());
        this.out.println(";");
    }

    @Override
    public void visite(MotsCles motsCles) {
        // afficahe du mote clé
        this.out.print(motsCles.getMotCle());
    }

    @Override
    public void visite(List<MotsCles> motsClesList) {
        // affichage des la liste des mots clé
        for (MotsCles motsCles : motsClesList) {
            motsCles.accept(this);
            this.out.print(" ");
        }
    }

    @Override
    public void visite(Clazz clazz) {
        // affiahce du package de la class
        out.println(MotsCles.PACKAGE.getMotCle() + " " + clazz.getApackage() + ";");

        //affiachage des dépendences de la class
        for (Dependance dependance : clazz.getDependances()) {
            dependance.accept(this);
        }

        // affafichage des mots clés de la class
        this.visite(clazz.getMotsCles());

        // affichage du nom de la class
        out.print(" " + clazz.getName());

        //affichage des types génériques
        if (!clazz.getGeneriqueClasses().isEmpty()) {
            out.println(" <");
            for (Iterator<String> iterator = clazz.getGeneriqueClasses().iterator();
                 iterator.hasNext(); ) {
                String generiqueClass = iterator.next();
                this.out.print(generiqueClass);
                if (iterator.hasNext()) {
                    this.out.print(", ");
                }
            }
            out.println("> ");
        }

        // affichage des entite hérité
        if (StringUtils.isNotBlank(clazz.getSupertype())) {
            out.print(" extends " + clazz.getSupertype());
        }

        out.println(" {");

        // affichage des attribut
        for (AttributeJava attributeJava : clazz.getAttributeJavas()) {
            attributeJava.accept(this);
        }

        // affiachage des constructeurs
        for (Constructeur constructeur : clazz.getConstructeurs()) {
            constructeur.accept(this);
        }

        // affichage des méthodes
        for (Methode methode : clazz.getAccesseurs()) {
            methode.accept(this);
        }

        out.println("}");
    }

    @Override
    public void visite(Constructeur constructeur) {
        // affiahceges des mots clé
        this.out.print("\t");
        this.visite(constructeur.getMotsCles());

        // affichage du nom du comstructeur
        this.out.print(" ");
        this.out.print(constructeur.getName());

        // affichages des l'argument
        this.out.print("(");
        for (Iterator<Argument> iterator = constructeur.getArguments().iterator(); iterator.hasNext(); ) {
            Argument argument = iterator.next();
            argument.accept(this);
            if (iterator.hasNext()) {
                this.out.print(", ");
            }
        }

        // affiahcage du block
        this.out.println(") {");
        constructeur.getBloc().accept(this);
        this.out.println("\t}");
    }

    @Override
    public void visite(Methode methode) {

        // affichage des mots clés
        this.out.print("\t");
        this.visite(methode.getMotsCles());

        // affichage du type de la methodes
        methode.getType().accept(this.visitorCommun);
        this.out.print(" " + methode.getName());

        // affichages des l'argument
        this.out.print("(");
        for (Iterator<Argument> iterator = methode.getArguments().iterator(); iterator.hasNext(); ) {
            Argument argument = iterator.next();
            argument.accept(this);
            if (iterator.hasNext()) {
                this.out.print(", ");
            }
        }

        // affiahcage du block
        this.out.println("){");
        methode.getBloc().accept(this);
        this.out.println("\t}");

    }

    @Override
    public void visite(Bloc bloc) {
        // affichage des ligne du block
        String lignes = "\t\t"+bloc.getLignes().toString();
        lignes = lignes.replaceAll(";",";\n\t\t");
        this.out.println(lignes);
    }

    @Override
    public void visite(Dependance dependance) {
        // affiachage des dependences
        if (StringUtils.isNotBlank(dependance.getPackageName())) {
            this.out.println("import " + dependance.getPackageName() + ";");
        }
    }

    @Override
    public void visite(ModeleJava modeleJava) {
        // pourcour des toutes les clases du modele
        for (Clazz clazz : modeleJava.getClazzes()){

            if (this.out != null) {
                this.out.close();
            }

            this.out = this.createPrintStream(clazz);

            // initialisation des visiteurs commun
            this.visitorCommun = new VisitorCommunPrinter(this.out);

            // affiahce de la classe
            clazz.accept(this);
        }

        if (this.out != null) {
            this.out.close();
        }
    }

    /*
     * méthodes privées
     */
    private PrintStream createPrintStream(Clazz clazz) {
        try {

            File f = new File(this.pathCible + "/" + clazz.getApackage() + "/" + clazz.getName() + ".java");
            File p = f.getParentFile();
            if (!p.exists()) {
                p.mkdirs();
            }


            OutputStream output = new FileOutputStream(f);
            PrintStream printStream = new PrintStream(output);
            return printStream;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

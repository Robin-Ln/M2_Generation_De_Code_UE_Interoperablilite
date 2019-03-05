package fr.ubo.m2tiil.louarn.visiteurs.java;

import fr.ubo.m2tiil.louarn.modele.dependance.Dependance;
import fr.ubo.m2tiil.louarn.modele.java.Class;
import fr.ubo.m2tiil.louarn.modele.java.*;
import fr.ubo.m2tiil.louarn.visiteurs.commun.VisitorCommun;
import fr.ubo.m2tiil.louarn.visiteurs.commun.VisitorCommunPrinter;
import fr.ubo.m2tiil.louarn.visiteurs.dependance.VisitorDependance;
import fr.ubo.m2tiil.louarn.visiteurs.dependance.VisitorDependancePrinter;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Iterator;

public class VisitorJavaPrinter implements VisitorJava {

    /*
     * Attributs
     */
    private String pathCible;
    private PrintStream out;
    private VisitorCommun visitorCommun;
    private VisitorDependance visitorDependance;

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
        this.out.print("\t");
        attributeJava.getVisibilite().accept(this);
        this.out.print(" ");
        attributeJava.getType().accept(this.visitorCommun);
        this.out.print(" ");
        this.out.print(attributeJava.getName());
        this.out.println(";");
    }

    @Override
    public void visite(Prototype prototype) {
        this.out.print(prototype.getPrototype());
    }

    @Override
    public void visite(Visibilite visibilite) {
        this.out.print(visibilite.getVisibilite());
    }

    @Override
    public void visite(Class aClass) {
        out.println("package " + aClass.getaPackage() + ";");

        for (Dependance dependance : aClass.getDependances()) {
            dependance.accept(this.visitorDependance);
        }

        aClass.getVisibilite().accept(this);

        out.print(" ");

        aClass.getPrototype().accept(this);

        out.print(" " + aClass.getName());

        if (!aClass.getGeneriqueClasses().isEmpty()) {
            out.println(" <");
            for (Iterator<String> iterator = aClass.getGeneriqueClasses().iterator();
                 iterator.hasNext(); ) {
                String generiqueClass = iterator.next();
                this.out.print(generiqueClass);
                if (iterator.hasNext()) {
                    this.out.print(", ");
                }
            }
            out.println("> ");
        }

        if (StringUtils.isNotBlank(aClass.getSupertype())) {
            out.print(" extends " + aClass.getSupertype());
        }

        out.println(" {");

        for (AttributeJava attributeJava : aClass.getAttributeJavas()) {
            attributeJava.accept(this);
        }

        for (Constructeur constructeur : aClass.getConstructeurs()) {
            constructeur.accept(this);
        }

        for (Methode methode : aClass.getMethodes()) {
            methode.accept(this);
        }

        out.println("}");
    }

    @Override
    public void visite(Constructeur constructeur) {
        this.out.print("\t");
        constructeur.getVisibilite().accept(this);
        this.out.print(" ");
        this.out.println(constructeur.getaClass().getName() + "() {\n\t\tsuper();\n\t}");
    }

    @Override
    public void visite(Methode methode) {
        this.out.print("\t");
        methode.getVisibilite().accept(this);
        this.out.print(" ");
        methode.getType().accept(this.visitorCommun);
        this.out.print(" " + methode.getName());
        this.out.print("(");
        for (Iterator<Argument> iterator = methode.getArguments().iterator(); iterator.hasNext(); ) {
            Argument argument = iterator.next();
            argument.accept(this);
            if (iterator.hasNext()) {
                this.out.print(", ");
            }
        }
        this.out.println("){");
        methode.getBloc().accept(this);
        this.out.println("\t}");

    }

    @Override
    public void visite(Bloc bloc) {
        String lignes = "\t\t"+bloc.getLignes().toString();
        lignes = lignes.replaceAll(";",";\n\t\t");
        this.out.println(lignes);
    }

    @Override
    public void visite(ModeleJava modeleJava) {
        for (Class aClass : modeleJava.getaClasses()){

            if (this.out != null) {
                this.out.close();
            }

            this.out = this.newOutFor(aClass.getName());

            this.visitorCommun = new VisitorCommunPrinter(this.out);
            this.visitorDependance = new VisitorDependancePrinter(this.out);

            aClass.accept(this);
        }

        if (this.out != null) {
            this.out.close();
        }
    }

    /*
     * méthodes privées
     */
    private PrintStream newOutFor(String nameClass) {
        try {

            File f = new File(this.pathCible + "/" + nameClass + ".java");
            File p = f.getParentFile();
            if (!p.exists()) {
                p.mkdirs();
            }


            OutputStream output = new FileOutputStream(this.pathCible + "/" + nameClass + ".java");
            PrintStream printStream = new PrintStream(output);
            return printStream;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

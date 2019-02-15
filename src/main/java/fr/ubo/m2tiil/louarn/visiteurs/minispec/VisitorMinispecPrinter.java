package fr.ubo.m2tiil.louarn.visiteurs.minispec;

import fr.ubo.m2tiil.louarn.modele.minispec.AttributeMinispec;
import fr.ubo.m2tiil.louarn.modele.minispec.Entity;
import fr.ubo.m2tiil.louarn.modele.minispec.ModeleMinispec;
import fr.ubo.m2tiil.louarn.visiteurs.commun.VisitorCommun;
import fr.ubo.m2tiil.louarn.visiteurs.commun.VisitorCommunPrinter;

import java.io.PrintStream;

public class VisitorMinispecPrinter implements VisitorMinispec {

    /*
     * Attributs
     */
    private PrintStream out;
    private VisitorCommun visitorCommun;

    /*
     * Constructeur
     */
    public VisitorMinispecPrinter(PrintStream out) {
        this.out = out;
        this.visitorCommun = new VisitorCommunPrinter(this.out);
    }

    /*
     * Merhode de l'interface Visotor
     */
    @Override
    public void visite(ModeleMinispec modeleMinispec) {
        for (Entity entity : modeleMinispec.getEntities()) {
            entity.accept(this);
        }
    }

    @Override
    public void visite(Entity entity) {
        out.print("public class " + entity.getName());
        if (entity.getSuperType() != null && !entity.getSuperType().equals("")) {
            out.print(" extends " + entity.getSuperType());
        }
        out.println(" {");
        for (AttributeMinispec attributeMinispec : entity.getAttributeMinispecs()) {
            attributeMinispec.accept(this);
        }
        out.println("\tpublic " + entity.getName() + "() {}");
        this.printAccesseurs(entity);
        out.println("}");
    }

    @Override
    public void visite(AttributeMinispec attributeMinispec) {
        out.print("\t");
        attributeMinispec.getType().accept(this.visitorCommun);
        out.println(" " + attributeMinispec.getName() + ";");
    }

    private void printAccesseurs(Entity entity) {
        for (AttributeMinispec attributeMinispec : entity.getAttributeMinispecs()) {
            Integer nameSize = attributeMinispec.getName().length();
            String name = attributeMinispec.getName().substring(0, 1).toUpperCase()
                    + attributeMinispec.getName().substring(1, nameSize);
            
            out.print("\tpublic ");
            attributeMinispec.getType().accept(this.visitorCommun);
            out.println(" get" + name + "() {");
            out.println("\t\treturn this." + attributeMinispec.getName() + ";");
            out.println("\t}");

            out.print("\tpublic void set" + name + "(");
            attributeMinispec.getType().accept(this.visitorCommun);
            out.println(" " + attributeMinispec.getName() + ") {");
            out.println("\t\tthis." + attributeMinispec.getName() + " = " + attributeMinispec.getName() + ";");
            out.println("\t}");
        }

    }

}

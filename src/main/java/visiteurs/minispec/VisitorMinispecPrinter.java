package visiteurs.minispec;

import meta.modele.commun.Array;
import meta.modele.commun.Collection;
import meta.modele.commun.TypeElement;
import meta.modele.minispec.*;

import java.io.PrintStream;

public class VisitorMinispecPrinter implements VisitorMinispec {

    /*
     * Attributs
     */
    private PrintStream out;

    /*
     * Constructeur
     */
    public VisitorMinispecPrinter(PrintStream out) {
        this.out = out;
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
        if (entity.getSubtype() != null && !entity.getSubtype().equals("")) {
            out.print(" extends " + entity.getSubtype());
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
        attributeMinispec.getType().accept(this);
        out.println(" " + attributeMinispec.getName() + ";");
    }

    @Override
    public void visite(Collection collection) {
        out.print(collection.getTypeCollection());
        out.print("<");
        collection.getType().accept(this);
        out.print(">");
        if (collection.getMin() != null && collection.getMax() != null)
        out.print("/* min : "+collection.getMin()+", max : "+collection.getMax()+"*/");
    }

    @Override
    public void visite(TypeElement typeElement) {
        out.print(typeElement.getType());
    }

    @Override
    public void visite(Array array) {
        array.getType().accept(this);
        out.print("["+array.getSize()+"]");
    }

    private void printAccesseurs(Entity entity) {
        for (AttributeMinispec attributeMinispec : entity.getAttributeMinispecs()) {
            Integer nameSize = attributeMinispec.getName().length();
            String name = attributeMinispec.getName().substring(0, 1).toUpperCase()
                    + attributeMinispec.getName().substring(1, nameSize);
            
            out.print("\tpublic ");
            attributeMinispec.getType().accept(this);
            out.println(" get" + name + "() {");
            out.println("\t\treturn this." + attributeMinispec.getName() + ";");
            out.println("\t}");

            out.print("\tpublic void set" + name + "(");
            attributeMinispec.getType().accept(this);
            out.println(" " + attributeMinispec.getName() + ") {");
            out.println("\t\tthis." + attributeMinispec.getName() + " = " + attributeMinispec.getName() + ";");
            out.println("\t}");
        }

    }

}

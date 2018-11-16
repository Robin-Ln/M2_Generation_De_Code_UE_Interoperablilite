package visiteurs;

import java.io.PrintStream;

import meta.modele.*;

public class VisitorPrinter implements Visitor {

    /*
     * Attributs
     */
    private PrintStream out;

    /*
     * Constructeur
     */
    public VisitorPrinter(PrintStream out) {
        this.out = out;
    }

    /*
     * Merhode de l'interface Visotor
     */
    @Override
    public void visite(Modele modele) {
        for (Entity entity : modele.getEntities()) {
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
        for (Attribute attribute : entity.getAttributes()) {
            attribute.accept(this);
        }
        out.println("\tpublic " + entity.getName() + "() {}");
        this.printAccesseurs(entity);
        out.println("}");
    }

    @Override
    public void visite(Attribute attribute) {
        out.print("\t");
        attribute.getType().accept(this);
        out.println(" " + attribute.getName() + ";");
    }

    @Override
    public void visite(Collection collection) {
        out.print("\t");
        collection.getType().accept(this);
        out.print("<");
        collection.getType().accept(this);
        out.println(">");
    }

    @Override
    public void visite(TypeElement typeElement) {
        out.print(typeElement.getType());
    }

    @Override
    public void visite(Array array) {
        out.println("\t");
        array.getType().accept(this);
        out.print("[]");
    }

    private void printAccesseurs(Entity entity) {
        for (Attribute attribute : entity.getAttributes()) {
            Integer nameSize = attribute.getName().length();
            String name = attribute.getName().substring(0, 1).toUpperCase()
                    + attribute.getName().substring(1, nameSize);
            out.println("\tpublic ");
            attribute.getType().accept(this);
            out.print(" get" + name + "() {");
            out.println("\t\treturn this." + attribute.getName() + ";");
            out.println("\t}");

            out.println("\tpublic void set" + name + "(");
            attribute.getType().accept(this);
            out.print(" " + attribute.getName() + ") {");
            out.println("\t\tthis." + attribute.getName() + " = " + attribute.getName() + ";");
            out.println("\t}");
        }

    }

}

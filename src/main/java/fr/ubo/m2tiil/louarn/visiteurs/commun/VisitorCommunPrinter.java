package fr.ubo.m2tiil.louarn.visiteurs.commun;

import fr.ubo.m2tiil.louarn.modele.commun.Array;
import fr.ubo.m2tiil.louarn.modele.commun.Collection;
import fr.ubo.m2tiil.louarn.modele.commun.TypeElement;

import java.io.PrintStream;

public class VisitorCommunPrinter implements VisitorCommun {
    /*
     * Attributs
     */
    private PrintStream out;

    /*
     * Constructeur
     */
    public VisitorCommunPrinter(PrintStream out) {
        this.out = out;
    }

    /*
     * Merhode de l'interface Visotor
     */
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
}

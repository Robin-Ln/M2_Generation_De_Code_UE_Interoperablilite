package fr.ubo.m2tiil.louarn.visiteurs.dependance;

import fr.ubo.m2tiil.louarn.modele.dependance.Primitive;
import fr.ubo.m2tiil.louarn.modele.dependance.ReferenceModele;

import java.io.PrintStream;

public class VisitorDependancePrinter implements VisitorDependance {

    /*
     * Attributs
     */
    private PrintStream out;

    /*
     * Constructeur
     */
    public VisitorDependancePrinter(PrintStream out) {
        this.out = out;
    }

    /*
     * Merhode de l'interface Visotor
     */

    @Override
    public void visite(Primitive primitive) {
        if (primitive.getPackageName() == null || primitive.getPackageName().equals("")) {
            return;
        }

        this.out.println("import " + primitive.getPackageName() + ";");
    }

    @Override
    public void visite(ReferenceModele referenceModele) {
        if (referenceModele.getPackageName() == null || referenceModele.getPackageName().equals("")) {
            return;
        }

        this.out.println("import " + referenceModele.getPackageName());
    }
}

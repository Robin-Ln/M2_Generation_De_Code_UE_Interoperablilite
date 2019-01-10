package meta.modele.java;

import visiteurs.javacode.VisitableJava;
import visiteurs.javacode.VisitorJava;

import java.util.List;

public class ModeleJava implements VisitableJava {
    /*
     * Attributs
     */
    List<Class> classes;

    /*
     * Constructeurs
     */

    /*
     * Methodes
     */

    @Override
    public void accept(VisitorJava visitorJava) {
        visitorJava.visite(this);
    }

    /*
     * Accesseurs
     */
}

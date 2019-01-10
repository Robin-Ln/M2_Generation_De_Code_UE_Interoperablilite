package meta.modele.java;

import meta.modele.commun.Type;
import visiteurs.javacode.VisitableJava;
import visiteurs.javacode.VisitorJava;

public class Argument implements VisitableJava {
    /*
     * Attributs
     */

    private Type type;
    private String name;


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

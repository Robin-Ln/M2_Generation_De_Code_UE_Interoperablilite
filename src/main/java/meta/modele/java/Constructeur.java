package meta.modele.java;

import visiteurs.javacode.VisitableJava;
import visiteurs.javacode.VisitorJava;

public class Constructeur implements VisitableJava {
    /*
     * Attributs
     */
    private String visibilite;
    private Class Class;


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

package meta.modele.java;

import meta.modele.commun.Type;
import visiteurs.javacode.VisitableJava;
import visiteurs.javacode.VisitorJava;

public class AttributeJava implements VisitableJava {
    /*
     * Attributs
     */
    private String visibilite;
    private String name;
    private Type type;


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

package meta.modele.java;

import meta.modele.minispec.AttributeMinispec;
import visiteurs.javacode.VisitableJava;
import visiteurs.javacode.VisitorJava;

import java.util.List;

public class Class implements VisitableJava {

    /*
     * Attributs
     */
    private String name;
    private String subtype;
    private List<AttributeMinispec> attributeMinispecs;

    /*
     * Constructeur
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

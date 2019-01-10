package meta.modele.java;

import meta.modele.commun.Type;
import visiteurs.javacode.VisitableJava;
import visiteurs.javacode.VisitorJava;

import java.util.List;

public class Methode implements VisitableJava {

    /*
     * Attributs
     */

    private String visibiliter;
    private String name;
    private Type type;
    private List<Argument> arguments;
    private Boolean staticMethode;
    private Boolean abstractMethode;


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

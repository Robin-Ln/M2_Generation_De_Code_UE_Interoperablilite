package visiteurs;

import meta.modele.generateClass.*;

import java.util.ArrayList;
import java.util.List;

public class VisitorDependencies implements Visitor {

    /*
     * Attributs
     */


    /*
     * Constructeur
     */
    public VisitorDependencies() {
        super();
    }

    /*
     * Merhode de l'interface Visitor
     */

    @Override
    public void visite(Modele modele) {

    }

    @Override
    public void visite(Entity entity) {

    }

    @Override
    public void visite(Attribute attribute) {

    }

    @Override
    public void visite(Array array) {

    }

    @Override
    public void visite(Collection collection) {

    }

    @Override
    public void visite(TypeElement typeElement) {

    }
}

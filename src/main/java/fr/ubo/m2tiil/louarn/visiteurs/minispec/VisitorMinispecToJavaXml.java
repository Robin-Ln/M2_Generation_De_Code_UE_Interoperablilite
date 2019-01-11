package fr.ubo.m2tiil.louarn.visiteurs.minispec;

import fr.ubo.m2tiil.louarn.modele.commun.Array;
import fr.ubo.m2tiil.louarn.modele.commun.Collection;
import fr.ubo.m2tiil.louarn.modele.commun.TypeElement;
import fr.ubo.m2tiil.louarn.modele.minispec.AttributeMinispec;
import fr.ubo.m2tiil.louarn.modele.minispec.Entity;
import fr.ubo.m2tiil.louarn.modele.minispec.ModeleMinispec;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class VisitorMinispecToJavaXml implements VisitorMinispec {

    /*
     * Attributs
     */
    private Document document;




    private Element elementArray;
    private Element elementCollection;
    private Element elementTypeElement;


    /*
     * Constructeurs
     */


    /*
     * Métodes du visiteur
     */

    @Override
    public void visite(ModeleMinispec modeleMinispec) {

    }

    @Override
    public void visite(Entity entity) {

    }

    @Override
    public void visite(AttributeMinispec attributeMinispec) {

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

    /*
     * Métodes
     */
}

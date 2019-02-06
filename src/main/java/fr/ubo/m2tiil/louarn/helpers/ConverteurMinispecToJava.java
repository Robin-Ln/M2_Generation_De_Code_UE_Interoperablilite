package fr.ubo.m2tiil.louarn.helpers;

import fr.ubo.m2tiil.louarn.modele.commun.Array;
import fr.ubo.m2tiil.louarn.modele.commun.Collection;
import fr.ubo.m2tiil.louarn.modele.commun.TypeElement;
import fr.ubo.m2tiil.louarn.modele.java.*;
import fr.ubo.m2tiil.louarn.modele.java.Class;
import fr.ubo.m2tiil.louarn.modele.minispec.AttributeMinispec;
import fr.ubo.m2tiil.louarn.modele.minispec.Entity;
import fr.ubo.m2tiil.louarn.modele.minispec.ModeleMinispec;
import fr.ubo.m2tiil.louarn.visiteurs.minispec.VisitorMinispec;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class ConverteurMinispecToJava {

    /*
     * Attributs
     */
    private ModeleMinispec modeleMinispec;
    private ModeleJava modeleJava;



    /*
     * Constructeurs
     */

    public ConverteurMinispecToJava(ModeleMinispec modeleMinispec) {
        this.modeleMinispec = modeleMinispec;
    }

    /*
     * Métodes de concertions
     */
    Class getClass(Entity entity){
        Class aClass = new Class();
        aClass.setName(entity.getName());
        aClass.setSubtype(entity.getSubtype());
        aClass.setAttributeJavas(this.getAttributeJavas(entity));
        aClass.setConstructeurs(this.getConstructeurs(aClass));
        aClass.setMethodes(this.getMethodes(entity));
        return aClass;
    }

    List<Constructeur> getConstructeurs(Class aClass){
        List<Constructeur> constructeurs = new ArrayList<>();
        Constructeur constructeur = new Constructeur();
        constructeur.setaClass(aClass);
        constructeur.setVisibilite(Visibilite.PUBLIC);
        constructeurs.add(constructeur);
        return constructeurs;
    }

    List<AttributeJava> getAttributeJavas(Entity entity){
        return null;
    }

    List<Methode> getMethodes(Entity entity){
        return null;
    }


    /*
     * Métodes
     */
}

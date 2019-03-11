package fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.repository;

import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance.AbstractInstance;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public abstract class AbstractRepository<Instance extends AbstractInstance> {

    /**
     * TODO
     * ilfaut ajouter une map id instance
     * pour ne pas recreer deux foit la meme instance et eviter un bouclage infinie
     * ex : un objet A refaire une liste d'objet b
     * objet b à une instance d'objet a
     */


    /**
     * Methodes abstraite
     */

    abstract public Instance lire(Element element, Document document);

    abstract public Element ecrire(Instance instance, Document document);


}

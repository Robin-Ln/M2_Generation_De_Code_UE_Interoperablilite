package fr.ubo.m2tiil.louarn.minispecEnMinispec.repository;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public abstract class AbstractRepository<Instance extends AbstractInstance> {


    /**
     * Methodes abstraite
     */

    abstract public Instance lire(Element element);

    abstract public Element ecrire(Instance instance, Document document);


}

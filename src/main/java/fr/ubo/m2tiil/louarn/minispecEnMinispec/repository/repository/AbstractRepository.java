package fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.repository;

import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance.AbstractInstance;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public abstract class AbstractRepository<Instance extends AbstractInstance> {


    /**
     * Methodes abstraite
     */

    abstract public Instance lire(Element element, Document document);

    abstract public Element ecrire(Instance instance, Document document);


}

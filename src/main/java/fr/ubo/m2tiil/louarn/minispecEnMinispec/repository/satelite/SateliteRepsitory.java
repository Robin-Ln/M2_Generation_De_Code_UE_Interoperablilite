package fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.satelite;

import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.AbstractRepesitory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SateliteRepsitory extends AbstractRepesitory<SateliteInstance> {

    @Override
    public SateliteInstance lire(Element element) {
        SateliteInstance instance = new SateliteInstance();
        instance.setId(element.getAttribute("id"));
        instance.setId(element.getAttribute("nom"));
        instance.setId(element.getAttribute("idParent"));
        return instance;
    }

    @Override
    public Element ecrire(SateliteInstance instance, Document document) {
        Element element = document.createElement("Satelite");
        element.setAttribute("id", instance.getId());
        element.setAttribute("nom", instance.getNom());
        element.setAttribute("idParent", instance.getIdParent());
        return element;
    }
}

package fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.visiteurs;

import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.repository.FlotteInstanceRepository;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.repository.SateliteInstanceRepository;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance.FlotteInstance;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance.SateliteInstance;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class VisiteurInstanceEcrire implements VisiteurInstance {

    private Document document;

    public VisiteurInstanceEcrire(Document document) {
        this.document = document;
    }

    @Override
    public void visite(FlotteInstance instance) {
        FlotteInstanceRepository repository = new FlotteInstanceRepository();
        Element element = repository.ecrire(instance, this.document);
        this.document.getDocumentElement().appendChild(element);

    }

    @Override
    public void visite(SateliteInstance instance) {
        SateliteInstanceRepository repository = new SateliteInstanceRepository();
        Element element = repository.ecrire(instance, this.document);
        this.document.getDocumentElement().appendChild(element);
    }

}

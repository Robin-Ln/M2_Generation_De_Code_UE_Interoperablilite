package fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.visiteurs;

import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.impl.FlotteInstanceRepository;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.impl.SateliteInstanceRepository;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance.FlotteInstance;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance.SateliteInstance;
import org.w3c.dom.Document;


public class VisiteurInstanceEcrire implements VisiteurInstance {

    private Document document;

    public VisiteurInstanceEcrire(Document document) {
        this.document = document;
    }

    @Override
    public void visite(FlotteInstance instance) {
        FlotteInstanceRepository repository = new FlotteInstanceRepository();
        repository.ecrire(instance, this.document);
    }

    @Override
    public void visite(SateliteInstance instance) {
        SateliteInstanceRepository repository = new SateliteInstanceRepository();
        repository.ecrire(instance, this.document);
    }

}

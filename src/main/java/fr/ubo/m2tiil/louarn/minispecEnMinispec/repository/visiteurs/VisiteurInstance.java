package fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.visiteurs;

import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance.FlotteInstance;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance.SateliteInstance;

public interface VisiteurInstance {

    void visite(FlotteInstance flotteInstance);

    void visite(SateliteInstance sateliteInstance);
}

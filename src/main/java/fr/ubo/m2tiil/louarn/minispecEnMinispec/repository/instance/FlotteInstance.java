package fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance;

import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.visiteurs.VisiteurInstance;

import java.util.List;

public class FlotteInstance extends AbstractInstance {
	public List<SateliteInstance> satelites;

	@Override
	public void accept(VisiteurInstance visiteurInstance) {
		visiteurInstance.visite(this);
	}
}

package fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance;

import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.visiteurs.VisiteurInstance;

public class SateliteInstance extends AbstractInstance {
	public String nom;
	public FlotteInstance parent;

	@Override
	public void accept(VisiteurInstance visiteurInstance) {
		visiteurInstance.visite(this);
	}
}

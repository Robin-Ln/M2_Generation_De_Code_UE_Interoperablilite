package fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.AbstractInstance;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.visiteurs.VisiteurInstance;

public class SateliteInstance extends AbstractInstance {
	public String nom;
	public String parent;

	@Override
	public void accept(VisiteurInstance visiteurInstance) {
		visiteurInstance.visite(this);
	}
}

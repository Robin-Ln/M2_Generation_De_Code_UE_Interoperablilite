package fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.AbstractInstance;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.visiteurs.VisiteurInstance;

public class FlotteInstance extends AbstractInstance {
	public String satelites;

	@Override
	public void accept(VisiteurInstance visiteurInstance) {
		visiteurInstance.visite(this);
	}
}

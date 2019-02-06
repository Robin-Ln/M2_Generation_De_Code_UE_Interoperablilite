package fr.ubo.m2tiil.louarn.visiteurs.minispec;

import fr.ubo.m2tiil.louarn.modele.minispec.AttributeMinispec;
import fr.ubo.m2tiil.louarn.modele.minispec.Entity;
import fr.ubo.m2tiil.louarn.modele.minispec.ModeleMinispec;

public interface VisitorMinispec {

	void visite(ModeleMinispec modeleMinispec);

	void visite(Entity entity);

	void visite(AttributeMinispec attributeMinispec);

}

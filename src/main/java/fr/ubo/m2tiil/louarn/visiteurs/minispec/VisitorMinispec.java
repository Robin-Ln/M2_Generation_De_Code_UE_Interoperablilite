package fr.ubo.m2tiil.louarn.visiteurs.minispec;

import fr.ubo.m2tiil.louarn.modele.commun.Array;
import fr.ubo.m2tiil.louarn.modele.commun.Collection;
import fr.ubo.m2tiil.louarn.modele.commun.TypeElement;
import fr.ubo.m2tiil.louarn.modele.minispec.*;

public interface VisitorMinispec {

	void visite(ModeleMinispec modeleMinispec);

	void visite(Entity entity);

	void visite(AttributeMinispec attributeMinispec);

	void visite(Array array);

	void visite(Collection collection);

	void visite(TypeElement typeElement);

}

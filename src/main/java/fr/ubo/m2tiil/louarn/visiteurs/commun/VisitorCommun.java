package fr.ubo.m2tiil.louarn.visiteurs.commun;

import fr.ubo.m2tiil.louarn.modele.commun.Array;
import fr.ubo.m2tiil.louarn.modele.commun.Collection;
import fr.ubo.m2tiil.louarn.modele.commun.TypeElement;

public interface VisitorCommun {
	
	void visite(Array array);

	void visite(Collection collection);

	void visite(TypeElement typeElement);
}

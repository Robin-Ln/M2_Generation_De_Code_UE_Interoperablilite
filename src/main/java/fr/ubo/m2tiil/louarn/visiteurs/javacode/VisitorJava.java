package fr.ubo.m2tiil.louarn.visiteurs.javacode;

import fr.ubo.m2tiil.louarn.modele.commun.Array;
import fr.ubo.m2tiil.louarn.modele.commun.Collection;
import fr.ubo.m2tiil.louarn.modele.commun.TypeElement;
import fr.ubo.m2tiil.louarn.modele.java.*;
import fr.ubo.m2tiil.louarn.modele.java.Class;

public interface VisitorJava {
	
	void visite(Array array);

	void visite(Collection collection);

	void visite(TypeElement typeElement);

	void visite(Argument argument);

	void visite(AttributeJava attributeJava);

	void visite(Class Class);

	void visite(Constructeur constructeur);

	void visite(Methode methode);

	void visite(ModeleJava modeleJava);
}

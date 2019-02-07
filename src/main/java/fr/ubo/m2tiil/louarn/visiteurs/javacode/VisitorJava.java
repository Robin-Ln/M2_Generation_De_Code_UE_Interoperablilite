package fr.ubo.m2tiil.louarn.visiteurs.javacode;

import fr.ubo.m2tiil.louarn.modele.java.Class;
import fr.ubo.m2tiil.louarn.modele.java.*;

public interface VisitorJava {

	void visite(Argument argument);

	void visite(AttributeJava attributeJava);

	void visite(Class Class);

	void visite(Constructeur constructeur);

	void visite(Methode methode);

	void visite(ModeleJava modeleJava);

	void visite(Visibilite visibilite);

	void visite(Bloc bloc);
}

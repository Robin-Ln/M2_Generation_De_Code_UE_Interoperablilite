package fr.ubo.m2tiil.louarn.visiteurs.java;

import fr.ubo.m2tiil.louarn.modele.java.Clazz;
import fr.ubo.m2tiil.louarn.modele.java.*;

import java.util.List;

public interface VisitorJava {

	void visite(Argument argument);

	void visite(AttributeJava attributeJava);

	void visite(Clazz Clazz);

	void visite(Constructeur constructeur);

	void visite(Methode methode);

	void visite(ModeleJava modeleJava);

	void visite(Bloc bloc);

	void visite(MotsCles motsCles);

	void visite(List<MotsCles> motsCles);

	void accept(Dependance dependance);
}

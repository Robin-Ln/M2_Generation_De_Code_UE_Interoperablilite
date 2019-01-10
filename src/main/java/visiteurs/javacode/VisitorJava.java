package visiteurs.javacode;

import meta.modele.commun.Array;
import meta.modele.commun.Collection;
import meta.modele.commun.TypeElement;
import meta.modele.java.*;
import meta.modele.java.Class;

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

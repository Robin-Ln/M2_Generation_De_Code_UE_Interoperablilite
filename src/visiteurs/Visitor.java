package visiteurs;

import meta.modele.generateClass.Array;
import meta.modele.generateClass.Attribute;
import meta.modele.generateClass.Collection;
import meta.modele.generateClass.Entity;
import meta.modele.generateClass.Modele;
import meta.modele.generateClass.TypeElement;

public interface Visitor {

	void visite(Modele modele);

	void visite(Entity entity);

	void visite(Attribute attribute);

	void visite(Array array);

	void visite(Collection associationMultiple);

	void visite(TypeElement object);

}

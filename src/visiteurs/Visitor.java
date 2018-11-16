package visiteurs;

import meta.modele.Array;
import meta.modele.Attribute;
import meta.modele.Collection;
import meta.modele.Entity;
import meta.modele.Modele;
import meta.modele.TypeElement;

public interface Visitor {

	void visite(Modele modele);

	void visite(Entity entity);

	void visite(Attribute attribute);

	void visite(Array array);

	void visite(Collection associationMultiple);

	void visite(TypeElement object);

}

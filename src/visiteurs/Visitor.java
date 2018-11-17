package visiteurs;

import meta.modele.generateClass.*;

public interface Visitor {

	void visite(Modele modele);

	void visite(Entity entity);

	void visite(Attribute attribute);

	void visite(Array array);

	void visite(Collection collection);

	void visite(TypeElement typeElement);

}

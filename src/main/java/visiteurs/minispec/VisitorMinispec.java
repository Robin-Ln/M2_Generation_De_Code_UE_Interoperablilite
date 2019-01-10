package visiteurs.minispec;

import meta.modele.commun.Array;
import meta.modele.commun.Collection;
import meta.modele.commun.TypeElement;
import meta.modele.minispec.*;

public interface VisitorMinispec {

	void visite(ModeleMinispec modeleMinispec);

	void visite(Entity entity);

	void visite(AttributeMinispec attributeMinispec);

	void visite(Array array);

	void visite(Collection collection);

	void visite(TypeElement typeElement);

}

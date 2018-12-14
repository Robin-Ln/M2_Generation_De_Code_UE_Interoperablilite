package meta.modele.minispec;

import java.util.ArrayList;
import java.util.List;

import visiteurs.minispec.VisitableMinispec;
import visiteurs.minispec.VisitorMinispec;

public class ModeleMinispec implements VisitableMinispec {

    /*
     * Attributs
     */
    private List<Entity> entities;

    /*
     * Constructeur
     */
    public ModeleMinispec() {
        super();
        this.entities = new ArrayList<>();
    }

    /*
     * Methodes
     */
    @Override
    public void accept(VisitorMinispec visitorMinispec) {
        visitorMinispec.visite(this);
    }

    /*
     * Accesseurs
     */
    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }
}

package meta.modele;

import java.util.ArrayList;
import java.util.List;

import visiteurs.Visitable;
import visiteurs.Visitor;

public class Modele implements Visitable {

    /*
     * Attributs
     */
    private List<Entity> entities;

    /*
     * Constructeur
     */
    public Modele() {
        super();
        this.entities = new ArrayList<>();
    }

    /*
     * Methodes
     */
    @Override
    public void accept(Visitor visiteur) {
        visiteur.visite(this);
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

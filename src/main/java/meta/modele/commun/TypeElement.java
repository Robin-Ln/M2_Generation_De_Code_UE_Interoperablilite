package meta.modele.commun;

import visiteurs.javacode.VisitorJava;
import visiteurs.minispec.VisitorMinispec;

public class TypeElement implements Type {

    /*
     * Attributs
     */
    private String type;


    /*
     * Constructeurs
     */
    public TypeElement() {
        super();
    }

    /*
     * Methodes
     */
    @Override
    public void accept(VisitorMinispec visitorMinispec) {
        visitorMinispec.visite(this);
    }

    @Override
    public void accept(VisitorJava visitorJava) {
        visitorJava.visite(this);
    }

    /*
     * Accesseurs
     */
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

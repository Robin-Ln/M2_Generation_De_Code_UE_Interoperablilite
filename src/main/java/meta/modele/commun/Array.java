package meta.modele.commun;

import visiteurs.javacode.VisitorJava;
import visiteurs.minispec.VisitorMinispec;

public class Array implements Type {

    /*
     * Attributs
     */
    private Integer size;
    private Type type;

    /*
     * Constructeurs
     */
    public Array() {
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
    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}

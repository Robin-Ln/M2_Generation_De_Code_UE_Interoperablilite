package meta.modele;

import java.lang.reflect.Type;

import visiteurs.Visitor;

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
    public void accept(Visitor visiteur) {
        visiteur.visite(this);
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

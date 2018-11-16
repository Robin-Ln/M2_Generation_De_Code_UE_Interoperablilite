package meta.modele;

import visiteurs.Visitable;
import visiteurs.Visitor;

import java.util.Objects;

public class Attribute implements Visitable {

    /*
     * Attributs
     */
    private String name;
    private Type type;

    /*
     * Constructeur
     */
    public Attribute() {
        super();
    }

    /*
     * Methodes
     */
    @Override
    public void accept(Visitor visiteur) {
        visiteur.visite(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attribute attribute = (Attribute) o;
        return Objects.equals(name, attribute.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /*
     * Accesseurs
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}

package fr.ubo.m2tiil.louarn.modele.minispec;

import fr.ubo.m2tiil.louarn.modele.commun.Type;
import fr.ubo.m2tiil.louarn.visiteurs.minispec.VisitableMinispec;
import fr.ubo.m2tiil.louarn.visiteurs.minispec.VisitorMinispec;

import java.util.Objects;

public class AttributeMinispec implements VisitableMinispec {

    /*
     * Attributs
     */
    private String name;
    private Type type;

    /*
     * Constructeur
     */
    public AttributeMinispec() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttributeMinispec attributeMinispec = (AttributeMinispec) o;
        return Objects.equals(name, attributeMinispec.name);
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

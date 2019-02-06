package fr.ubo.m2tiil.louarn.visiteurs.minispec;

import fr.ubo.m2tiil.louarn.modele.commun.Array;
import fr.ubo.m2tiil.louarn.modele.commun.Collection;
import fr.ubo.m2tiil.louarn.modele.commun.TypeElement;
import fr.ubo.m2tiil.louarn.modele.minispec.*;

import java.util.ArrayList;
import java.util.List;

public class VisitorMinispecCheckHeritage implements VisitorMinispec {

    /*
     * Attributs
     */
    private List<Exception> exceptions;
    private ModeleMinispec modeleMinispec;

    /*
     * Constructeur
     */
    public VisitorMinispecCheckHeritage() {
        super();
        this.exceptions = new ArrayList<>();
    }

    /*
     * Merhode de l'interface VisitorJava
     */
    @Override
    public void visite(ModeleMinispec modeleMinispec) {
        this.modeleMinispec = modeleMinispec;

        for (Entity entity : this.modeleMinispec.getEntities()) {
            entity.accept(this);
        }
    }

    @Override
    public void visite(Entity entity) {
        String subtype = entity.getSubtype();
        if (subtype == null || subtype.equals("")) {
            return;
        }

        Entity entityParent = this.getEmptity(subtype);
        if (entityParent == null) {
            this.exceptions.add(new ClassNotFoundException(subtype));
            return;
        }

        /*
         * Héritage en boucle
         */
        if (entity.getName().equals(entityParent.getSubtype())) {
            this.exceptions.add(new Exception("Hritage en boucle : " + subtype));
            return;
        }

        /*
         * Varraible dipliquée ?
         */
        for (AttributeMinispec attributeMinispec : entity.getAttributeMinispecs()) {
            if (entityParent.getAttributeMinispecs().contains(attributeMinispec)) {
                this.exceptions.add(new Exception("Duplicate name Varrable : " + attributeMinispec.getName()));
            }
        }
    }

    @Override
    public void visite(AttributeMinispec attributeMinispec) {// initile
    }

    /*
     * Methoded
     */

    private Entity getEmptity(String nameEmptity) {
        for (Entity entity : this.modeleMinispec.getEntities()) {
            if (entity.getName().equals(nameEmptity)) {
                return entity;
            }
        }
        return null;
    }

    public Boolean isValide() {
        return this.exceptions.isEmpty();
    }

    /*
     * Accesseurs
     */
    public List<Exception> getExceptions() {
        return exceptions;
    }

    public void setExceptions(List<Exception> exceptions) {
        this.exceptions = exceptions;
    }

}

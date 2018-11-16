package visiteurs;

import java.util.ArrayList;
import java.util.List;

import meta.modele.*;

public class VisitorCheckHeritage implements Visitor {

    /*
     * Attributs
     */
    private List<Exception> exceptions;
    private Modele modele;

    /*
     * Constructeur
     */
    public VisitorCheckHeritage() {
        super();
        this.exceptions = new ArrayList<>();
    }

    /*
     * Merhode de l'interface Visitor
     */
    @Override
    public void visite(Modele modele) {
        this.modele = modele;

        for (Entity entity : this.modele.getEntities()) {
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
        for (Attribute attribute : entity.getAttributes()) {
            if (entityParent.getAttributes().contains(attribute)) {
                this.exceptions.add(new Exception("Duplicate name Varrable : " + attribute.getName()));
            }
        }
    }

    @Override
    public void visite(Attribute attribute) {// initile
    }

    @Override
    public void visite(Array array) {// initile
    }

    @Override
    public void visite(Collection associationMultiple) {// inutile
    }

    @Override
    public void visite(TypeElement object) {// inutile
    }

    /*
     * Methoded
     */

    private Entity getEmptity(String nameEmptity) {
        for (Entity entity : this.modele.getEntities()) {
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

package meta.modele.generateClass;

import visiteurs.Visitor;

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
    public void accept(Visitor visiteur) {
        visiteur.visite(this);
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

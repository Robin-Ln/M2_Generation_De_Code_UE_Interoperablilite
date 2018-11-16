package meta.modele;

import visiteurs.Visitor;

public class Collection implements Type {

    /*
     * Attributs
     */
    private Type type;
    private Integer min;
    private Integer max;

    /*
     * Constructeurs
     */
    public Collection() {
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
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

}

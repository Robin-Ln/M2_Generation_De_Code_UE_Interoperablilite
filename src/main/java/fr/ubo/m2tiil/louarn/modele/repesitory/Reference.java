package fr.ubo.m2tiil.louarn.modele.repesitory;

public class Reference {
    /*
     * Attributs
     */

    Integer id;

    /*
     * Constructeurs
     */

    public Reference() {
        super();
    }

    public Reference(Integer id) {
        super();
        this.id = id;
    }

    /*
     * Accesseurs
     */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

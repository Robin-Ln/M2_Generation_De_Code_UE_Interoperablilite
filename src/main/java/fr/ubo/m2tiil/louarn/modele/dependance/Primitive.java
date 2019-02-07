package fr.ubo.m2tiil.louarn.modele.dependance;

public class Primitive extends Dependance {
    /*
     * Attributte
     */
    private String type;

    /*
     * Constructeur
     */
    public Primitive() {
        super();
    }

    /*
     * Accesseurs
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

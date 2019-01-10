package meta.modele.minispec.generatePackage;

public class Primitive extends Dependence {
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

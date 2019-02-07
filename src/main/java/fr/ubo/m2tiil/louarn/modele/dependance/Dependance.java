package fr.ubo.m2tiil.louarn.modele.dependance;

public abstract class Dependance {

    /*
     * Attributte
     */
    private String name;
    private String packageName;

    /*
     * Constructeur
     */

    public Dependance() {
        super();
    }

    /*
     * Accesseurs
     */

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

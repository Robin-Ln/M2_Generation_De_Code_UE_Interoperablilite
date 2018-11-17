package meta.modele.generatePackage;

public abstract class Dependence {

    /*
     * Attributte
     */
    private String name;
    private String packageName;

    /*
     * Constructeur
     */

    public Dependence() {
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

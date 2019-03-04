package fr.ubo.m2tiil.louarn.modele.repesitory;

import fr.ubo.m2tiil.louarn.modele.commun.TypeElement;
import fr.ubo.m2tiil.louarn.modele.java.AttributeJava;
import fr.ubo.m2tiil.louarn.modele.java.Class;
import fr.ubo.m2tiil.louarn.modele.java.ModeleJava;
import fr.ubo.m2tiil.louarn.modele.java.Visibilite;

public class GenerateRepesitoryFor {
    /*
     * Attributs
     */
    ModeleJava modeles;

    /*
     * Constructeurs
     */

    public GenerateRepesitoryFor() {
        super();
    }

    /*
     * Methodes
     */
    private Class getRepesitory() {
        Class repesitory = new Class();

        repesitory.setaPackage(this.modeles.getName() + "." + "repesitory");
        repesitory.setVisibilite(Visibilite.PUBLIC);
        repesitory.setName("AbstractRepesitory");

        AttributeJava modele = new AttributeJava();
        modele.setVisibilite(Visibilite.PUBLIC);
        TypeElement typeMoele = new TypeElement();
        typeMoele.setType("Modele");
        modele.setType(typeMoele);
        // repesitory.set

        return repesitory;
    }

    /*
     * Accesseurs
     */


}

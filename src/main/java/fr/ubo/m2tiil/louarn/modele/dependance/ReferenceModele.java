package fr.ubo.m2tiil.louarn.modele.dependance;

import fr.ubo.m2tiil.louarn.visiteurs.dependance.VisitorDependance;

public class ReferenceModele extends Dependance {

    /*
     * Méthodes
     */

    @Override
    public void accept(VisitorDependance visitorDependance) {
        visitorDependance.visite(this);
    }

}

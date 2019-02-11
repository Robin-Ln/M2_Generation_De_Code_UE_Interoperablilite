package fr.ubo.m2tiil.louarn.visiteurs.dependance;

import fr.ubo.m2tiil.louarn.modele.dependance.Primitive;
import fr.ubo.m2tiil.louarn.modele.dependance.ReferenceModele;

public interface VisitorDependance {

    void visite(Primitive primitive);

    void visite(ReferenceModele referenceModele);
}

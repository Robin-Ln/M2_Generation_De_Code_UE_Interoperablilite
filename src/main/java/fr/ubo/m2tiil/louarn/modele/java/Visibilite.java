package fr.ubo.m2tiil.louarn.modele.java;

public enum Visibilite {

    PRIVATE ("private"),
    PROTECTED ("protected"),
    PUBLIC ("public");

    private String visibilite;

    Visibilite(String visibilite) {
        this.visibilite = visibilite;
    }
}

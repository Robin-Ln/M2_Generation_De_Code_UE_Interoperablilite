package fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.satelite;

public class SateliteInstance {

    /**
     * Atribute
     */

    private String nom;

    private String id;

    private String idParent;


    /**
     * Accesseurs
     */

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdParent() {
        return idParent;
    }

    public void setIdParent(String idParent) {
        this.idParent = idParent;
    }
}

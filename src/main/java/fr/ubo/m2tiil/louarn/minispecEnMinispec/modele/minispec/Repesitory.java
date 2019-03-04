package fr.ubo.m2tiil.louarn.minispecEnMinispec.modele.minispec;
public class Repesitory extends Type {
	/**
	 * Attribut
	 */
	public Modele modele;

	/**
	 * Consrructeut
	 */
	public Repesitory() {
		super();
		modele = new Modele();
		modele.setName("fr.ubo.m2tiil.louarn.minispecEnMinispec.modele.autre");

		Entite entite = new Entite();
		entite.setName("Flotte");
		entite.setSubype("");

		Attribute attributeFloteSatelite = new Attribute();
		attributeFloteSatelite.setName("Satelite");





	}


	/**
	 * Accesseurs
	 */
	public Modele getModele(){
		return this.modele;
	}

	public void setModele(Modele modele){
		this.modele = modele;
	}
}

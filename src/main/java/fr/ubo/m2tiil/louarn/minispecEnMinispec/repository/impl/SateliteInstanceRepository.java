package fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.impl;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance.SateliteInstance;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.AbstractRepository;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance.SateliteInstance;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
public class SateliteInstanceRepository extends AbstractRepository<SateliteInstance> {
	public SateliteInstance lire(Element element){
		SateliteInstance instance = new SateliteInstance();
		instance.nom = element.getAttribute("nom");
		instance.parent = element.getAttribute("parent");
		return instance;
		
	}
	public Element ecrire(SateliteInstance instance, Document document){
		Element element = document.createElement("SateliteInstance");
		element.setAttribute("nom", instance.nom);
		element.setAttribute("parent", instance.parent);
		return element;
		
	}
}

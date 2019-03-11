package fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.repository;

import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance.SateliteInstance;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
public class SateliteInstanceRepository extends AbstractRepository<SateliteInstance> {

	public SateliteInstance lire(Element element, Document document) {
		SateliteInstance instance = new SateliteInstance();
		instance.nom = element.getAttribute("nom");

		FlotteInstanceRepository repository = new FlotteInstanceRepository();
		Element parentElement = document.getElementById(element.getAttribute("parent"));
		instance.parent = repository.lire(parentElement, document);

		return instance;
		
	}
	public Element ecrire(SateliteInstance instance, Document document){
		Element element = document.createElement("SateliteInstance");
		element.setAttribute("nom", instance.nom);
		element.setAttribute("parent", instance.parent.id);
		element.setIdAttribute("parent", true);
		return element;
	}
}

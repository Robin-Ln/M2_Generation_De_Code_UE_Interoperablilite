package fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.repository;

import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance.FlotteInstance;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance.SateliteInstance;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class FlotteInstanceRepository extends AbstractRepository<FlotteInstance> {
	public FlotteInstance lire(Element element, Document document) {
		FlotteInstance instance = new FlotteInstance();
		String[] ids = element.getAttribute("satelites").split(" ");

		SateliteInstanceRepository repository = new SateliteInstanceRepository();
		for (String id : ids) {
			instance.satelites.add(repository.lire(document.getElementById(id), document));
		}

		return instance;
		
	}
	public Element ecrire(FlotteInstance instance, Document document){
		Element element = document.createElement("FlotteInstance");

		String ids = new String();
		for (SateliteInstance sateliteInstance : instance.satelites) {
			ids += sateliteInstance.id + " ";
		}

		element.setAttribute("satelites", ids);

		return element;
		
	}
}

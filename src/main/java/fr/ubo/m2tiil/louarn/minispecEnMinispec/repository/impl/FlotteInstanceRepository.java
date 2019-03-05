package fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.impl;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance.FlotteInstance;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.AbstractRepository;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance.FlotteInstance;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
public class FlotteInstanceRepository extends AbstractRepository<FlotteInstance> {
	public FlotteInstance lire(Element element){
		FlotteInstance instance = new FlotteInstance();
		instance.satelites = element.getAttribute("satelites");
		return instance;
		
	}
	public Element ecrire(FlotteInstance instance, Document document){
		Element element = document.createElement("FlotteInstance");
		element.setAttribute("satelites", instance.satelites);
		return element;
		
	}
}

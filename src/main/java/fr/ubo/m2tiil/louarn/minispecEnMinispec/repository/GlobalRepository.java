package fr.ubo.m2tiil.louarn.minispecEnMinispec.repository;

import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance.AbstractInstance;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.repository.AbstractRepository;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.repository.FlotteInstanceRepository;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.repository.SateliteInstanceRepository;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.visiteurs.VisiteurInstanceEcrire;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalRepository {

    private Map<String, AbstractRepository> repositoryMap;

    public GlobalRepository() {
        this.repositoryMap = new HashMap<>();
        this.initRepositoryMap();

    }

    private void initRepositoryMap() {
        this.repositoryMap.put("FlotteInstance", new FlotteInstanceRepository());
        this.repositoryMap.put("SateliteInstance", new SateliteInstanceRepository());
    }

    public List<AbstractInstance> lire(Document document) {
        List<AbstractInstance> instances = new ArrayList<>();


        Element root= document.getDocumentElement();

        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element instanceElement = (Element) node;
                AbstractRepository<?> repository = this.repositoryMap.get(instanceElement.getTagName());
                instances.add(repository.lire(instanceElement, document));
            }
        }

        return instances;
    }

    public Document ecrire(List<AbstractInstance> instances) {

        this.initId(instances);

        Document document = null;
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            DOMImplementation domImplementation = documentBuilder.getDOMImplementation();

            document = domImplementation.createDocument("", "Instances", null);

            VisiteurInstanceEcrire visiteur = new VisiteurInstanceEcrire(document);
            for (AbstractInstance instance : instances) {
                instance.accept(visiteur);
            }

            return document;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void initId(List<AbstractInstance> instances) {
        Integer cpt = 0;
        for (AbstractInstance instance : instances) {
            instance.id = (cpt++).toString();
        }
    }
}

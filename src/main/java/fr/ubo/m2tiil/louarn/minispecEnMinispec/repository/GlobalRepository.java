package fr.ubo.m2tiil.louarn.minispecEnMinispec.repository;

import fr.ubo.m2tiil.louarn.minispecEnMinispec.modele.autre.Flotte;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.impl.FlotteInstanceRepository;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance.SateliteInstance;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalRepository {

    private Map<String, AbstractRepository> repositoryMap;

    private Map<Class<?>, String> instanceMap;


    public GlobalRepository() {
        this.initRepositoryMap();
        this.initInstanceMap();

    }

    private void initInstanceMap() {
        this.instanceMap = new HashMap<>();
        this.instanceMap.put(Flotte.class, "FlotteInstance");
        this.instanceMap.put(SateliteInstance.class, "SateliteInstance");
    }

    private void initRepositoryMap() {
        this.repositoryMap = new HashMap<>();
        this.repositoryMap.put("FlotteInstance", new FlotteInstanceRepository());
        this.repositoryMap.put("SateliteInstance", new FlotteInstanceRepository());
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
                instances.add(repository.lire(instanceElement));
            }
        }

        return instances;
    }

    public Document ecrire(List<AbstractInstance> instances) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            DOMImplementation domImplementation = documentBuilder.getDOMImplementation();

            Document document = domImplementation.createDocument("", "Instance", null);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

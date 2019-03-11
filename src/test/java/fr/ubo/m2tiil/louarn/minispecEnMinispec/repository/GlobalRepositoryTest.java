package fr.ubo.m2tiil.louarn.minispecEnMinispec.repository;

import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance.AbstractInstance;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance.FlotteInstance;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance.SateliteInstance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class GlobalRepositoryTest {

    private GlobalRepository globalRepository;
    private List<AbstractInstance> instances;
    private Document document;

    @BeforeEach
    void setUp() {
        globalRepository = new GlobalRepository();

        FlotteInstance flotteInstance = new FlotteInstance();

        SateliteInstance sateliteInstance = new SateliteInstance();
        sateliteInstance.nom = "satelite1";
        sateliteInstance.parent = flotteInstance;

        flotteInstance.satelites.add(sateliteInstance);

        instances = new ArrayList<>();
        instances.add(sateliteInstance);
        instances.add(flotteInstance);

        this.document = globalRepository.ecrire(this.instances);
    }

    @Test
    void lire() {
        List<AbstractInstance> instances = this.globalRepository.lire(this.document);
    }

    @Test
    void ecrire() {
        try {
            Document document = globalRepository.ecrire(this.instances);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(System.out);

            transformer.transform(domSource, streamResult);

        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}

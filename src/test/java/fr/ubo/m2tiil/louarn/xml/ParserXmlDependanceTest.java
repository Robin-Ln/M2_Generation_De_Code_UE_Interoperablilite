package fr.ubo.m2tiil.louarn.xml;

import fr.ubo.m2tiil.louarn.modele.java.Dependance;
import fr.ubo.m2tiil.louarn.utils.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserXmlDependanceTest {
    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;
    private Document document;

    private ParserXmlDependance parser;

    private List<Dependance> dependances;

    @BeforeEach
    void init() throws ParserConfigurationException, IOException, SAXException {
        /**
         * Initialisation du documents
         */
        this.factory = DocumentBuilderFactory.newInstance();
        this.builder = factory.newDocumentBuilder();
        File file = new File(getClass().getClassLoader().getResource(Constants.PATH_DEPENDANCES_XML).getPath());
        if (!file.exists()) {
            fail("La resource " + Constants.PATH_DEPENDANCES_XML + " n'est pas disponible");
        }
        this.document = builder.parse(file);

        /**
         * Initialisation du parser
         */
        this.parser = new ParserXmlDependance(this.document);
        this.parser.lire();
        this.dependances = this.parser.getDependencies();
    }

    @Test
    void dependancesTest() {
        Dependance dependance = dependances.get(0);
        assertNotNull(dependance);
        assertEquals(dependance.getName(), "List");
        assertEquals(dependance.getType(), "List");
        assertEquals(dependance.getPackageName(), "java.util.List");
    }
}

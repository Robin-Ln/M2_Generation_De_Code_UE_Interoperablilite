package fr.ubo.m2tiil.louarn.xml;

import fr.ubo.m2tiil.louarn.modele.commun.Collection;
import fr.ubo.m2tiil.louarn.modele.commun.TypeElement;
import fr.ubo.m2tiil.louarn.modele.minispec.AttributeMinispec;
import fr.ubo.m2tiil.louarn.modele.minispec.Entity;
import fr.ubo.m2tiil.louarn.modele.minispec.ModeleMinispec;
import fr.ubo.m2tiil.louarn.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ParserXmlMinispecTest {

    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;
    private Document document;

    private ParserXmlMinispec parser;

    private ModeleMinispec modele;

    @BeforeEach
    void init() throws ParserConfigurationException, IOException, SAXException {
        /**
         * Initialisation du documents
         */
        this.factory = DocumentBuilderFactory.newInstance();
        this.builder = factory.newDocumentBuilder();
        File file = new File(getClass().getClassLoader().getResource(Constants.PATH_BALISE_SAELITE_XML).getPath());
        if (!file.exists()) {
            fail("La resource " + Constants.PATH_BALISE_SAELITE_XML + " n'est pas disponible");
        }
        this.document = builder.parse(file);

        /**
         * Initialisation du parser
         */
        this.parser = new ParserXmlMinispec(this.document);
        this.parser.lire();
        this.modele = this.parser.getModeleMinispec();
    }

    @Test
    void modeleTest() {
        /**
         * Test général de l'application
         */
        assertEquals(modele.getName(), "modele");
        assertEquals(modele.getEntities().size(), 2);
    }

    @Test
    void entiteTest() {
        /**
         * Test de l'entite satelite
         */
        Entity satellite = modele.getEntities().get(0);
        assertEquals(satellite.getName(), "Satellite");
        assertTrue(StringUtils.isBlank(satellite.getSuperType()));
        assertEquals(satellite.getAttributeMinispecs().size(), 2);
    }

    @Test
    void associationSimpleTest() {
        /**
         * Test de l'attribut nom de l'entite satellite
         */
        Entity satellite = modele.getEntities().get(0);
        AttributeMinispec nom = satellite.getAttributeMinispecs().get(0);
        assertEquals(nom.getName(), "nom");
        assertEquals(nom.getType(), new TypeElement("String"));
    }

    @Test
    void associationMultipleTest() {

        /**
         * Test de l'attribut satellite de l'entite Flote
         */
        Entity flote = modele.getEntities().get(1);
        AttributeMinispec satelites = flote.getAttributeMinispecs().get(0);
        assertEquals(satelites.getName(), "satellites");
        assertEquals(satelites.getType(), new Collection("List", new TypeElement("Satellite")));

    }
}

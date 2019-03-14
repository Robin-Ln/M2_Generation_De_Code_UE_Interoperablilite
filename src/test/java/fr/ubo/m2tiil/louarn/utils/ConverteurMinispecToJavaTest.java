package fr.ubo.m2tiil.louarn.utils;

import fr.ubo.m2tiil.louarn.modele.commun.Array;
import fr.ubo.m2tiil.louarn.modele.commun.Collection;
import fr.ubo.m2tiil.louarn.modele.commun.TypeElement;
import fr.ubo.m2tiil.louarn.modele.java.AttributeJava;
import fr.ubo.m2tiil.louarn.modele.java.Clazz;
import fr.ubo.m2tiil.louarn.modele.java.ModeleJava;
import fr.ubo.m2tiil.louarn.modele.java.MotsCles;
import fr.ubo.m2tiil.louarn.modele.minispec.AttributeMinispec;
import fr.ubo.m2tiil.louarn.modele.minispec.Entity;
import fr.ubo.m2tiil.louarn.modele.minispec.ModeleMinispec;
import fr.ubo.m2tiil.louarn.xml.ParserXmlDependance;
import fr.ubo.m2tiil.louarn.xml.ParserXmlMinispec;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConverteurMinispecToJavaTest {

    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;
    private Document document;

    private ParserXmlMinispec parserXmlMinispec;

    private ModeleMinispec modeleMinispec;

    private ModeleJava modeleJava;

    private ConverteurMinispecToJava converteur;
    private ParserXmlDependance parserDependance;

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
         * Initialisation du parserXmlMinispec
         */
        this.parserXmlMinispec = new ParserXmlMinispec(this.document);
        this.parserXmlMinispec.lire();
        this.modeleMinispec = this.parserXmlMinispec.getModeleMinispec();

        /**
         * Initialiation du modele java
         */
        file = new File(getClass().getClassLoader().getResource(Constants.PATH_DEPENDANCES_XML).getPath());
        if (!file.exists()) {
            fail("La resource " + Constants.PATH_DEPENDANCES_XML + " n'est pas disponible");
        }
        this.document = builder.parse(file);
        this.parserDependance = new ParserXmlDependance(this.document);
        this.parserDependance.lire();
        this.converteur = new ConverteurMinispecToJava(this.parserDependance.getDependencies());
        this.modeleJava = converteur.convert(this.modeleMinispec);
    }

    @Test
    void modeleTest() {
        /**
         * Test général de l'application
         */
        assertEquals(this.modeleJava.getName(), "modele");
        assertEquals(this.modeleJava.getClazzes().size(), 2);
    }

    @Test
    void entiteTest() {
        /**
         * Test de l'entite satelite
         */
        Clazz satellite = this.modeleJava.getClazzes().get(0);
        assertEquals(satellite.getName(), "Satellite");
        assertTrue(StringUtils.isBlank(satellite.getSupertype()));
        assertEquals(satellite.getGeneriqueClasses().size(), 0);
        assertEquals(satellite.getImplementsClasses().size(), 0);
        assertEquals(satellite.getAttributeJavas().size(), 2);
        assertEquals(satellite.getMethodes().size(), 4);
        assertTrue(satellite.getMotsCles().containsAll(Arrays.asList(MotsCles.PUBLIC)));
    }

    @Test
    void associationSimpleTest() {
        /**
         * Test de l'attribut nom de l'entite satellite
         */
        Clazz satellite = this.modeleJava.getClazzes().get(0);
        AttributeJava nom = satellite.getAttributeJavas().get(0);
        assertEquals(nom.getName(), "nom");
        assertEquals(nom.getType(), new TypeElement("String"));
    }

    @Test
    void associationMultipleTest() {

        /**
         * Test de l'attribut satellite de l'entite Flote
         */
        Clazz flote = this.modeleJava.getClazzes().get(1);
        AttributeJava satelites = flote.getAttributeJavas().get(0);
        assertEquals(satelites.getName(), "satellites");
        assertEquals(satelites.getType(), new Collection("List", new TypeElement("Satellite")));

    }
}

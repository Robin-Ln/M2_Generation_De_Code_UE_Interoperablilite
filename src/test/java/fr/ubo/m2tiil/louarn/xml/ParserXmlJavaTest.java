package fr.ubo.m2tiil.louarn.xml;

import fr.ubo.m2tiil.louarn.modele.commun.Collection;
import fr.ubo.m2tiil.louarn.modele.commun.TypeElement;
import fr.ubo.m2tiil.louarn.modele.java.AttributeJava;
import fr.ubo.m2tiil.louarn.modele.java.Clazz;
import fr.ubo.m2tiil.louarn.modele.java.ModeleJava;
import fr.ubo.m2tiil.louarn.modele.java.MotsCles;
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
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ParserXmlJavaTest {

    private ModeleJava modeleJava;

    @BeforeEach
    void init() throws ParserConfigurationException, IOException, SAXException {
        /**
         * Initialisation du documents
         */
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File file = new File(getClass().getClassLoader().getResource(Constants.PATH_CLASS_XML).getPath());
        if (!file.exists()) {
            fail("La resource " + Constants.PATH_CLASS_XML + " n'est pas disponible");
        }
        Document document = builder.parse(file);

        /**
         * Initialisation du parserXmlMinispec
         */
        ParserXmlJava parserXmlJava = new ParserXmlJava(document);
        parserXmlJava.lire();
        this.modeleJava = parserXmlJava.getModeleJava();
    }

    @Test
    void modeleTest() {
        /**
         * Test général de l'application
         */
        assertEquals(this.modeleJava.getName(), "repository");
        assertEquals(this.modeleJava.getClazzes().size(), 1);
    }

    @Test
    void classTest() {
        /**
         * Test de l'entite satelite
         */
        Clazz satellite = this.modeleJava.getClazzes().get(0);
        assertEquals(satellite.getName(), "UneClass");
        assertEquals(satellite.getApackage(), "repository");
        assertEquals(satellite.getSupertype(), "ExteandClass");

        assertEquals(satellite.getGeneriqueClasses().size(), 0);
        assertEquals(satellite.getImplementsClasses().size(), 2);
        assertEquals(satellite.getAttributeJavas().size(), 2);
        assertEquals(satellite.getAccesseurs().size(), 2);
        assertTrue(satellite.getMotsCles().containsAll(Arrays.asList(MotsCles.PUBLIC, MotsCles.CLASS)));
    }

    @Test
    void associationSimpleTest() {
        /**
         * Test de l'attribut nom de l'entite uneClass
         */
        Clazz uneClass = this.modeleJava.getClazzes().get(0);
        AttributeJava nom = uneClass.getAttributeJavas().get(0);
        assertEquals(nom.getName(), "nom");
        assertEquals(nom.getType(), new TypeElement("String"));
    }

    @Test
    void associationMultipleTest() {

        /**
         * Test de l'attribut uneList de l'entite uneClass
         */
        Clazz uneClass = this.modeleJava.getClazzes().get(0);
        AttributeJava uneList = uneClass.getAttributeJavas().get(1);
        assertEquals(uneList.getName(), "uneList");
        assertEquals(uneList.getType(), new Collection("List", new TypeElement("String")));

    }

}

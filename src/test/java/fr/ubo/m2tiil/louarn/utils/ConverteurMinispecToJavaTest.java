package fr.ubo.m2tiil.louarn.utils;

import fr.ubo.m2tiil.louarn.modele.java.ModeleJava;
import fr.ubo.m2tiil.louarn.modele.minispec.ModeleMinispec;
import fr.ubo.m2tiil.louarn.xml.ParserXmlMinispec;
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

class ConverteurMinispecToJavaTest {

    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;
    private Document document;

    private ParserXmlMinispec parser;

    private ModeleMinispec modeleMinispec;

    private ModeleJava modeleJava;

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
        this.modeleMinispec = this.parser.getModeleMinispec();

        /**
         * Initialiation du modele java
         */
        // TODO j'ai besoin de tester le ârser de dependence
//        ConverteurMinispecToJava converteu = new ConverteurMinispecToJava()
    }

    @Test
    void convert() {
    }
}

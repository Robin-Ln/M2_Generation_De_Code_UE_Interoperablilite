package fr.ubo.m2tiil.louarn.xml;

import fr.ubo.m2tiil.louarn.modele.java.ModeleJava;
import fr.ubo.m2tiil.louarn.utils.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

class ParserXmlJavaTest {

    private ModeleJava modele;

    @BeforeEach
    void init() throws ParserConfigurationException, IOException, SAXException {
        /**
         * Initialisation du documents
         */
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File file = new File(getClass().getClassLoader().getResource(Constants.PATH_CLASS_XML).getFile());
        if (!file.exists()) {
            fail("La resource " + Constants.PATH_CLASS_XML + " n'est pas disponible");
        }
        Document document = builder.parse(file);

        /**
         * Initialisation du parserXmlMinispec
         */
        ParserXmlJava parserXmlJava = new ParserXmlJava(document);
        parserXmlJava.lire();
        ModeleJava modeleJava = parserXmlJava.getModeleJava();
    }

}

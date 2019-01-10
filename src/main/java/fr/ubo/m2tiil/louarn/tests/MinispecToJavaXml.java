package fr.ubo.m2tiil.louarn.tests;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import fr.ubo.m2tiil.louarn.modele.minispec.ModeleMinispec;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import fr.ubo.m2tiil.louarn.visiteurs.minispec.VisitorMinispecCheckHeritage;
import fr.ubo.m2tiil.louarn.visiteurs.minispec.VisitorMinispecPrinter;
import fr.ubo.m2tiil.louarn.xml.ParserXmlMinispec;
import fr.ubo.m2tiil.louarn.xml.XmlErrorHandler;

public class MinispecToJavaXml {


    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        XmlErrorHandler xmlErrorHandler = new XmlErrorHandler();
        builder.setErrorHandler(xmlErrorHandler);
        File xml = new File("src/main/resources/XMLs/minispecXml/figure10.xml");
        Document document = builder.parse(xml);

        /*
         * Validation de la DTD
         */
        if (xmlErrorHandler.isValide()) {
            ParserXmlMinispec parserXml = new ParserXmlMinispec(document);
            parserXml.lire();

            ModeleMinispec modeleMinispec = parserXml.getModeleMinispec();

            VisitorMinispecCheckHeritage visitorCheckHeritage = new VisitorMinispecCheckHeritage();
            modeleMinispec.accept(visitorCheckHeritage);

            /*
             * Verrification de l'héritage
             */
            if (visitorCheckHeritage.isValide()) {
                VisitorMinispecPrinter visitorPrinter = new VisitorMinispecPrinter(System.out);
                modeleMinispec.accept(visitorPrinter);
            } else {
                for (Exception exception : visitorCheckHeritage.getExceptions()) {
                    System.out.println(exception);
                }
            }


        } else {
            for (SAXParseException saxParseException : xmlErrorHandler.getSAXParseExceptions()) {
                System.out.println("Line : " + saxParseException.getLineNumber() + "" + ", colonne : "
                        + saxParseException.getColumnNumber() + " -----> " + saxParseException.getMessage());
            }
        }

    }
}

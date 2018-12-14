package tests;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import meta.modele.minispec.ModeleMinispec;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import visiteurs.minispec.VisitorMinispecCheckHeritage;
import visiteurs.minispec.VisitorMinispecPrinter;
import xml.ParserXmlMinispec;
import xml.XmlErrorHandler;

public class Test2 {


    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        XmlErrorHandler xmlErrorHandler = new XmlErrorHandler();
        builder.setErrorHandler(xmlErrorHandler);
        File xml = new File("XMLs/minispec/figure10.xml");
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

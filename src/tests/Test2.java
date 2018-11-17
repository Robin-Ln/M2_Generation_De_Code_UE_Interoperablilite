package tests;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import meta.modele.generateClass.Modele;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import visiteurs.VisitorCheckHeritage;
import visiteurs.VisitorPrinter;
import xml.ParserXml;
import xml.XmlErrorHandler;

public class Test2 {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        XmlErrorHandler xmlErrorHandler = new XmlErrorHandler();
        builder.setErrorHandler(xmlErrorHandler);
        File xml = new File("XMLs/partie2/figure10.xml");
        Document document = builder.parse(xml);

        /*
         * Validation de la DTD
         */
        if (xmlErrorHandler.isValide()) {
            ParserXml parserXml = new ParserXml(document);
            parserXml.lire();

            Modele modele = parserXml.getModele();

            VisitorCheckHeritage visitorCheckHeritage = new VisitorCheckHeritage();
            modele.accept(visitorCheckHeritage);

            /*
             * Verrification de l'héritage
             */
            if (visitorCheckHeritage.isValide()) {
                VisitorPrinter visitorPrinter = new VisitorPrinter(System.out);
                modele.accept(visitorPrinter);
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

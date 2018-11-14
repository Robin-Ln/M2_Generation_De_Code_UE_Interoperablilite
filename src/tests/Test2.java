package tests;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

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
		File xml = new File("XMLs/partie2_3/figure10.xml");
		Document document = builder.parse(xml);
		if (xmlErrorHandler.isValide()) {
			ParserXml parserXml = new ParserXml(document);
			parserXml.lire();

			VisitorPrinter visitorPrinter = new VisitorPrinter(System.out);
			parserXml.getModele().accept(visitorPrinter);
		} else {
			for (SAXParseException saxParseException : xmlErrorHandler.getSAXParseExceptions()) {
				System.out.println("Line : " + saxParseException.getLineNumber() + "" + ", colonne : "
						+ saxParseException.getColumnNumber() + "" + " -----> " + saxParseException.getMessage());
			}
		}

	}
}

package fr.ubo.m2tiil.louarn.tests;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import fr.ubo.m2tiil.louarn.helpers.ConverteurMinispecToJava;
import fr.ubo.m2tiil.louarn.modele.dependance.Dependance;
import fr.ubo.m2tiil.louarn.modele.java.Class;
import fr.ubo.m2tiil.louarn.modele.java.ModeleJava;
import fr.ubo.m2tiil.louarn.modele.minispec.ModeleMinispec;
import fr.ubo.m2tiil.louarn.visiteurs.dependance.VisitorDependenciesUtile;
import fr.ubo.m2tiil.louarn.helpers.CheckHeritage;
import fr.ubo.m2tiil.louarn.visiteurs.java.VisitorJavaPrinter;
import fr.ubo.m2tiil.louarn.xml.ParserXmlDependance;
import fr.ubo.m2tiil.louarn.xml.ParserXmlMinispec;
import fr.ubo.m2tiil.louarn.xml.XmlErrorHandler;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

public class MinispecToJavaXml {


    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        XmlErrorHandler xmlErrorHandler = new XmlErrorHandler();
        builder.setErrorHandler(xmlErrorHandler);

        File xmlMinispec = new File("src/main/resources/XMLs/minispecXml/minispecEnMinispec.xml");
        File xmlDependence = new File("src/main/resources/XMLs/java-code/figure16.xml");

        Document document = builder.parse(xmlMinispec);

        /*
         * xmlMinispec
         * Validation de la DTD
         */
        ModeleJava modeleJava = null;
        if (xmlErrorHandler.isValide()) {
            ParserXmlMinispec parserXml = new ParserXmlMinispec(document);
            parserXml.lire();

            ModeleMinispec modeleMinispec = parserXml.getModeleMinispec();

            modeleJava = new ConverteurMinispecToJava(modeleMinispec).getModeleJava();
        }

        document = builder.parse(xmlDependence);

        /*
         * xmlDependence
         * Validation de la DTD
         */
        List<Dependance> dependances = null;
        document = builder.parse(xmlDependence);
        if (xmlErrorHandler.isValide()) {
            ParserXmlDependance parserXmlDependance = new ParserXmlDependance(document);
            parserXmlDependance.lire();

            dependances = parserXmlDependance.getDependencies();

        }

        if (!xmlErrorHandler.isValide()) {
            for (SAXParseException saxParseException : xmlErrorHandler.getSAXParseExceptions()) {
                System.out.println("Line : " + saxParseException.getLineNumber() + ", colonne : "
                        + saxParseException.getColumnNumber() + " -----> " + saxParseException.getMessage());
            }
        }

        CheckHeritage checkHeritage = new CheckHeritage();
        checkHeritage.checkHeritage(modeleJava);
        if (!checkHeritage.getExceptions().isEmpty()){
            System.out.println("heritage KO");
        }

        VisitorDependenciesUtile visitorDependenciesUtile = new VisitorDependenciesUtile(dependances);
        visitorDependenciesUtile.visite(modeleJava);

        String path = "src/main/java/fr/ubo/m2tiil/louarn/minispecEnMinispec";
        VisitorJavaPrinter visitorJavaPrinter = new VisitorJavaPrinter(path);
        modeleJava.accept(visitorJavaPrinter);


    }
}

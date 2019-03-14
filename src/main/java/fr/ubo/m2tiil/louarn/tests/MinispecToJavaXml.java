package fr.ubo.m2tiil.louarn.tests;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class MinispecToJavaXml {


    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        factory.setValidating(true);
//        DocumentBuilder builder = factory.newDocumentBuilder();
//        XmlErrorHandler xmlErrorHandler = new XmlErrorHandler();
//        builder.setErrorHandler(xmlErrorHandler);
//
//        File xmlMinispec = new File("src/main/resources/XMLs/minispecXml/minispecEnMinispec.xml");
//        File xmlSatelite = new File("src/main/resources/XMLs/minispecXml/figure10.xml");
//        File xmlDependence = new File("src/main/resources/XMLs/java-code/figure16.xml");
//
//        Document document = builder.parse(xmlMinispec);
//
//
//        /*
//         * xmlMinispec
//         * Validation de la DTD
//         */
//        ModeleMinispec modeleMinispec = null;
//        ModeleMinispec modeleMinispecSatelite = null;
//        ModeleJava modeleJava = null;
//        ModeleJava modeleJavaSatelite = null;
//        if (xmlErrorHandler.isValide()) {
//            ParserXmlMinispec parserXml = new ParserXmlMinispec(document);
//            parserXml.lire();
//            modeleMinispec = parserXml.getModeleMinispec();
//            modeleJava = new ConverteurMinispecToJava(modeleMinispec).getModeleJava();
//
//
//            document = builder.parse(xmlSatelite);
//            parserXml = new ParserXmlMinispec(document);
//            parserXml.lire();
//            modeleMinispecSatelite = parserXml.getModeleMinispec();
//            modeleJavaSatelite = new ConverteurMinispecToJava(modeleMinispecSatelite).getModeleJava();
//        }
//
//        document = builder.parse(xmlDependence);
//
//        /*
//         * xmlDependence
//         * Validation de la DTD
//         */
//        List<Dependance> dependances = null;
//        document = builder.parse(xmlDependence);
//        if (xmlErrorHandler.isValide()) {
//            ParserXmlDependance parserXmlDependance = new ParserXmlDependance(document);
//            parserXmlDependance.lire();
//
//            dependances = parserXmlDependance.getDependencies();
//
//        }
//
//        if (!xmlErrorHandler.isValide()) {
//            for (SAXParseException saxParseException : xmlErrorHandler.getSAXParseExceptions()) {
//                System.out.println("Line : " + saxParseException.getLineNumber() + ", colonne : "
//                        + saxParseException.getColumnNumber() + " -----> " + saxParseException.getMessage());
//            }
//        }
//
//        CheckHeritage checkHeritage = new CheckHeritage();
//        checkHeritage.checkHeritage(modeleJava);
//        if (!checkHeritage.getExceptions().isEmpty()){
//            System.out.println("heritage KO");
//        }
//
//        VisitorDependance visitorDependance = new VisitorDependance(dependances);
//        visitorDependance.visite(modeleJava);
//        visitorDependance.visite(modeleJavaSatelite);
//
//        String path = "src/main/java/fr/ubo/m2tiil/louarn/minispecEnMinispec/modele/minispec";
//        VisitorJavaPrinter visitorJavaPrinter = new VisitorJavaPrinter(path);
//        modeleJava.accept(visitorJavaPrinter);
//
//
//
//        path = "src/main/java/fr/ubo/m2tiil/louarn/minispecEnMinispec/modele/autre";
//        visitorJavaPrinter = new VisitorJavaPrinter(path);
//        modeleJavaSatelite.accept(visitorJavaPrinter);
//
//
//        CreerInstance creerInstance = new CreerInstance();
//        ModeleJava modeleJavaSateliteInstance = creerInstance.creerInstanceModele(modeleJavaSatelite);
//
//        path = "src/main/java/fr/ubo/m2tiil/louarn/minispecEnMinispec/repository/instance";
//        visitorJavaPrinter = new VisitorJavaPrinter(path);
//        modeleJavaSateliteInstance.accept(visitorJavaPrinter);
//
//        CreerRepository creerRepository = new CreerRepository();
//        ModeleJava modeleJavaRepesitory = creerRepository.creerRepositoryModele(modeleJavaSateliteInstance);
//
//
//        path = "src/main/java/fr/ubo/m2tiil/louarn/minispecEnMinispec/repository/repository";
//        visitorJavaPrinter = new VisitorJavaPrinter(path);
//        modeleJavaRepesitory.accept(visitorJavaPrinter);

    }
}

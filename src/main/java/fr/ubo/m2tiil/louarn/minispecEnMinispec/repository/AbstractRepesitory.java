package fr.ubo.m2tiil.louarn.minispecEnMinispec.repository;

import org.w3c.dom.DOMImplementation;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public abstract class AbstractRepesitory<Entite, Instance> {

    /**
     * Consctructeur
     */

    /**
     * Methodes abstraite
     */

    abstract Entite lire(String pathFile);

    abstract void ecrire(Instance instance);

    /**
     * Methodes
     */

    /**
     * ex utilisation : domImplementation.createDocument("", "Societe", null);
     * @return
     */
    DOMImplementation getDocument() {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            return documentBuilder.getDOMImplementation();
        } catch (ParserConfigurationException e){
            e.printStackTrace();
        }
        return null;
    }

}

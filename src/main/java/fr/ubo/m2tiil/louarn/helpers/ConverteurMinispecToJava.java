package fr.ubo.m2tiil.louarn.helpers;

import fr.ubo.m2tiil.louarn.modele.commun.TypeElement;
import fr.ubo.m2tiil.louarn.modele.java.Class;
import fr.ubo.m2tiil.louarn.modele.java.*;
import fr.ubo.m2tiil.louarn.modele.minispec.AttributeMinispec;
import fr.ubo.m2tiil.louarn.modele.minispec.Entity;
import fr.ubo.m2tiil.louarn.modele.minispec.ModeleMinispec;

import java.util.ArrayList;
import java.util.List;

public class ConverteurMinispecToJava {

    /*
     * Attributs
     */
    private ModeleMinispec modeleMinispec;
    private ModeleJava modeleJava;



    /*
     * Constructeurs
     */

    public ConverteurMinispecToJava(ModeleMinispec modeleMinispec) {
        this.modeleMinispec = modeleMinispec;
        this.modeleJava = new ModeleJava();
        this.modeleJava.setName(modeleMinispec.getName());
        for(Entity entity : modeleMinispec.getEntities()){
            modeleJava.getaClasses().add(this.getClass(entity));
        }
    }

    /*
     * Métodes de concertions
     */
    Class getClass(Entity entity){
        Class aClass = new Class();
        aClass.setName(entity.getName());
        aClass.setSubtype(entity.getSubtype());
        aClass.setAttributeJavas(this.getAttributeJavas(entity));
        aClass.setConstructeurs(this.getConstructeurs(aClass));
        aClass.setMethodes(this.getMethodes(entity));
        return aClass;
    }

    List<Constructeur> getConstructeurs(Class aClass){
        List<Constructeur> constructeurs = new ArrayList<>();
        Constructeur constructeur = new Constructeur();
        constructeur.setaClass(aClass);
        constructeur.setVisibilite(Visibilite.PUBLIC);
        constructeurs.add(constructeur);
        return constructeurs;
    }

    List<AttributeJava> getAttributeJavas(Entity entity){
        List<AttributeJava> attributeJavas = new ArrayList<>();
        for (AttributeMinispec attributeMinispec : entity.getAttributeMinispecs()) {
            AttributeJava attributeJava = new AttributeJava();
            attributeJava.setName(attributeMinispec.getName());
            attributeJava.setType(attributeMinispec.getType());
            attributeJava.setVisibilite(Visibilite.PUBLIC);
            attributeJavas.add(attributeJava);
        }
        return attributeJavas;
    }

    List<Methode> getMethodes(Entity entity){
        List<Methode> methodes = new ArrayList<>();

        // création des accesseurs
        for (AttributeMinispec attributeMinispec : entity.getAttributeMinispecs()) {
            methodes.add(this.getGetter(attributeMinispec));
            methodes.add(this.getSetter(attributeMinispec));
        }
        return methodes;
    }

    String getName(AttributeMinispec attributeMinispec) {
        Integer nameSize = attributeMinispec.getName().length();
        return attributeMinispec.getName().substring(0, 1).toUpperCase()
                + attributeMinispec.getName().substring(1, nameSize);
    }

    Methode getGetter(AttributeMinispec attributeMinispec) {
        Methode methode = new Methode();
        methode.setName("get" + this.getName(attributeMinispec));
        methode.setType(attributeMinispec.getType());
        methode.setVisibilite(Visibilite.PUBLIC);
        methode.setArguments(new ArrayList<>());

        Bloc bloc = new Bloc();
        bloc.getLignes().add("return this." + attributeMinispec.getName() + ";");
        methode.setBloc(bloc);

        return methode;
    }

    Methode getSetter(AttributeMinispec attributeMinispec) {

        Methode methode = new Methode();
        methode.setName("set" + this.getName(attributeMinispec));
        TypeElement typeElement = new TypeElement();
        typeElement.setType("void");
        methode.setType(typeElement);
        methode.setVisibilite(Visibilite.PUBLIC);

        List<Argument> arguments = new ArrayList<>();
        Argument argument = new Argument();
        argument.setName(attributeMinispec.getName());
        argument.setType(attributeMinispec.getType());
        arguments.add(argument);
        methode.setArguments(arguments);

        Bloc bloc = new Bloc();
        bloc.getLignes().add("this." + attributeMinispec.getName() + " = " + attributeMinispec.getName() + ";");
        methode.setBloc(bloc);

        return methode;
    }


    /*
     * Métodes
     */

    public ModeleMinispec getModeleMinispec() {
        return modeleMinispec;
    }

    public void setModeleMinispec(ModeleMinispec modeleMinispec) {
        this.modeleMinispec = modeleMinispec;
    }

    public ModeleJava getModeleJava() {
        return modeleJava;
    }

    public void setModeleJava(ModeleJava modeleJava) {
        this.modeleJava = modeleJava;
    }
}

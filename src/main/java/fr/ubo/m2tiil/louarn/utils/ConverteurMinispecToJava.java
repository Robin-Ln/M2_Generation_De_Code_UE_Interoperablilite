package fr.ubo.m2tiil.louarn.utils;

import fr.ubo.m2tiil.louarn.modele.commun.TypeElement;
import fr.ubo.m2tiil.louarn.modele.java.*;
import fr.ubo.m2tiil.louarn.modele.minispec.AttributeMinispec;
import fr.ubo.m2tiil.louarn.modele.minispec.Entity;
import fr.ubo.m2tiil.louarn.modele.minispec.ModeleMinispec;
import fr.ubo.m2tiil.louarn.visiteurs.dependance.VisitorDependance;

import java.util.ArrayList;
import java.util.List;

public class ConverteurMinispecToJava {

    /*
     * Attributs
     */
    private ModeleMinispec modeleMinispec;
    private ModeleJava modeleJava;
    private VisitorDependance visitorDependance;

    /*
     * Constructeurs
     */

    public ConverteurMinispecToJava(List<Dependance> dependances) {
        this.visitorDependance = new VisitorDependance(dependances);
    }

    public ModeleJava convert(ModeleMinispec modeleMinispec) {
        this.modeleMinispec = modeleMinispec;
        this.modeleJava = new ModeleJava();
        // Covertion du modele minispec en java
        this.modeleJava.setName(modeleMinispec.getName());
        for(Entity entity : modeleMinispec.getEntities()){
            Clazz clazz = this.getClass(entity);
            clazz.setApackage(modeleJava.getName());
            modeleJava.getClazzes().add(clazz);
        }

        // ajout du modele dans les depandances
        for (Clazz clazz : modeleJava.getClazzes()) {
            Dependance dependance = new Dependance(clazz.getName(), clazz.getApackage() + "." + clazz.getName(), clazz.getName());
            this.visitorDependance.getDependances().add(dependance);
        }

        // ajout des depandance dans les class du modele
        for (Clazz clazz : modeleJava.getClazzes()) {
            clazz.setDependances(visitorDependance.getClazzDependances(clazz));
        }


        return this.modeleJava;
    }

    /*
     * Métodes de concertions
     */
    private Clazz getClass(Entity entity){
        // Covertion du modele minispec en java
        Clazz aClazz = new Clazz();
        aClazz.getMotsCles().add(MotsCles.PUBLIC);
        aClazz.getMotsCles().add(MotsCles.CLASS);
        aClazz.setName(entity.getName());
        aClazz.setSupertype(entity.getSuperType());
        aClazz.setAttributeJavas(this.getAttributeJavas(entity));
        aClazz.setConstructeurs(this.getConstructeurs(aClazz));
        aClazz.setAccesseurs(this.getAccesseurs(entity));
        return aClazz;
    }

    private List<Constructeur> getConstructeurs(Clazz clazz){

        List<Constructeur> constructeurs = new ArrayList<>();

        // cration du constrcteur par default
        Constructeur constructeur = new Constructeur();
        constructeur.getMotsCles().add(MotsCles.PUBLIC);
        constructeur.setName(clazz.getName());
        constructeur.setArguments(new ArrayList<>());
        // TODO : créer le block pour initialiser les collection
        constructeur.setBloc(new Bloc());

        constructeurs.add(constructeur);
        return constructeurs;
    }

    private List<AttributeJava> getAttributeJavas(Entity entity){
        // Convertion des attributs minispec en java
        List<AttributeJava> attributeJavas = new ArrayList<>();
        for (AttributeMinispec attributeMinispec : entity.getAttributeMinispecs()) {
            AttributeJava attributeJava = new AttributeJava();
            attributeJava.setName(attributeMinispec.getName());
            attributeJava.setType(attributeMinispec.getType());
            attributeJava.getMotsCles().add(MotsCles.PUBLIC);
            attributeJavas.add(attributeJava);
        }
        return attributeJavas;
    }

    private List<Methode> getAccesseurs(Entity entity){
        List<Methode> methodes = new ArrayList<>();

        // création des accesseurs
        for (AttributeMinispec attributeMinispec : entity.getAttributeMinispecs()) {
            methodes.add(this.getGetter(attributeMinispec));
            methodes.add(this.getSetter(attributeMinispec));
        }
        return methodes;
    }


    private Methode getGetter(AttributeMinispec attributeMinispec) {
        Methode methode = new Methode();
        methode.setName("get" + UtilsHelper.getName(attributeMinispec.getName()));
        methode.setType(attributeMinispec.getType());
        methode.getMotsCles().add(MotsCles.PUBLIC);
        methode.setArguments(new ArrayList<>());

        Bloc bloc = new Bloc();
        bloc.getLignes().append("return this." + attributeMinispec.getName() + ";");
        methode.setBloc(bloc);

        return methode;
    }

    private Methode getSetter(AttributeMinispec attributeMinispec) {

        Methode methode = new Methode();
        methode.setName("set" + UtilsHelper.getName(attributeMinispec.getName()));
        TypeElement typeElement = new TypeElement();
        typeElement.setType("void");
        methode.setType(typeElement);
        methode.getMotsCles().add(MotsCles.PUBLIC);

        List<Argument> arguments = new ArrayList<>();
        Argument argument = new Argument();
        argument.setName(attributeMinispec.getName());
        argument.setType(attributeMinispec.getType());
        arguments.add(argument);
        methode.setArguments(arguments);

        Bloc bloc = new Bloc();
        bloc.getLignes().append("this." + attributeMinispec.getName() + " = " + attributeMinispec.getName() + ";");
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

package fr.ubo.m2tiil.louarn.repository;

import fr.ubo.m2tiil.louarn.modele.commun.TypeElement;
import fr.ubo.m2tiil.louarn.modele.dependance.ReferenceModele;
import fr.ubo.m2tiil.louarn.modele.java.Class;
import fr.ubo.m2tiil.louarn.modele.java.*;

import java.util.ArrayList;
import java.util.List;

public class CreerRepository {

    /**
     * Attributes
     */

    private static final String P_NAME_IMPL = "fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.repository";
    public static final String P_NAME = "fr.ubo.m2tiil.louarn.minispecEnMinispec.repository";


    /**
     * Constructeurs
     */
    public CreerRepository() {
        super();
    }

    /**
     * Methodes
     */

    private Class creerRepositoryClass(Class instance) {

        Class repository = new Class();
        repository.setaPackage(P_NAME_IMPL);
        repository.setName(instance.getName() + "Repository");

        repository.setVisibilite(instance.getVisibilite());
        repository.setPrototype(instance.getPrototype());

        repository.getMethodes().add(this.getMethodeLire(instance));
        repository.getMethodes().add(this.getMethodeEcrire(instance));

        repository.setSupertype("AbstractRepository<" + instance.getName() + ">");

        repository.getDependances().add(new ReferenceModele(instance.getName(), instance.getaPackage()
                + "."
                + instance.getName()));

        repository.getDependances().add(new ReferenceModele("AbstractRepository", P_NAME + "." + "AbstractRepository"));
        repository.getDependances().add(new ReferenceModele(instance.getName(), instance.getaPackage()+ "." + instance.getName()));


        repository.getDependances().add(
                new ReferenceModele("Element", "org.w3c.dom.Element"));
        repository.getDependances().add(
                new ReferenceModele("Document", "org.w3c.dom.Document"));

        return repository;
    }


    public ModeleJava creerRepositoryModele(ModeleJava modeleJavaInstance) {

        ModeleJava modeleJavaRepository = new ModeleJava();
        modeleJavaInstance.setName(P_NAME_IMPL);

        List<Class> instances = new ArrayList<>();

        for (Class instance : modeleJavaInstance.getaClasses()) {
            Class repository = this.creerRepositoryClass(instance);
            instances.add(repository);
        }

        modeleJavaRepository.setaClasses(instances);
        return modeleJavaRepository;
    }


    /**
     * Methode utilile
     */

    private Methode getMethodeLire(Class instance) {

        StringBuilder bloc = new StringBuilder();

        bloc.append(instance.getName() + " instance = new " + instance.getName() + "();");

        for (AttributeJava attributeJava : instance.getAttributeJavas()) {
            bloc.append("instance.")
                    .append(attributeJava.getName() + " = ")
                    .append("element.getAttribute(\"" + attributeJava.getName() + "\");");
        }

        bloc.append("return instance;");

        Methode methode = new Methode();
        methode.setName("lire");
        Argument argument = new Argument("Element", "element");
        methode.getArguments().add(argument);
        methode.setVisibilite(Visibilite.PUBLIC);
        methode.setType(new TypeElement(instance.getName()));
        methode.setBloc(new Bloc(bloc));
        return methode;
    }

    private Methode getMethodeEcrire(Class instance) {
        StringBuilder bloc = new StringBuilder();

        bloc.append("Element element = document.createElement(\"" + instance.getName() + "\");");

        for (AttributeJava attributeJava : instance.getAttributeJavas()) {
            bloc.append("element.setAttribute(\"")
                    .append(attributeJava.getName() + "\"")
                    .append(", instance.")
                    .append(attributeJava.getName() + ");");
        }

        bloc.append("return element;");

        Methode methode = new Methode();
        methode.setName("ecrire");
        Argument argument1 = new Argument(instance.getName(), "instance");
        Argument argument2 = new Argument("Document", "document");
        methode.getArguments().add(argument1);
        methode.getArguments().add(argument2);
        methode.setVisibilite(Visibilite.PUBLIC);
        methode.setType(new TypeElement("Element"));
        methode.setBloc(new Bloc(bloc));
        return methode;
    }
}

package fr.ubo.m2tiil.louarn.modele.java;

import fr.ubo.m2tiil.louarn.modele.commun.Type;
import fr.ubo.m2tiil.louarn.visiteurs.java.VisitableJava;
import fr.ubo.m2tiil.louarn.visiteurs.java.VisitorJava;

import java.util.ArrayList;
import java.util.List;

public class Methode implements VisitableJava {

    /*
     * Attributs
     */

    private List<MotsCles> motsCles;
    private String name;
    private Type type;
    private List<Argument> arguments;
    private Bloc bloc;


    /*
     * Constructeurs
     */

    public Methode() {
        this.arguments = new ArrayList<>();
        this.motsCles = new ArrayList<>();
    }

    /*
     * Methodes
     */
    @Override
    public void accept(VisitorJava visitorJava) {
        visitorJava.visite(this);
    }

    /*
     * Accesseurs
     */

    public List<MotsCles> getMotsCles() {
        return motsCles;
    }

    public void setMotsCles(List<MotsCles> motsCles) {
        this.motsCles = motsCles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Argument> getArguments() {
        return arguments;
    }

    public void setArguments(List<Argument> arguments) {
        this.arguments = arguments;
    }

    public Bloc getBloc() {
        return bloc;
    }

    public void setBloc(Bloc bloc) {
        this.bloc = bloc;
    }
}

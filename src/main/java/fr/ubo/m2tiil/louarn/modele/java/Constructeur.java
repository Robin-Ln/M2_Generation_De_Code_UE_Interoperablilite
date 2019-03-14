package fr.ubo.m2tiil.louarn.modele.java;

import fr.ubo.m2tiil.louarn.visiteurs.java.VisitableJava;
import fr.ubo.m2tiil.louarn.visiteurs.java.VisitorJava;

import java.util.ArrayList;
import java.util.List;

public class Constructeur implements VisitableJava {
    /*
     * Attributs
     */
    private String name;
    private List<MotsCles> motsCles;
    private List<Argument> arguments;
    private Bloc bloc;

    /*
     * Constructeurs
     */

    public Constructeur() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MotsCles> getMotsCles() {
        return motsCles;
    }

    public void setMotsCles(List<MotsCles> motsCles) {
        this.motsCles = motsCles;
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

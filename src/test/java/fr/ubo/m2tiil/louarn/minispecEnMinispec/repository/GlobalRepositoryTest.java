package fr.ubo.m2tiil.louarn.minispecEnMinispec.repository;

import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance.AbstractInstance;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance.FlotteInstance;
import fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance.SateliteInstance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class GlobalRepositoryTest {

    private GlobalRepository globalRepository;
    private List<AbstractInstance> instances;

    @BeforeEach
    void setUp() {
        globalRepository = new GlobalRepository();

        FlotteInstance flotteInstance = new FlotteInstance();

        SateliteInstance sateliteInstance = new SateliteInstance();

    }

    @Test
    void lire() {
    }

    @Test
    void ecrire() {
    }
}

package fr.ubo.m2tiil.louarn.mustache;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import fr.ubo.m2tiil.louarn.modele.java.ModeleJava;
import fr.ubo.m2tiil.louarn.modele.minispec.ModeleMinispec;
import fr.ubo.m2tiil.louarn.utils.Constants;
import fr.ubo.m2tiil.louarn.utils.ConverteurMinispecToJava;
import fr.ubo.m2tiil.louarn.xml.ParserXmlDependance;
import fr.ubo.m2tiil.louarn.xml.ParserXmlMinispec;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.fail;

public class MustacheTest {

    private ModeleJava modele;

    @BeforeEach
    void init() throws ParserConfigurationException, IOException, SAXException {
        /**
         * Initialisation du documents
         */
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File file = new File(getClass().getClassLoader().getResource(Constants.PATH_BALISE_SAELITE_XML).getPath());
        if (!file.exists()) {
            fail("La resource " + Constants.PATH_BALISE_SAELITE_XML + " n'est pas disponible");
        }
        Document document = builder.parse(file);

        /**
         * Initialisation du parserXmlMinispec
         */
        ParserXmlMinispec parserXmlMinispec = new ParserXmlMinispec(document);
        parserXmlMinispec.lire();
        ModeleMinispec modeleMinispec = parserXmlMinispec.getModeleMinispec();

        /**
         * Initialiation du modele java
         */
        file = new File(getClass().getClassLoader().getResource(Constants.PATH_DEPENDANCES_XML).getPath());
        if (!file.exists()) {
            fail("La resource " + Constants.PATH_DEPENDANCES_XML + " n'est pas disponible");
        }
        document = builder.parse(file);
        ParserXmlDependance parserDependance = new ParserXmlDependance(document);
        parserDependance.lire();
        ConverteurMinispecToJava converteur = new ConverteurMinispecToJava(parserDependance.getDependencies());
        this.modele = converteur.convert(modeleMinispec);
    }

    @Test
    void test() throws IOException {
        MustacheFactory mustacheFactory = new DefaultMustacheFactory();
        Mustache mustache = mustacheFactory.compile(Constants.PATH_MUSTACHE_TEMPLATE_CLASS);
        Map<String,Object> context = new HashMap<>();
        context.put("function",this.handler());
        context.put("class", this.modele.getClazzes().get(0));

        mustache.execute(new PrintWriter(System.out), context).flush();
    }

    public Function<String, String> handler() {
        return (obj) -> String.format("function -> ", obj);
    }

}

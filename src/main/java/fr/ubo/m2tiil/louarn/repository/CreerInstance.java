package fr.ubo.m2tiil.louarn.repository;

public class CreerInstance {

//    private static final String P_NAME = "fr.ubo.m2tiil.louarn.minispecEnMinispec.repository.instance";
//
//
//    /**
//     * Constructeurs
//     */
//    public CreerInstance() {
//        super();
//    }
//
//    /**
//     * Methodes
//     */
//
//
//    private Clazz creerInstanceClass(Clazz aClazz) {
//
//        Clazz instance = new Clazz();
//        instance.setVisibilite(aClazz.getVisibilite());
//        instance.setPrototype(aClazz.getPrototype());
//        instance.setName(aClazz.getName() + "Instance");
//
//        instance.setSupertype("AbstractInstance");
//
//        instance.getDependances().add(new ReferenceModele("AbstractInstance", CreerRepository.P_NAME + "." + "AbstractInstance"));
//
//        for (AttributeJava attributeJava : aClazz.getAttributeJavas()) {
//            instance.getAttributeJavas().add(this.getAttribute(attributeJava.getName()));
//        }
//        return instance;
//    }
//
//
//
//    public ModeleJava creerInstanceModele(ModeleJava modeleJava) {
//
//        ModeleJava modeleJavaInstance = new ModeleJava();
//        modeleJavaInstance.setName(CreerInstance.P_NAME);
//
//        List<Clazz> instances = new ArrayList<>();
//
//        for (Clazz aClazz : modeleJava.getClazzes()) {
//            Clazz instance = this.creerInstanceClass(aClazz);
//            instance.setaPackage(CreerInstance.P_NAME);
//            instances.add(instance);
//        }
//
//        modeleJavaInstance.setClazzes(instances);
//        return modeleJavaInstance;
//    }
//
//
//    /**
//     * Methode utilile
//     */
//
//    AttributeJava getAttribute(String name) {
//        AttributeJava attributeJava = new AttributeJava();
//        attributeJava.setName(name);
//        attributeJava.setVisibilite(Visibilite.PUBLIC);
//
//        TypeElement typeElement = new TypeElement();
//        typeElement.setType("String");
//
//
//        attributeJava.setType(typeElement);
//
//
//        return attributeJava;
//    }
}

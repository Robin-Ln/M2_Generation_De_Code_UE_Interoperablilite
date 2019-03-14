package fr.ubo.m2tiil.louarn.utils;

public class UtilsHelper {

    static public String getName(String name) {
        Integer nameSize = name.length();
        return name.substring(0, 1).toUpperCase()
                + name.substring(1, nameSize);
    }

}

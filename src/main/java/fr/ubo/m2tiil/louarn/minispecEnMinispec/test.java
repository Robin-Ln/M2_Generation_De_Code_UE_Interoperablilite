package fr.ubo.m2tiil.louarn.minispecEnMinispec;

import java.util.List;

class Entity {
    public String name;
    public Integer subype;
    public List<Attribute> attributs;
    public Entity() {
        super();
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Integer getSubype(){
        return this.subype;
    }
    public void setSubype(Integer subype){
        this.subype = subype;
    }
    public List<Attribute> getAttributs(){
        return this.attributs;
    }
    public void setAttributs(List<Attribute> attributs){
        this.attributs = attributs;
    }
}
class Attribute {
    public String name;
    public Type type;
    public Attribute() {
        super();
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Type getType(){
        return this.type;
    }
    public void setType(Type type){
        this.type = type;
    }
}
class Type {
    public Type() {
        super();
    }
}
class Array extends Type {
    public Type type;
    public Integer size;
    public Array() {
        super();
    }
    public Type getType(){
        return this.type;
    }
    public void setType(Type type){
        this.type = type;
    }
    public Integer getSize(){
        return this.size;
    }
    public void setSize(Integer size){
        this.size = size;
    }
}
class Collection extends Type {
    public String typeCollection;
    public Type type;
    public Collection() {
        super();
    }
    public String getTypeCollection(){
        return this.typeCollection;
    }
    public void setTypeCollection(String typeCollection){
        this.typeCollection = typeCollection;
    }
    public Type getType(){
        return this.type;
    }
    public void setType(Type type){
        this.type = type;
    }
}
class TypeElement extends Type {
    public String type;
    public TypeElement() {
        super();
    }
    public String getType(){
        return this.type;
    }
    public void setType(String type){
        this.type = type;
    }
}

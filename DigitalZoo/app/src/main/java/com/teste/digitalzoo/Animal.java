package com.teste.digitalzoo;

public class Animal {

    private int id, lifeSpan, image;
    private String name, type;

    public Animal(int id, int lifeSpan, int image, String name, String type) {
        this.id = id;
        this.lifeSpan = lifeSpan;
        this.image = image;
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public int getLifeSpan() {
        return lifeSpan;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}

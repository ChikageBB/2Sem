package ru.itis.inf403.model;

public class Fruit {
    private String name;
    private Integer sugar;

    public Fruit(String name, Integer sugar) {
        this.name = name;
        this.sugar = sugar;
    }

    public String getName() {
        return name;
    }

    public Integer getSugar() {
        return sugar;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj.getClass().equals(this.getClass())) return false;
        if (this == obj) return true;

        return
    }

    @Override
    public String toString() {
        return "Fruit: " + name + ", " + sugar + "%";
    }
}

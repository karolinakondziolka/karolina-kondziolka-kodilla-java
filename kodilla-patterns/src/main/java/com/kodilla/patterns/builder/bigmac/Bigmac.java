package com.kodilla.patterns.builder.bigmac;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class Bigmac {

    private final String bun;
    private final int burger;
    private final String sauce;
    private List<String> ingredients = new ArrayList<>();

    public static class BigmacBuilder {
        private String bun;
        private int burger;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder bun(String bun) {
            this.bun = bun;
            return this;
        }
        public BigmacBuilder burger(int burger) {
            this.burger = burger;
            return this;
        }
        public BigmacBuilder sauce(String sauce) {
            this.sauce= sauce;
            return this;
        }
        public BigmacBuilder ingredient(String ingredient) {
            ingredients.add(ingredient);
            return this;
        }
        public Bigmac build(){
            return new Bigmac(bun, burger,sauce,ingredients);
        }
    }

    public Bigmac(String bun, int burger, String sauce, List<String> ingredients) {
        this.bun = bun;
        this.burger = burger;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public String getBun() {
        return bun;
    }

    public int getBurger() {
        return burger;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun='" + bun + '\'' +
                ", burger=" + burger +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}

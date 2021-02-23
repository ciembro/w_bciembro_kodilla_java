package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class BigMac {

    private final Bun bun;
    private final int burgers;
    private final String sauce;
    private final List<Ingredient> ingredientList;

    private BigMac(Bun bun, int burgers, String sauce, List<Ingredient> ingredientList ) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredientList = ingredientList;
    }

    public static class BigMacBuilder {
        private Bun bun;
        private int burgers;
        private String sauce;
        private List<Ingredient> ingredientList = new ArrayList<>();

        public BigMacBuilder bun(Bun bun){
            if (bun.equals(Bun.WITH_SESAME) || bun.equals(Bun.NO_SESAME)) {
                this.bun = bun;
                return this;
            }
            throw new IllegalStateException("Not available option");
        }

        public BigMacBuilder burgers(int burgers){
            if (burgers > 0 && burgers <= 3){
                this.burgers = burgers;
                return this;
            }
            throw new IllegalStateException("Choose number between 1 - 3");

        }

        public BigMacBuilder sauce(String sauce){
            if (sauce.length() != 0){
                this.sauce = sauce;
                return this;
            }
            throw new IllegalStateException("Sauce not specified.");

        }

        public BigMacBuilder ingredient(Ingredient ingredient){
            ingredientList.add(ingredient);
            return this;
        }

        public BigMac build(){
            return new BigMac(bun, burgers, sauce, ingredientList);
        }

    }

    public Bun getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    @Override
    public String toString() {
        return "BigMac{" +
                "bun=" + bun +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredientList=" + ingredientList +
                '}';
    }
}

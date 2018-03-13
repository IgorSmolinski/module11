package com.igor.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class BigMac {
    private String roll;
    private int burgers;
    private String sauce;
    private List<String> ingredients;
    public static final String SEZAM ="SEZAM";
    public static final String WITHOUT = "WITHOUT";
    public static final String STANDARD = "STANDARD";
    public static final String BARBEQUE = "BARBEQUE";
    public static final String THOUSAND = "THOUSAND";

    private BigMac(String roll, int burgers, String sauce, List ingredients) {
        this.roll = roll;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public static class BigMacBuilder {
        String roll;
        int burgers;
        String sauce;
        List<String> ingredients = new ArrayList<>();

        public BigMacBuilder roll(String roll){
            if (roll==SEZAM || roll==WITHOUT){
                this.roll=roll;
            }else {
                throw new IllegalStateException("You can chose only roll with or without sezam.");
            }
            return this;
        }

        public BigMacBuilder burgers (int quantity){
            if (quantity>4 || quantity<1){
                throw new IllegalStateException("You can add only from 1-4 burgers.");
            }else {
                this.burgers = quantity;
            }
            return this;
        }

        public BigMacBuilder sauce (String sauce){
            if (sauce==BARBEQUE || sauce==THOUSAND || sauce==STANDARD){
                this.sauce = sauce;
            } else {
                throw new IllegalStateException("You can chose only: "
                        + BARBEQUE + "\n"
                        + STANDARD + "\n"
                        + THOUSAND + " sauces");

            }
            return this;
        }

        public BigMacBuilder ingredient(String ingredient){
            ingredients.add(ingredient);
            return this;
        }

        public BigMac build(){
            return new BigMac(roll, burgers, sauce, ingredients);
        }


    }

    public String getRoll() {
        return roll;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String toString(){
        return "BIGMAC:\n"
                + "roll: " + roll + "\n"
                + "how many burgers: " + burgers +"\n"
                + "sauce: " + sauce + "\n"
                + "ingredients:" + ingredients + ".";
    }
}


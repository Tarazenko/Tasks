package by.bntu.fitr.poisit.tarazenko.task5.model.entity;

import by.bntu.fitr.poisit.tarazenko.task5.model.exception.InvalidValueException;

public class Sapphire extends Stone {
    public final String DEFAULT_COLOR = "Blue";
    private String color;

    public Sapphire(){
        super();
        color = DEFAULT_COLOR;
    }

    public Sapphire(double weight, double cost, String color) throws InvalidValueException {
        super(weight,cost);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public String toString() {
        return "Weight: " + getWeight() + "\nCost: " + getCost() + "\nColor: " + color;
    }
}

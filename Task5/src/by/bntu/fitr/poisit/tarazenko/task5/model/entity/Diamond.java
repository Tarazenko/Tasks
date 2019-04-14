package by.bntu.fitr.poisit.tarazenko.task5.model.entity;

import by.bntu.fitr.poisit.tarazenko.task5.model.exception.InvalidValueException;

public class Diamond extends Stone {
    public final String DEFAULT_SHAPE = "Round";
    private String shape;
    public Diamond(){
        super();
        shape = DEFAULT_SHAPE;
    }
    public Diamond(double weight, double cost, String shape) throws InvalidValueException {
        super(weight,cost);
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    @Override
    public String toString() {
        return "Weight: " + getWeight() + "\nCost: " + getCost() + "\nShape: " + shape;
    }
}

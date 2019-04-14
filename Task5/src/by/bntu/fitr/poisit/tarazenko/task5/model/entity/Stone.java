package by.bntu.fitr.poisit.tarazenko.task5.model.entity;

import by.bntu.fitr.poisit.tarazenko.task5.model.exception.InvalidValueException;

public class Stone {
    public final double DEFAULT_WEIGHT = 10;
    public final double DEFAULT_COST = 1000;

    private double cost;
    private double weight;

    public Stone(){
        cost = DEFAULT_COST;
        weight = DEFAULT_WEIGHT;
    }

    public Stone(double weight, double cost) throws InvalidValueException {
        checkForPositive(weight);
        checkForPositive(cost);
        this.weight = weight;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) throws InvalidValueException{
        checkForPositive(cost);
        this.cost = cost;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) throws InvalidValueException {
        checkForPositive(weight);
        this.weight = weight;
    }

    private void checkForPositive(double value) throws InvalidValueException {
        if (value <= 0) {
            throw new InvalidValueException();
        }
    }

    @Override
    public String toString() {
        return "Weight: " + weight + "\nCost: " + cost;
    }

}

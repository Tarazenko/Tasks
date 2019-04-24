package by.bntu.fitr.poisit.tarazenko.task5.model.entity;

import by.bntu.fitr.poisit.tarazenko.task5.model.exception.InvalidValueException;

public class Emerald extends Stone{
    public final boolean DEFAULT_TRANSPARENCY = true;
    private boolean transparency;
    public Emerald(){
        super();
        transparency = DEFAULT_TRANSPARENCY;
    }
    public Emerald(double weight, double cost, boolean transparency ) {
        super(weight,cost);
        this.transparency = transparency;
    }

    public boolean getTransparency() {
        return transparency;
    }

    public void setTransparency(boolean transparency) {
        this.transparency = transparency;
    }

    @Override
    public String toString() {
        return "Weight: " + getWeight() + "\nCost: " + getCost() + "\nTtansparency: " + transparency;
    }
}

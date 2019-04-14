package by.bntu.fitr.poisit.tarazenko.model.data;

import by.bntu.fitr.poisit.tarazenko.model.exception.ArrayDimensionException;
import by.bntu.fitr.poisit.tarazenko.model.exception.InvalidValueException;
import by.bntu.fitr.poisit.tarazenko.model.exception.NullException;

public class Array {
    private static final int DEFAULT_SIZE = 5;
    private static final int NULL_LENGTH = 0;

    private static final String NULL_ARRAY_EXCEPTION_MESSAGE = "Null array!";
    private static final String  DIMENSION_EXCEPTION_MESSAGE = "Index out of range!";

    private double[] array;

    public Array() {
        array = new double[DEFAULT_SIZE];
    }


    public Array(double[] array)throws NullException{
        checkNullArray(array);
        this.array = array;

    }

    public Array(int size) throws InvalidValueException{
        checkForPositive(size);
        array = new double[size];
    }

    public int getSize() {
        return array.length;
    }

    public void setElement(int index, double value)throws InvalidValueException {
        checkForPositive(index);
        if(index < array.length)
            array[index] = value;
    }

    public double getElement(int index) throws ArrayDimensionException{
        checkRange(index);
        return array[index];
    }

    private void checkRange(int index) throws ArrayDimensionException{
        if (index < 0 || index >= getSize()) {
            throw new ArrayDimensionException(DIMENSION_EXCEPTION_MESSAGE);
        }
    }

    private void checkNullArray(double[] array) throws NullException {
        if (array == null) {
            throw new NullException(NULL_ARRAY_EXCEPTION_MESSAGE);
        }
    }

    private void checkForPositive(int value) throws InvalidValueException {
        if (value < 0) {
            throw new InvalidValueException();
        }
    }


    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.getSize(); i++) {
            builder.append(array[i]).append(" ");
        }
        return builder.toString();
    }
}

package by.bntu.fitr.poisit.tarazenko.task5.model.entity;

import by.bntu.fitr.poisit.tarazenko.task5.model.exception.ArrayDimensionException;
import by.bntu.fitr.poisit.tarazenko.task5.model.exception.NullException;

import java.util.Arrays;

public class Necklace {

    public final int DEFAULT_COUNT = 0;

    private static final String DIMENSION_EXCEPTION_MESSAGE = "Wrong array dimension!";
    private static final String NULL_OBJECT_EXCEPTION_MESSAGE = "Null object!";
    private static final String NULL_ARRAY_EXCEPTION_MESSAGE = "Null array!";


    private Stone[] stones;
    private int countStones;

    public Necklace() {
        stones = new Stone[0];
        countStones = DEFAULT_COUNT;
    }

    public Necklace(Stone... stones) {
        if (stones == null) {
            this.stones = new Stone[0];
            this.countStones = DEFAULT_COUNT;
        } else {
            this.stones = stones;
            this.countStones = stones.length;
        }
    }

    public int getSize() {
        return countStones;
    }

    public void addStone(Stone stone) throws NullException {
        checkNullObject(stone);
        stones = Arrays.copyOf(stones, stones.length + 1);
        stones[stones.length - 1] = stone;
        countStones++;
    }

    public Stone getStone(int index) throws ArrayDimensionException {
        checkRange(index);
        return stones[index];
    }

    private void checkRange(int index) throws ArrayDimensionException {
        if (index < 0 || index >= getSize()) {
            throw new ArrayDimensionException(DIMENSION_EXCEPTION_MESSAGE);
        }
    }

    private void checkNullArray(Stone[] array) throws NullException {
        if (array == null) {
            throw new NullException(NULL_ARRAY_EXCEPTION_MESSAGE);
        }
    }

    private void checkNullObject(Stone stone) throws NullException {
        if (stone == null) {
            throw new NullException(NULL_OBJECT_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public String toString() {
        StringBuilder necklace = new StringBuilder();
        for (int i = 0; i < countStones; i++)
            necklace.append(stones[i].toString());
        return necklace.toString();
    }
}

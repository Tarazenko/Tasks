package by.bntu.fitr.poisit.tarazenko.task5.model.logic;

import by.bntu.fitr.poisit.tarazenko.task5.model.entity.*;
import by.bntu.fitr.poisit.tarazenko.task5.model.exception.ArrayDimensionException;
import by.bntu.fitr.poisit.tarazenko.task5.model.exception.InvalidValueException;
import by.bntu.fitr.poisit.tarazenko.task5.model.exception.NullException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StonesWorkerTest {

    private Necklace necklace = new Necklace(new Diamond(5.5,1000,"Round"),
            new Emerald(4.5, 500, true),
            new Sapphire(3, 200, "Green"),
            new Emerald(4.5, 400, false));

    public StonesWorkerTest()throws NullException,InvalidValueException {
    }

    @Test
    public void calculateWeigth1() throws ArrayDimensionException, NullException {
        try{
            double result = StonesWorker.calculateWeigth(null);
            Assert.fail();
        }catch (NullException thrown){
            Assert.assertNotEquals("",thrown.getMessage());
        }
    }


    @Test
    public void calculateWeigth() throws ArrayDimensionException, NullException {
        double expected = 17.5;
        double result = StonesWorker.calculateWeigth(necklace);
        assertEquals(expected,result,0);
    }

    @Test
    public void calculateCost() throws ArrayDimensionException, NullException {
        double expected = 2100;
        double result = StonesWorker.calculateCost(necklace);
        assertEquals(expected,result,0);
    }

    @Test
    public void findTheMostExpensiveStone() throws ArrayDimensionException, NullException {
        Stone expected = necklace.getStone(0);
        Stone result = StonesWorker.findTheMostExpensiveStone(necklace);
        assertEquals(expected,result);
    }
}
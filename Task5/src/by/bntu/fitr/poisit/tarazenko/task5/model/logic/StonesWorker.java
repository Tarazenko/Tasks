package by.bntu.fitr.poisit.tarazenko.task5.model.logic;

import by.bntu.fitr.poisit.tarazenko.task5.model.entity.Necklace;
import by.bntu.fitr.poisit.tarazenko.task5.model.entity.Stone;
import by.bntu.fitr.poisit.tarazenko.task5.model.exception.ArrayDimensionException;
import by.bntu.fitr.poisit.tarazenko.task5.model.exception.NullException;

public class StonesWorker {

    private static final String NULL_EXCEPTION_MSG = "Null is not allowed!";

    private static void checkNull(Necklace necklace) throws NullException {
        if (necklace == null) {
            throw new NullException(NULL_EXCEPTION_MSG);
        }
    }

    public static double calculateWeigth(Necklace necklace) throws ArrayDimensionException,NullException {
        checkNull(necklace);
        double sumWeigth = 0;
        for(int i = 0; i < necklace.getSize(); i++){
            sumWeigth += necklace.getStone(i).getWeight();
        }
        return sumWeigth;
    }

    public static double calculateCost(Necklace necklace) throws ArrayDimensionException,NullException {
        checkNull(necklace);
        double sumCost = 0;
        for(int i = 0; i < necklace.getSize(); i++){
            sumCost += necklace.getStone(i).getCost();
        }
        return sumCost;
    }

    public static Stone findTheMostExpensiveStone(Necklace necklace) throws ArrayDimensionException,NullException {
        checkNull(necklace);
        Stone stone = necklace.getStone(0);
        for(int i = 1; i < necklace.getSize(); i++){
            if(necklace.getStone(i).getCost() > stone.getCost())
                stone = necklace.getStone(i);
        }
        return stone;
    }
}

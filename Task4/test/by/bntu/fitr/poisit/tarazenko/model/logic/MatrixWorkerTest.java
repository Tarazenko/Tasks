package by.bntu.fitr.poisit.tarazenko.model.logic;

import by.bntu.fitr.poisit.tarazenko.model.data.Array;
import by.bntu.fitr.poisit.tarazenko.model.exception.ArrayDimensionException;
import by.bntu.fitr.poisit.tarazenko.model.exception.InvalidValueException;
import by.bntu.fitr.poisit.tarazenko.model.exception.MatrixDimensionException;
import by.bntu.fitr.poisit.tarazenko.model.exception.NullException;
import org.junit.Assert;
import org.junit.Test;
import by.bntu.fitr.poisit.tarazenko.model.data.Matrix;

import static org.junit.Assert.*;

public class MatrixWorkerTest {
    private Matrix matrix1 = new Matrix(new double[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}});
    private Matrix matrix2 = new Matrix(new double[][]{
            {4, 1, 0},
            {4, 1, 8},
            {4, 1, 9}});

    public MatrixWorkerTest()
            throws InvalidValueException, ArrayDimensionException, NullException, MatrixDimensionException {

    }

    @Test
    public void noColumnWithLowerValue()
            throws InvalidValueException, ArrayDimensionException, NullException, MatrixDimensionException {
        assertEquals(-1, MatrixWorker.findLowerValueColumnMinComp(matrix1,1));
    }
    @Test
    public void firstColumnTest()
            throws InvalidValueException, ArrayDimensionException, NullException, MatrixDimensionException {
        assertEquals(1, MatrixWorker.findLowerValueColumnMinComp(matrix2,5));

    }
    @Test
    public void secondColumnTest()
            throws InvalidValueException, ArrayDimensionException, NullException, MatrixDimensionException {
        assertEquals(2, MatrixWorker.findLowerValueColumnMinComp(matrix2,10));
    }
    @Test
    public void nullMatrixTest()
            throws InvalidValueException, ArrayDimensionException, NullException, MatrixDimensionException {
        try{
            int result = MatrixWorker.findLowerValueColumnMinComp(null,10);
            Assert.fail();
        }catch (NullException thrown){
            Assert.assertNotEquals("",thrown.getMessage());
        }
       // assertEquals(-1, MatrixWorker.findLowerValueColumnMinComp(null,10));
    }
}
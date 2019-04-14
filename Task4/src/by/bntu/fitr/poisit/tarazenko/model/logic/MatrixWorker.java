package by.bntu.fitr.poisit.tarazenko.model.logic;

import by.bntu.fitr.poisit.tarazenko.model.data.Array;
import by.bntu.fitr.poisit.tarazenko.model.data.Matrix;
import by.bntu.fitr.poisit.tarazenko.model.exception.ArrayDimensionException;
import by.bntu.fitr.poisit.tarazenko.model.exception.InvalidValueException;
import by.bntu.fitr.poisit.tarazenko.model.exception.MatrixDimensionException;
import by.bntu.fitr.poisit.tarazenko.model.exception.NullException;

public class MatrixWorker {

    private static final String NULL_MATRIX_EXCEPTION_MESSAGE = "Null matrix!";

    public static int findLowerValueColumnMinComp(Matrix matrix, double value)
            throws MatrixDimensionException, InvalidValueException, NullException, ArrayDimensionException {
        checkNullMatrix(matrix);
        return findMinPos(findCompInLowerValueColumns(matrix,value));
    }

    private static Array findCompInLowerValueColumns(Matrix matrix, double value)
            throws NullException, InvalidValueException, MatrixDimensionException {
        Array columns = new Array(matrix.getCountColumns());
        for(int i = 0; i < columns.getSize(); i++)
            columns.setElement(i,Double.POSITIVE_INFINITY);
        for (int j = 0; j < matrix.getCountColumns(); j++) {
            boolean flag = false;
            double comp = 1;
            for (int i = 0; i < matrix.getCountRows(); i++) {
                comp *= matrix.getElement(i,j);
                if (matrix.getElement(i,j) > value) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                columns.setElement(j,comp);
            }
        }
        return columns;
    }

    private static int findMinPos(Array array) throws ArrayDimensionException {
        int pos = -1;
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < array.getSize(); i++) {
            if (array.getElement(i) < min) {
                min = array.getElement(i);
                pos = i;
            }
        }
        return pos;
    }

    private static void checkNullMatrix(Matrix matrix) throws NullException {
        if (matrix == null) {
            throw new NullException(NULL_MATRIX_EXCEPTION_MESSAGE);
        }
    }
}

package by.bntu.fitr.poisit.tarazenko.model.data;

import by.bntu.fitr.poisit.tarazenko.model.exception.InvalidValueException;
import by.bntu.fitr.poisit.tarazenko.model.exception.MatrixDimensionException;
import by.bntu.fitr.poisit.tarazenko.model.exception.NullException;

public class Matrix {

    private static final int DEFAULT_ROW = 5;
    private static final int DEFAULT_COLUMN = 5;
    private static final int NULL_LENGTH = 0;

    private static final String NULL_MATRIX_EXCEPTION_MESSAGE = "Null matrix!";
    private static final String  DIMENSION_EXCEPTION_MESSAGE = "Indexes out of range!";


    private double[][] matrix;

    public Matrix() {
        matrix = new double[DEFAULT_ROW][DEFAULT_COLUMN];
    }


    public Matrix(double[][] matrix) throws NullException {
        checkNullMatrix(matrix);
        this.matrix = matrix;

    }

    public Matrix(int rows, int columns) throws InvalidValueException {
        checkForPositive(rows);
        checkForPositive(columns);
        matrix = new double[rows][columns];
    }

    public Matrix(int size) throws InvalidValueException {
        this(size, size);
    }

    public int getCountRows() throws NullException {
        checkNullMatrix(this.matrix);
        return this.matrix.length;
    }

    public int getCountColumns() throws NullException{
        checkNullMatrix(this.matrix);
        return this.matrix[0].length;
    }

    public void setElement(int row, int column, double value)
            throws MatrixDimensionException, NullException {
        checkRange(row,column);
        matrix[row][column] = value;
    }

    public double getElement(int row, int column) throws MatrixDimensionException, NullException {
        checkRange(row,column);
        return matrix[row][column];
    }

    private void checkRange(int row, int column) throws MatrixDimensionException, NullException {
        if (row < 0 || column < 0 || row >= getCountRows() || column >= getCountColumns()) {
            throw new MatrixDimensionException(DIMENSION_EXCEPTION_MESSAGE);
        }
    }

    private void checkNullMatrix(double[][] matrix) throws NullException {
        if (matrix == null) {
            throw new NullException(NULL_MATRIX_EXCEPTION_MESSAGE);
        }
    }

    private void checkForPositive(int value) throws InvalidValueException {
        if (value < 0) {
            throw new InvalidValueException();
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                builder.append(matrix[i][j]).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}

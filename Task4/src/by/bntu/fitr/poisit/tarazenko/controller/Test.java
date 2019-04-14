/*package by.bntu.fitr.poisit.tarazenko.controller;

import by.bntu.fitr.poisit.tarazenko.model.data.Matrix;
import by.bntu.fitr.poisit.tarazenko.model.logic.MatrixWorker;

import java.util.Scanner;

public class Test {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double value = scanner.nextDouble();
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Matrix matrix = new Matrix(n,m);
        System.out.println("Items:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                matrix.setElement(i,j,scanner.nextDouble());
        System.out.println("Array: " + MatrixWorker.findCompInLowerValueColumns(matrix,value).toString());
        System.out.println(MatrixWorker.findLowerValueColumnMinComp(matrix,value));
    }

}*/

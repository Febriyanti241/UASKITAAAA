import java.util.Arrays;

public class contohMain {
    public static void main(String[] args) {

        int x = 10;
        System.out.println(x);

        Integer[][] A ={
            {1, 2, 3},
            {4, 5, 6},
            {7, 10, 11}
        };

        Integer[][] B ={
            {11, 10, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        Integer[][] C = new Integer[A.length][A[0].length];
        Integer[][] D = new Integer[A.length][B[0].length];

        GenericMatrixOctal matrix = new GenericMatrixOctal();
        Integer[][] resultAdd = matrix.addMatrix(A, B, C);
        Integer[][] resultMult = matrix.multiplyMatrix(A, B, D);

        System.out.println(Arrays.deepToString(resultAdd));
        System.out.println(Arrays.deepToString(resultMult));

    }
    
}

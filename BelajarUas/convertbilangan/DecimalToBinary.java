public class DecimalToBinary {
    public static void convert(int n) {
        int[] binaryNum = new int[100];
        int i = 0;

        while (n > 0) {
            binaryNum[i] = n % 2;
            n = n / 2;
            i++;
        }

        System.out.print("Biner: ");
        for (int j = i - 1; j >= 0; j--)
            System.out.print(binaryNum[j]);
        System.out.println();
    }
}

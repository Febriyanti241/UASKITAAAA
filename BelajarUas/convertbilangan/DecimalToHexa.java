public class DecimalToHexa {
    public static void convert(int n) {
        char[] hexaDigits = {'0','1','2','3','4','5','6','7',
                             '8','9','A','B','C','D','E','F'};
        char[] hexaNum = new char[100];
        int i = 0;

        while (n != 0) {
            int temp = n % 16;
            hexaNum[i] = hexaDigits[temp];
            n = n / 16;
            i++;
        }

        System.out.print("Hexa : ");
        for (int j = i - 1; j >= 0; j--)
            System.out.print(hexaNum[j]);
        System.out.println();
    }
}

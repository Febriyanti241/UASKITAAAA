public class BinaryToDecimal {
    public static void convert(String binaryStr) {
        int result = 0;
        int power = 0;

        for (int i = binaryStr.length() - 1; i >= 0; i--) {
            char digit = binaryStr.charAt(i);
            if (digit == '1') {
                result += Math.pow(2, power);
            }
            power++;
        }

        System.out.println("Desimal: " + result);
    }
}

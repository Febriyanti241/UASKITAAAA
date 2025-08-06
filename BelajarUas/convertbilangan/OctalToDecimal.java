public class OctalToDecimal {
    public static void convert(String octalStr) {
        int result = 0;
        int power = 0;

        for (int i = octalStr.length() - 1; i >= 0; i--) {
            char digit = octalStr.charAt(i);
            if (digit >= '0' && digit <= '7') {
                result += (digit - '0') * Math.pow(8, power);
                power++;
            } else {
                System.out.println("Bukan bilangan oktal yang valid.");
                return;
            }
        }

        System.out.println("Desimal: " + result);
    }
}

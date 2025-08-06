public class HexaToDecimal {
    public static void convert(String hexaStr) {
        int result = 0;
        int power = 0;

        for (int i = hexaStr.length() - 1; i >= 0; i--) {
            char digit = Character.toUpperCase(hexaStr.charAt(i));
            int value;

            if (digit >= '0' && digit <= '9') {
                value = digit - '0';
            } else if (digit >= 'A' && digit <= 'F') {
                value = digit - 'A' + 10;
            } else {
                System.out.println("Bukan bilangan heksadesimal yang valid.");
                return;
            }

            result += value * Math.pow(16, power);
            power++;
        }

        System.out.println("Desimal: " + result);
    }
}

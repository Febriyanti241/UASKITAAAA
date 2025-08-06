public class HexaToOctal {
    public static void convert(String hexaStr) {
        // Langkah 1: Hexa to Decimal
        int decimal = 0;
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

            decimal += value * Math.pow(16, power);
            power++;
        }

        // Langkah 2: Decimal to Octal
        StringBuilder octalResult = new StringBuilder();
        if (decimal == 0) {
            octalResult.append("0");
        } else {
            while (decimal != 0) {
                octalResult.insert(0, decimal % 8);
                decimal /= 8;
            }
        }

        System.out.println("Oktal: " + octalResult.toString());
    }
}

public class OctalToHexa {
    public static void convert(String octalStr) {
        // Langkah 1: Octal to Decimal
        int decimal = 0;
        int power = 0;
        for (int i = octalStr.length() - 1; i >= 0; i--) {
            char digit = octalStr.charAt(i);
            if (digit >= '0' && digit <= '7') {
                decimal += (digit - '0') * Math.pow(8, power);
                power++;
            } else {
                System.out.println("Bukan bilangan oktal yang valid.");
                return;
            }
        }

        // Langkah 2: Decimal to Hexa
        char[] hexaDigits = {'0','1','2','3','4','5','6','7',
                             '8','9','A','B','C','D','E','F'};
        StringBuilder hexaResult = new StringBuilder();

        if (decimal == 0) {
            hexaResult.append("0");
        } else {
            while (decimal != 0) {
                hexaResult.insert(0, hexaDigits[decimal % 16]);
                decimal /= 16;
            }
        }

        System.out.println("Hexa: " + hexaResult.toString());
    }
}

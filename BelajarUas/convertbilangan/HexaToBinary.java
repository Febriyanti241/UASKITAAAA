public class HexaToBinary {
    public static void convert(String hexaStr) {
        StringBuilder binaryResult = new StringBuilder();

        for (int i = 0; i < hexaStr.length(); i++) {
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

            String binPart = String.format("%4s", Integer.toBinaryString(value)).replace(' ', '0');
            binaryResult.append(binPart);
        }

        System.out.println("Biner: " + binaryResult.toString());
    }
}

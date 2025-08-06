public class OctalToBinary {
    public static void convert(String octalStr) {
        StringBuilder binaryResult = new StringBuilder();

        for (int i = 0; i < octalStr.length(); i++) {
            char digit = octalStr.charAt(i);
            if (digit >= '0' && digit <= '7') {
                int value = digit - '0';
                String binPart = String.format("%3s", Integer.toBinaryString(value)).replace(' ', '0');
                binaryResult.append(binPart);
            } else {
                System.out.println("Bukan bilangan oktal yang valid.");
                return;
            }
        }

        System.out.println("Biner: " + binaryResult.toString());
    }
}

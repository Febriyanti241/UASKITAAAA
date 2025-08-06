import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menu Konversi Bilangan ===");
            System.out.println("1. Desimal ke Biner, Oktal, Hexa");
            System.out.println("2. Biner ke Desimal");
            System.out.println("3. Oktal ke Desimal");
            System.out.println("4. Hexa ke Desimal");
            System.out.println("5. Oktal ke Biner");
            System.out.println("6. Hexa ke Biner");
            System.out.println("7. Oktal ke Hexa");
            System.out.println("8. Hexa ke Oktal");
            System.out.println("9. Keluar");
            System.out.print("Pilih: ");
            int pilihan = sc.nextInt();
            sc.nextLine(); // buang newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan bilangan desimal: ");
                    int des = sc.nextInt();
                    sc.nextLine();
                    DecimalToBinary.convert(des);
                    DecimalToOctal.convert(des);
                    DecimalToHexa.convert(des);
                    break;

                case 2:
                    System.out.print("Masukkan bilangan biner: ");
                    String bin = sc.nextLine();
                    BinaryToDecimal.convert(bin);
                    break;

                case 3:
                    System.out.print("Masukkan bilangan oktal: ");
                    String okt = sc.nextLine();
                    OctalToDecimal.convert(okt);
                    break;

                case 4:
                    System.out.print("Masukkan bilangan heksadesimal: ");
                    String hex = sc.nextLine();
                    HexaToDecimal.convert(hex);
                    break;

                case 5:
                    System.out.print("Masukkan bilangan oktal: ");
                    String okt2 = sc.nextLine();
                    OctalToBinary.convert(okt2);
                    break;

                case 6:
                    System.out.print("Masukkan bilangan heksadesimal: ");
                    String hex2 = sc.nextLine();
                    HexaToBinary.convert(hex2);
                    break;

                case 7:
                    System.out.print("Masukkan bilangan oktal: ");
                    String okt3 = sc.nextLine();
                    OctalToHexa.convert(okt3);
                    break;

                case 8:
                    System.out.print("Masukkan bilangan heksadesimal: ");
                    String hex3 = sc.nextLine();
                    HexaToOctal.convert(hex3);
                    break;

                case 9:
                    System.out.println("Program selesai.");
                    sc.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}

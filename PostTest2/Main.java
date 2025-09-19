
package PostTest2;
import java.util.Scanner;
import Service.Service;

public class Main {
    static Scanner Scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Service.initDaftarTiket();
        int pilihan = -1;

        do {
            Service.menuUtama();
            System.out.print("Pilih Menu: ");
            String input = Scanner.nextLine().trim();

            try {
                pilihan = Integer.parseInt(input);
                switch (pilihan) {
                    case 1:
                        Service.lihatTiket();
                        break;
                    case 2:
                        Service.tambahTiket();
                        break;
                    case 3:
                        Service.editTiket();
                        break;
                    case 4:
                        Service.hapusTiket();
                        break;
                    case 5:
                        Service.cariTiket();
                        break;
                    case 6:
                        System.out.println("Keluar dari program...");
                        break;
                    default:
                        System.out.println("Silahkan pilih pilihan yang valid!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Silahkan pilih pilihan yang valid!");
            }

        } while (pilihan != 6);

        Scanner.close();
    }
}
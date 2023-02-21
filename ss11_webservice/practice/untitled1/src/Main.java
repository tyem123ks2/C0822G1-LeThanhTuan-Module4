import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số n bất kì: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n*2-1; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j == 2*n - 2 || j == 0 || j == i) {
                    System.out.print("*  ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}

import java.util.Scanner;

public class 2C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter morning energy generation (kWh): ");
        double morning = scanner.nextDouble();

        System.out.print("Enter evening energy generation (kWh): ");
        double evening = scanner.nextDouble();

        double total = morning + evening;

        System.out.println("Total Energy Generated: " + total + " kWh");
        scanner.close();
    }
}

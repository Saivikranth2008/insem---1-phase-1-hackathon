import java.util.Scanner;

public class 2B {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner (System.in);

        // taking input from user using scanner class
        System.out.print("Enter energy generated in kWh: ");
        double energyGenerated = scanner.nextDouble();

        // Using if else statements 

         if ( energyGenerated >= 10.0) {
            System.out.println("Good energy Generated");

         } else {
            System.out.println("Low Energy Generation");

         }
            // closing scanner 
         scanner.close();

    }
}
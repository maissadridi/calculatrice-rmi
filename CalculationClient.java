import java.rmi.Naming;
import java.util.Scanner;

public class CalculationClient {
    public static void main(String[] args) {
        try {
            CalculationInterface remoteService = (CalculationInterface) Naming.lookup("//localhost/CalculationService");
            Scanner scanner = new Scanner(System.in);
            String choice;
            do {
                System.out.println("Enter operation code (+, -, *, /): ");
                choice = scanner.nextLine();
                System.out.println("Enter first operand: ");
                double x = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter second operand: ");
                double y = Double.parseDouble(scanner.nextLine());
                double result = 0;
                switch (choice) {
                    case "+":
                        result = remoteService.add(x, y);
                        break;
                    case "-":
                        result = remoteService.subtract(x, y);
                        break;
                    case "*":
                        result = remoteService.multiply(x, y);
                        break;
                    case "/":
                        result = remoteService.divide(x, y);
                        break;
                    default:
                        System.out.println("Invalid operation code.");
                        break;
                }
                System.out.println("Result: " + result);
                System.out.println("Do you want to continue (Y/N)? ");
                choice = scanner.nextLine();
            } while (choice.equalsIgnoreCase("Y"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

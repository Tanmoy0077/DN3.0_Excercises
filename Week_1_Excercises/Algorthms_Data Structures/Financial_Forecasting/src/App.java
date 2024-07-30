import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the inital value: ");
        double initialValue = scanner.nextDouble();
        System.out.println("Enter The annual growth rate: ");
        double annualGrowthRate = scanner.nextDouble();
        System.out.println("Enter the years : ");
        int years = scanner.nextInt();
        scanner.close();
        double futureValue = calculateFutureValueRecursive(initialValue, annualGrowthRate, years);
        System.out.println("The future value of the investment after " + years + " years is: Rs. " + futureValue);
    }
    public static double calculateFutureValueRecursive(double initialValue, double annualGrowthRate, int years) {
        if (years == 0) {
            return initialValue;
        }
        double previousValue = calculateFutureValueRecursive(initialValue, annualGrowthRate, years - 1);
        return previousValue * (1 + annualGrowthRate);
    }
}

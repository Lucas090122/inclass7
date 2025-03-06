import java.util.Scanner;

public class TripCostCalculator {
    public double cost(double distance, double fuelPrice) {
        int FUEL_CONSUMPTION = 5;
        return (distance / 100) * FUEL_CONSUMPTION * fuelPrice;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the distance of the trip in kilometers: ");
        double distance = scanner.nextDouble();
        System.out.println("Enter the price of the fuel per liter: ");
        double fuelPrice = scanner.nextDouble();

        TripCostCalculator tripCostCalculator = new TripCostCalculator();
        double cost = tripCostCalculator.cost(distance, fuelPrice);

        System.out.println("The cost of the trip is: " + cost + " euros.");
    }
}

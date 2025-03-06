import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TripCostCalculatorTest {

    @Test
    void testCostCalculation() {
        TripCostCalculator calculator = new TripCostCalculator();

        double distance = 200.0;
        double fuelPrice = 1.5;

        double expectedCost = 15.0;

        double actualCost = calculator.cost(distance, fuelPrice);

        assertEquals(expectedCost, actualCost, 0.001, "Trip cost calculation failed");
    }

    @Test
    void testZeroDistance() {
        TripCostCalculator calculator = new TripCostCalculator();

        double distance = 0.0;
        double fuelPrice = 1.5;

        double expectedCost = 0.0;
        double actualCost = calculator.cost(distance, fuelPrice);

        assertEquals(expectedCost, actualCost, 0.001, "Cost should be zero for zero distance");
    }

    @Test
    void testZeroFuelPrice() {
        TripCostCalculator calculator = new TripCostCalculator();

        double distance = 100.0;
        double fuelPrice = 0.0;

        double expectedCost = 0.0;
        double actualCost = calculator.cost(distance, fuelPrice);

        assertEquals(expectedCost, actualCost, 0.001, "Cost should be zero for zero fuel price");
    }
}

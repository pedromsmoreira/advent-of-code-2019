package DayOne;

public class FuelCalculator {
    int calculateRequiredFuelGivenMassOf(int mass){
        if (mass <= 0){
            return 0;
        }

        int DIVIDEND = 3;
        var quotient = mass / DIVIDEND;

        int AMOUNT_TO_SUBTRACT = 2;
        return quotient - AMOUNT_TO_SUBTRACT;
    }
}

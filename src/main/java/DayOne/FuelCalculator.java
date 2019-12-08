package DayOne;

class FuelCalculator {
    final int DIVIDEND = 3;
    final int AMOUNT_TO_SUBTRACT = 2;

    int calculateRequiredFuelGivenMassOf(int mass){
        return calculateFuelRequiredForModuleOf(mass, 0);
    }

    private int calculateFuelRequiredForModuleOf(int mass, int initialCounter) {
        var quotient = mass / DIVIDEND;

        if (quotient <= 1) {
            return initialCounter;
        }

        var fuel = quotient - AMOUNT_TO_SUBTRACT;

        return calculateFuelRequiredForModuleOf(fuel, initialCounter + fuel);
    }
}

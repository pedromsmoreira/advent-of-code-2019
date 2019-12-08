package DayOne;

import java.util.List;

public class FuelCounterUpper {

    private FuelCalculator calculator;

    public FuelCounterUpper(FuelCalculator calculator){
        this.calculator = calculator;
    }

    int calculateTotalModulesFuelRequired(List<Module> modules){
        var total = 0;
        for (var module: modules) {
            total += this.calculator.calculateRequiredFuelGivenMassOf(module.getMass());
        }

        return total;
    }
}


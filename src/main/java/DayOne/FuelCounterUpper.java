package DayOne;

import java.util.List;

class FuelCounterUpper {

    private FuelCalculator calculator;

    FuelCounterUpper(FuelCalculator calculator){
        this.calculator = calculator;
    }

    int calculateTotalModulesFuelRequired(List<Module> modules){
        var total = 0;
        for (var module: modules) {
            total += calculator.calculateRequiredFuelGivenMassOf(module.getMass());
        }

        return total;
    }
}


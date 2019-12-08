package DayOne;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

        /*
            Santa has become stranded at the edge of the Solar System while delivering presents to other planets!
            To accurately calculate his position in space, safely align his warp drive, and return to Earth in time to save Christmas,
            he needs you to bring him measurements from fifty stars.
        ​
            Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar;
            the second puzzle is unlocked when you complete the first.
            Each puzzle grants one star. Good luck!
        ​
            The Elves quickly load you into a spacecraft and prepare to launch.
        ​
            At the first Go / No Go poll, every Elf is Go until the Fuel Counter-Upper. They haven't determined the amount of fuel required yet.
        ​
            Fuel required to launch a given module is based on its mass.
            Specifically, to find the fuel required for a module,
            take its mass, divide by three, round down, and subtract 2.
        ​
            For example:
        ​
            For a mass of 12, divide by 3 and round down to get 4, then subtract 2 to get 2.
            For a mass of 14, dividing by 3 and rounding down still yields 4, so the fuel required is also 2.
            For a mass of 1969, the fuel required is 654.
            For a mass of 100756, the fuel required is 33583.
            The Fuel Counter-Upper needs to know the total fuel requirement.
            To find it, individually calculate the fuel needed for the mass of each module (your puzzle input), then add together all the fuel values.
        ​
            What is the sum of the fuel requirements for all of the modules on your spacecraft?
         */

class Day1Test {

    @Test
    void calculateTotalModulesFuelRequired_GivenTwoModulesWithMassOfFour_Should_Return_4(){
        // Arrange
        var modules = new ArrayList<Module>();
        modules.add(new Module(12));
        modules.add(new Module(12));

        var sut = new FuelCounterUpper(new FuelCalculator());

        var expectedTotalFuel = 4;

        // Act
        var actualTotalFuel = sut.calculateTotalModulesFuelRequired(modules);

        // Assert
        assertEquals(expectedTotalFuel, actualTotalFuel);
    }

    @Test
    void calculateRequiredFuelGivenMassOf_12_should_return_2() {
        // Arrange
        var module = new FuelCalculator();
        var expectedRequiredFuel = 2;

        // Act
        var actualRequiredFuel = module.calculateRequiredFuelGivenMassOf(12);

        // Assert
        assertEquals(expectedRequiredFuel, actualRequiredFuel);
    }

    @Test
    void calculateRequiredFuelGivenMassOf_14_should_return_2() {
        // Arrange
        var module = new FuelCalculator();
        var expectedRequiredFuel = 2;

        // Act
        var actualRequiredFuel = module.calculateRequiredFuelGivenMassOf(14);

        // Assert
        assertEquals(expectedRequiredFuel, actualRequiredFuel);
    }

    @Test
    void calculateRequiredFuelGivenMassOf_1969_should_return_966() {
        // Arrange
        var module = new FuelCalculator();
        var expectedRequiredFuel = 966;

        // Act
        var actualRequiredFuel = module.calculateRequiredFuelGivenMassOf(1969);

        // Assert
        assertEquals(expectedRequiredFuel, actualRequiredFuel);
    }

    @Test
    void calculateRequiredFuelGivenMassOf_100756_should_return_50346() {
        // Arrange
        var module = new FuelCalculator();
        var expectedRequiredFuel = 50346;

        // Act
        var actualRequiredFuel = module.calculateRequiredFuelGivenMassOf(100756);

        // Assert
        assertEquals(expectedRequiredFuel, actualRequiredFuel);
    }
}
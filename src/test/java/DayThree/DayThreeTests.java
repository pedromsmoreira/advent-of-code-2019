package DayThree;
/*
--- Day 3: Crossed Wires ---
The gravity assist was successful, and you're well on your way to the Venus refuelling station. During the rush back on Earth,
the fuel management system wasn't completely installed, so that's next on the priority list.

Opening the front panel reveals a jumble of wires. Specifically, two wires are connected to a central port and extend outward on a grid.
You trace the path each wire takes as it leaves the central port, one wire per line of text (your puzzle input).

The wires twist and turn, but the two wires occasionally cross paths. To fix the circuit, you need to find the intersection
point closest to the central port. Because the wires are on a grid, use the Manhattan distance for this measurement.
While the wires do technically cross right at the central port where they both start, this point does not count,
nor does a wire count as crossing with itself.

For example, if the first wire's path is R8,U5,L5,D3, then starting from the central port (o), it goes right 8, up 5, left 5, and finally down 3:

        ...........
        ...........
        ...........
        ....+----+.
        ....|....|.
        ....|....|.
        ....|....|.
        .........|.
        .o-------+.
        ...........
Then, if the second wire's path is U7,R6,D4,L4, it goes up 7, right 6, down 4, and left 4:

        ...........
        .+-----+...
        .|.....|...
        .|..+--X-+.
        .|..|..|.|.
        .|.-X--+.|.
        .|..|....|.
        .|.......|.
        .o-------+.
        ...........
These wires cross at two locations (marked X), but the lower-left one is closer to the central port: its distance is 3 + 3 = 6.

Here are a few more examples:

R75,D30,R83,U83,L12,D49,R71,U7,L72
U62,R66,U55,R34,D71,R55,D58,R83 = distance 159
R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51
U98,R91,D20,R16,D67,R40,U7,R15,U6,R7 = distance 135
What is the Manhattan distance from the central port to the closest intersection?
 */


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayThreeTests {

    @Test
    void GivenLinesR75AndU62_calculateManhattanDistance_ShouldBe159(){
        // Arrange
        var calculator = new ManhattanCalculator();
        var wire1 = new String[] {"R75","D30","R83","U83","L12","D49","R71","U7","L72"};
        var wire2 = new String[] {"U62","R66","U55","R34","D71","R55","D58","R83"};
        var expectedDistance = 159;

        // Act
        var distance = calculator.calculateWiresManhattanDistance(wire1, wire2);

        // Assert
        assertEquals(expectedDistance, distance);
    }

    @Test
    void GivenLinesR98AndU98_calculateManhattanDistance_ShouldBe135(){
        // Arrange
        var calculator = new ManhattanCalculator();
        var wire1 = new String[] {"R98","U47","R26","D63","R33","U87","L62","D20","R33","U53","R51"};
        var wire2 = new String[] {"U98","R91","D20","R16","D67","R40","U7","R15","U6","R7"};
        var expectedDistance = 135;

        // Act
        var distance = calculator.calculateWiresManhattanDistance(wire1, wire2);

        // Assert
        assertEquals(expectedDistance, distance);
    }

    @Test
    void GivenLinesR8AndU7_calculateManhattanDistance_ShouldBe6(){
        // Arrange
        var calculator = new ManhattanCalculator();
        var wire1 = new String[] {"R8","U5","L5","D3"};
        var wire2 = new String[] {"U7","R6","D4","L4"};
        var expectedDistance = 6;

        // Act
        var distance = calculator.calculateWiresManhattanDistance(wire1, wire2);

        // Assert
        assertEquals(expectedDistance, distance);
    }

    @Test
    void GivenLinesR8AndU7_calculateLeastStepsTaken_ShouldBe30(){
        // Arrange
        var calculator = new ManhattanCalculator();
        var wire1 = new String[] {"R8","U5","L5","D3"};
        var wire2 = new String[] {"U7","R6","D4","L4"};
        var expectedSteps = 30;

        // Act
        var steps = calculator.calculateLeastStepsTaken(wire1, wire2);

        // Assert
        assertEquals(expectedSteps, steps);
    }

    @Test
    void GivenLinesR75AndU62_calculateLeastStepsTaken_ShouldBe610(){
        // Arrange
        var calculator = new ManhattanCalculator();
        var wire1 = new String[] {"R75","D30","R83","U83","L12","D49","R71","U7","L72"};
        var wire2 = new String[] {"U62","R66","U55","R34","D71","R55","D58","R83"};
        var expectedSteps = 610;

        // Act
        var steps = calculator.calculateLeastStepsTaken(wire1, wire2);

        // Assert
        assertEquals(expectedSteps, steps);
    }

    @Test
    void GivenLinesR98AndU98_calculateLeastStepsTaken_ShouldBe410(){
        // Arrange
        var calculator = new ManhattanCalculator();
        var wire1 = new String[] {"R98","U47","R26","D63","R33","U87","L62","D20","R33","U53","R51"};
        var wire2 = new String[] {"U98","R91","D20","R16","D67","R40","U7","R15","U6","R7"};
        var expectedSteps = 410;

        // Act
        var steps = calculator.calculateLeastStepsTaken(wire1, wire2);

        // Assert
        assertEquals(expectedSteps, steps);
    }
}

package DayThree;


import java.io.*;
import java.util.ArrayList;

public class DayThree {
    public static void main(String[] args) throws IOException {
        // read file
        var fileName = System.getProperty("user.dir") + "/day-three.txt";
        var file = new File(fileName);
        var fileInputStream = new FileInputStream(file);
        var inputStreamReader = new InputStreamReader(fileInputStream);
        var buffReader = new BufferedReader(inputStreamReader);

        String line;
        var wires = new ArrayList<String>();
        while((line = buffReader.readLine()) != null) {
            wires.add(line);
        }

        var wire1 = wires.get(0).split(",");
        var wire2 = wires.get(1).split(",");

        // puzzle act
        var manhattanCalculator = new ManhattanCalculator();

        var distance = manhattanCalculator.calculateWiresManhattanDistance(wire1, wire2);
        System.out.println(String.format("Day 3 Part 1 -> Distance is: %s", distance));

        var steps = manhattanCalculator.calculateLeastStepsTaken(wire1, wire2);
        System.out.println(String.format("Day 3 Part 2 -> Minimum Steps are: %s", steps));

    }
}


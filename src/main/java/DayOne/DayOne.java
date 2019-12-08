package DayOne;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Stream;

public class DayOne {
    public static void main(String[] args) throws IOException {
        // read file
        var fileName = System.getProperty("user.dir") + "/day-one.txt";
        var file = new File(fileName);
        var fileInputStream = new FileInputStream(file);
        var inputStreamReader = new InputStreamReader(fileInputStream);
        var buffReader = new BufferedReader(inputStreamReader);

        var fuelCounterUpper = new FuelCounterUpper(new FuelCalculator());

        String line;
        var modules = new ArrayList<Module>();
        while((line = buffReader.readLine()) != null){
            modules.add(new Module(Integer.parseInt(line)));
        }

        var result = fuelCounterUpper.calculateTotalModulesFuelRequired(modules);

        System.out.println(String.format("Result for input: %s", result));
    }
}

package DayTwo;

import java.io.*;
import java.util.stream.Stream;

public class DayTwo {
    public static void main(String[] args) throws IOException {
        // read file
        var fileName = System.getProperty("user.dir") + "/day-two.txt";
        var file = new File(fileName);
        var fileInputStream = new FileInputStream(file);
        var inputStreamReader = new InputStreamReader(fileInputStream);
        var buffReader = new BufferedReader(inputStreamReader);

        String line;
        var stateRestorer = new StateRestorer();
        while((line = buffReader.readLine()) != null){
            var parsedResult = Stream
                    .of(line.split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // for each line compute state
            var result = stateRestorer.restore(parsedResult);

            System.out.println(String.format("Result for input: %s", result[0]));
        }
    }
}

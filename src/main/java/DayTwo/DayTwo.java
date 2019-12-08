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
            var copyParsedResult = parsedResult.clone();
            copyParsedResult[1] = 12;
            copyParsedResult[2] = 2;

            var puzzle1Result = stateRestorer.restore(copyParsedResult);
            System.out.println(String.format("Day 2 P1 Result: %s", puzzle1Result[0]));

            var puzzle2Result = stateRestorer.restoreWithFinalResult(parsedResult, 19690720);
            System.out.println(String.format("Day 2 P2 Result: %s", puzzle2Result));
        }
    }
}

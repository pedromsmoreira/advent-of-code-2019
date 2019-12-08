package DayTwo;

import java.io.*;
import java.util.stream.Stream;

class StateRestorer {

    public static void main(String[] args) throws IOException {
        // read file
        var fileName = System.getProperty("user.dir") + "/day-two.txt";
        var file = new File(fileName);
        var fileInputStream = new FileInputStream(file);
        var inputStreamReader = new InputStreamReader(fileInputStream);
        var buffReader = new BufferedReader(inputStreamReader);

        String line;
        while((line = buffReader.readLine()) != null){
            var parsedResult = Stream
                    .of(line.split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // for each line compute state
            var result = restore(parsedResult);

            System.out.println(String.format("Result for input: %s", result[0]));
        }
    }


    static int[] restore(int[] lastState){
        var currentOperationPosition = 0;
        var copy = lastState.clone();

        final int HALT = 99;
        final int SUM = 1;
        final int MULTIPLICATION = 2;

        while (copy[currentOperationPosition] != HALT){

            var result = 0;
            var operationToExecute = copy[currentOperationPosition];
            var firstValuePosition = copy[currentOperationPosition+1];
            var secondValuePosition = copy[currentOperationPosition+2];
            var resultPlacementPosition = copy[currentOperationPosition+3];

            switch (operationToExecute){
                case SUM:
                    result = sum(copy[firstValuePosition], copy[secondValuePosition]);
                    break;
                case MULTIPLICATION:
                    result = multiplication(copy[firstValuePosition], copy[secondValuePosition]);
                    break;
            }
            copy[resultPlacementPosition] = result;
            currentOperationPosition += 4;
        }

        return copy;
    }

    private static int sum(int val1, int val2) {
        return val1 + val2;
    }

    private static int multiplication(int val, int multiplier){
        return val * multiplier;
    }
}

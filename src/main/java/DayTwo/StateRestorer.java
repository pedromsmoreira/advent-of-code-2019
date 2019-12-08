package DayTwo;

class StateRestorer {
    final int HALT = 99;
    final int SUM = 1;
    final int MULTIPLICATION = 2;

    int restoreWithFinalResult(int[]input, int expectedFinalResult){
        for (int noun = 0; noun <= 99; noun++){
            for (int verb = 0; verb <= 99; verb++){
                var copy = input.clone();
                copy[1] = noun;
                copy[2] = verb;
                var result = restore(copy);
                if (result[0] == expectedFinalResult) {
                    return 100 * noun + verb;
                }
            }
        }

        return 0;
    }

    int[] restore(int[] lastState){
        var currentOperationPosition = 0;
        var copy = lastState.clone();

        while (copy[currentOperationPosition] != HALT){

            var operationToExecute = copy[currentOperationPosition];
            var firstValuePosition = copy[currentOperationPosition+1];
            var secondValuePosition = copy[currentOperationPosition+2];
            var placeResultInPosition = copy[currentOperationPosition+3];

            var result = chooseOperation(operationToExecute, copy[firstValuePosition], copy[secondValuePosition]);

            copy[placeResultInPosition] = result;
            currentOperationPosition += 4;
        }

        return copy;
    }

    private int chooseOperation(int opcode, int arg1, int arg2){
        var result = 0;
        switch(opcode) {
            case SUM:
                result = sum(arg1, arg2);
                break;
            case MULTIPLICATION:
                result = multiplication(arg1, arg2);
                break;
        }

        return result;
    }

    private static int sum(int val1, int val2) {
        return val1 + val2;
    }

    private static int multiplication(int val, int multiplier){
        return val * multiplier;
    }
}

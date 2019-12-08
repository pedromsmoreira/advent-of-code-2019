package DayTwo;

class StateRestorer {

    int[] restore(int[] lastState){
        var currentOperationPosition = 0;

        final int HALT = 99;
        final int SUM = 1;
        final int MULTIPLICATION = 2;

        while (lastState[currentOperationPosition] != HALT){

            var result = 0;
            var operationToExecute = lastState[currentOperationPosition];
            var firstValuePosition = lastState[currentOperationPosition+1];
            var secondValuePosition = lastState[currentOperationPosition+2];
            var resultPlacementPosition = lastState[currentOperationPosition+3];

            switch (operationToExecute){
                case SUM:
                    result = sum(lastState[firstValuePosition], lastState[secondValuePosition]);
                    break;
                case MULTIPLICATION:
                    result = multiplication(lastState[firstValuePosition], lastState[secondValuePosition]);
                    break;
            }
            lastState[resultPlacementPosition] = result;
            currentOperationPosition += 4;
        }

        return lastState;
    }

    private static int sum(int val1, int val2) {
        return val1 + val2;
    }

    private static int multiplication(int val, int multiplier){
        return val * multiplier;
    }
}

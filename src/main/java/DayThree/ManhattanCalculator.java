package DayThree;

import java.util.ArrayList;
import java.util.List;

class ManhattanCalculator{
    private Coordinate startingPoint = new Coordinate(0,0);

    int calculateWiresManhattanDistance(String[] wire1, String[] wire2){

        var wire1Movements = this.getWireMovements(wire1);
        var wire2Movements = this.getWireMovements(wire2);

        var wire1Coordinates = this.getAllCoordinates(this.startingPoint, wire1Movements);
        var wire2Coordinates = this.getAllCoordinates(this.startingPoint, wire2Movements);

        var intersections = this.extractIntersections(wire1Coordinates, wire2Coordinates);

        return calculateMinimumDistance(intersections);
    }

    int calculateLeastStepsTaken(String[] wire1, String[] wire2) {
        var wire1Movements = this.getWireMovements(wire1);
        var wire2Movements = this.getWireMovements(wire2);

        var wire1Coordinates = this.getAllCoordinates(this.startingPoint, wire1Movements);
        var wire2Coordinates = this.getAllCoordinates(this.startingPoint, wire2Movements);

        var intersections = this.extractIntersections(wire1Coordinates, wire2Coordinates);

        // since we have coordinates list, we can get the steps they took by getting the coordinate position in the array
        return calculateMinimumStepsFromIntersections(wire1Coordinates, wire2Coordinates, intersections);
    }

    private int calculateMinimumStepsFromIntersections(List<Coordinate> wire1Coordinates, List<Coordinate> wire2Coordinates, List<Coordinate> intersections) {
        var minimumCombinedSteps = Integer.MAX_VALUE;
        for (var intersection : intersections) {

            var minimumStepsWire1 = 0;
            // add one extra step to take into account position (0,0)
            var stepsWire1 = wire1Coordinates.indexOf(intersection) + 1;
            minimumStepsWire1 += stepsWire1;

            var minimumStepsWire2 = 0;
            // add one extra step to take into account position (0,0)
            var stepsWire2 = wire2Coordinates.indexOf(intersection) + 1;
            minimumStepsWire2 += stepsWire2;

            var combinedSteps = minimumStepsWire1 + minimumStepsWire2;

            if (combinedSteps < minimumCombinedSteps){
                minimumCombinedSteps = combinedSteps;
            }
        }

        return minimumCombinedSteps;
    }

    private int calculateMinimumDistance(List<Coordinate> intersections) {
        var minDistance = Integer.MAX_VALUE;
        for (var intersection : intersections) {
            var distance = this.calculateDistance(this.startingPoint, intersection);

            if (distance < minDistance){
                minDistance = distance;
            }
        }
        return minDistance;
    }

    private List<Coordinate> extractIntersections(List<Coordinate> wire1Coordinates, List<Coordinate> wire2Coordinates) {
        var intersections = new ArrayList<Coordinate>();

       for (var wire2Coordinate: wire2Coordinates){
            // improvement -> check if index exists
            // if yes -> add if not skip
            var coordinateExists = wire1Coordinates.indexOf(wire2Coordinate);
            if (coordinateExists > -1){
                intersections.add(wire2Coordinate);
            }
        }

        return intersections;
    }

    private List<Coordinate> getAllCoordinates(Coordinate startingPoint, List<Movement> movements) {
        var allCoordinates = new ArrayList<Coordinate>();

        var stopPoint = startingPoint;
        for (var movement : movements) {
            switch (movement.getDirection()){
                case "R":
                    moveRight(allCoordinates, stopPoint, movement);
                    stopPoint = this.getLastInsertedCoordinate(allCoordinates);
                    break;
                case "U":
                    moveUp(allCoordinates, stopPoint, movement);
                    stopPoint = this.getLastInsertedCoordinate(allCoordinates);
                    break;
                case "D":
                    moveDown(allCoordinates, stopPoint, movement);
                    stopPoint = this.getLastInsertedCoordinate(allCoordinates);
                    break;
                case "L":
                    moveLeft(allCoordinates, stopPoint, movement);
                    stopPoint = this.getLastInsertedCoordinate(allCoordinates);
                    break;
            }
        }

        return allCoordinates;
    }

    private void moveLeft(ArrayList<Coordinate> allCoordinates, Coordinate stopPoint, Movement movement) {
        for (int d = 1; d <= movement.getDistance(); d++) {
            var updatedXPosition = stopPoint.getxPosition() - d;
            var lastCoordinate = new Coordinate(updatedXPosition, stopPoint.getyPosition());
            allCoordinates.add(lastCoordinate);
        }
    }

    private void moveDown(ArrayList<Coordinate> allCoordinates, Coordinate stopPoint, Movement movement) {
        for (int d = 1; d <= movement.getDistance(); d++) {
            var updatedYPosition = stopPoint.getyPosition() - d;
            var lastCoordinate = new Coordinate(stopPoint.getxPosition(), updatedYPosition);
            allCoordinates.add(lastCoordinate);
        }
    }

    private void moveUp(ArrayList<Coordinate> allCoordinates, Coordinate stopPoint, Movement movement) {
        for (int d = 1; d <= movement.getDistance(); d++) {
            var updatedYPosition = stopPoint.getyPosition() + d;
            var lastCoordinate = new Coordinate(stopPoint.getxPosition(), updatedYPosition);
            allCoordinates.add(lastCoordinate);
        }
    }

    private void moveRight(ArrayList<Coordinate> allCoordinates, Coordinate stopPoint, Movement movement) {
        for (int d = 1; d <= movement.getDistance(); d++) {
            var updatedXPosition = stopPoint.getxPosition() + d;
            var lastCoordinate = new Coordinate(updatedXPosition, stopPoint.getyPosition());
            allCoordinates.add(lastCoordinate);
        }
    }

    private Coordinate getLastInsertedCoordinate(ArrayList<Coordinate> allCoordinates) {
        return allCoordinates.get(allCoordinates.size() - 1);
    }


    private List<Movement> getWireMovements(String[] wire) {
        var movements = new ArrayList<Movement>();
        for (var mov : wire) {
            var movement = Movement.create(mov);
            movements.add(movement);
        }
        return movements;
    }

    private int calculateDistance(Coordinate startingPoint, Coordinate intersection){
        return Math.abs(intersection.getxPosition() - startingPoint.getxPosition()) + Math.abs(intersection.getyPosition() - startingPoint.getyPosition());
    }
}


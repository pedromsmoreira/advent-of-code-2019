package DayThree;

class Movement{
    private String direction;
    private int distance;

    private Movement(String direction, int distance){
        this.direction = direction;
        this.distance = distance;
    }

    static Movement create(String movement){
        var charDirection = movement.charAt(0);
        var direction = Character.toString(charDirection);;
        var strDistance = movement.replaceAll("[A-z]+", "");
        var distance = Integer.parseInt(strDistance);
        return new Movement(direction, distance);
    }

    public String getDirection() {
        return direction;
    }

    public int getDistance() {
        return distance;
    }
}

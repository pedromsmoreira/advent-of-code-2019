package DayThree;

class Coordinate {
    private int xPosition;
    private int yPosition;

    Coordinate(int x, int y){
        this.xPosition = x;
        this.yPosition = y;
    }

    public int getyPosition() {
        return yPosition;
    }

    public int getxPosition() {
        return xPosition;
    }

    @Override
    public boolean equals(Object obj) {
        if( this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        var coord = (Coordinate) obj;
        return this.xPosition == coord.xPosition && this.yPosition == coord.yPosition;
    }
}

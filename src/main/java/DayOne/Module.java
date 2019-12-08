package DayOne;

public class Module {
    private int mass;
    private String name;

    public Module(String name, int mass){
        this.mass = mass;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMass() {
        return mass;
    }
}


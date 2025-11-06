package Genums;

public enum Direction {
    NORTH("North"), EAST("East"), SOUTH("South"), WEST("West");

    private final String label;

    Direction(String label){
        this.label = label;
    }

    @Override
    public String toString(){
        return label;
    }
}

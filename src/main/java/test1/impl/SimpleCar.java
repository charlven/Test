package test1.impl;

public class SimpleCar implements CarStrategy {
    private int x;
    private int y;
    private String orientation = "N";

    public SimpleCar(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(String command) {
        String op = command.substring(0, 1).toUpperCase();
        int offset = Integer.parseInt(command.substring(1));

        if (op.equals("N") || op.equals("S")) {
            y += offset;
        } else {
            x += offset;
        }

        orientation = op;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPositionX() {
        return x;
    }

    public int getPositionY() {
        return y;
    }

    @Override
    public String getOrientation() {
        return orientation;
    }
}

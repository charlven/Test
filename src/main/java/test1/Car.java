package test1;

import test1.impl.CarStrategy;

public class Car {
    private final CarStrategy strategy;
    Park park;

    public Car(CarStrategy strategy, Park park) {
        this.strategy = strategy;
        this.park = park;
    }

    public void move(String command) throws Exception {
        strategy.move(command);
        if (isIllegalPosition()) {
            throw new Exception("Invalid option.");
        }
    }

    public int getX() {
        return strategy.getPositionX();
    }

    public int getY() {
        return strategy.getPositionY();
    }

    public String getOrientation() {
        return strategy.getOrientation();
    }

    public boolean isIllegalPosition() {
        return strategy.getPositionX() < 0
                || strategy.getPositionY() < 0
                || strategy.getPositionX() > park.getWidth()
                || strategy.getPositionY() > park.getHeight();
    }
}

package test1.impl;

public interface CarStrategy  {
    void move(String command) throws Exception;

    int getPositionX();

    int getPositionY();

    String getOrientation();
}

package com.igor.patterns.factory.task;

public class TaskFactory {
    public static final  String SHOP = "SHOP";
    public static final  String PAINT = "PAINT";
    public static final  String DRIVE = "DRIVE";

    public final Task makeTask(final String task){
        switch (task){
            case SHOP:
                return new ShoppingTask("zakupy", "ziemniaki", 3);
            case PAINT:
                return new PaintingTask("malowanko", "black", "wall");
            case DRIVE:
                return new DrivingTask("jedziemy", "do babci", "car");
            default:
                return null;
        }

    }
}

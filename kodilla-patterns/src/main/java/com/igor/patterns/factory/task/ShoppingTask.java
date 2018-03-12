package com.igor.patterns.factory.task;

public class ShoppingTask implements Task {
    private String taskName;
    private String whatToBuy;
    double quantity;
    boolean executed = false;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;


    }

    @Override
    public String getTaskName() {
        return this.taskName;
    }

    @Override
    public void executeTask(){
        executed=true;
        System.out.println("Task:" + getTaskName() + " is executing");
    }

    @Override
    public boolean isTaskExecuted(){
        return  executed;
    }


}




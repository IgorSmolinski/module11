package com.igor.patterns.factory.task;

public class PaintingTask implements Task{
    String taskName;
    String color;
    String whatToPaint;
    boolean executed=false;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
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

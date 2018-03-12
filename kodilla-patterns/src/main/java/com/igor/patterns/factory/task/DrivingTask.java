package com.igor.patterns.factory.task;

public class DrivingTask implements Task{
    String taskName;
    String where;
    String using;
    boolean executed=false;


    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
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

package com.kodilla.patterns2.homework;

public class Mentor implements Observer {

    private int totalNumOfTasks;

    @Override
    public void update(StudentQueue queue) {
        System.out.println("New task from: " + queue.getStudentName() + "\n" +
                "Unchecked tasks: " + queue.getQueue().size() + ". Total number of tasks to check:" +
                ++totalNumOfTasks);
    }

   public void acceptTask(Task task){
        task.acceptTask();
        totalNumOfTasks--;
   }

    public int getTotalNumOfTasks() {
        return totalNumOfTasks;
    }
}

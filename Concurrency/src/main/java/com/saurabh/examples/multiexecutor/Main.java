package com.saurabh.examples.multiexecutor;

public class Main {
    public static void main(String[] args) {
        // Create some sample tasks
        Runnable task1 = () -> {
            System.out.println("Task 1 is running");
            try {
                Thread.sleep(1000); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task 1 is completed");
        };

        Runnable task2 = () -> {
            System.out.println("Task 2 is running");
            try {
                Thread.sleep(500); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task 2 is completed");
        };

        Runnable task3 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is executing Task 3");
                try {
                    Thread.sleep(700); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Task 2 is completed");
            }
        };

        // Add tasks to a list
        java.util.List<Runnable> tasks = new java.util.ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);

        // Create MultiExecutor and execute all tasks
        MultiExecutor multiExecutor = new MultiExecutor(tasks);
        multiExecutor.executeAll();
    }
}

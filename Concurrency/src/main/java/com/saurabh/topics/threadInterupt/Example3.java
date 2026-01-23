package com.saurabh.topics.threadInterupt;

import java.io.IOException;

public class Example3 {
    public static void main(String [] args) {
        Thread thread = new Thread(new WaitingForUserInput());
        thread.setName("InputWaitingThread");
        thread.start();
        // code will always be blocked on System.in.read() and will not respond to the interrupt
        // the only way to terminate this program is to provide the input 'q' from the console
        thread.interrupt();
    }

    private static class WaitingForUserInput implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    char input = (char) System.in.read(); // System.in.read() is a blocking call, it does not responds to the thread.interupt()
                    if(input == 'q') {
                        return;
                    }
                }
            } catch (IOException e) {
                System.out.println("An exception was caught " + e);
            };
        }
    }
}

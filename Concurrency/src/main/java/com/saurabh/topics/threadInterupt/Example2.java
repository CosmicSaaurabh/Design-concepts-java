package com.saurabh.topics.threadInterupt;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Example2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new LongComputationTask(new BigInteger("2"), new BigInteger("10")));
        thread.setDaemon(true);
        thread.start();
        thread.interrupt();

//        try {
//            Thread.sleep(3000); // Let the task run for a while
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Main thread is interrupting the computation thread.");
//        thread.interrupt(); // Interrupt the computation thread
    }

    public static class LongComputationTask implements Runnable {

        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }



        @Override
        public void run() {
            System.out.println(base + " ^ " + power + " = " + pow(base, power));
        }

        public static BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;
            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                // Check if the thread has been interrupted
//                if (Thread.currentThread().isInterrupted()) {
//                    System.out.println("Computation was interrupted at i = " + i);
//                    return BigInteger.ZERO; // or any other value indicating interruption
//                }
                System.out.println("Computing " + base + " ^ " + i);
                result = result.multiply(base);
            }

            return result;
        }
    }
}

package com.saurabh.topics.join;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example1 {
    public static void main(String[] args) {
        List<Long> numbers = Arrays.asList(0L, 10L, 100L);
        List<FactorialThread> threads = new ArrayList<>();

        for (Long number: numbers) {
            FactorialThread thread = new FactorialThread(number);
            threads.add(thread);
//            thread.start();
        }

        for (FactorialThread thread: threads) {
            thread.start();
        }

        // let's join immediately after starting all threads
        for (FactorialThread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        // very inefficient way to wait for threads to finish - busy waiting, instead of using join()
        for (int i  = 0; i < numbers.size(); i++) {
            FactorialThread thread = threads.get(i);
            if (thread.isFinished()) {
                System.out.println("Factorial of " + numbers.get(i) + " is " + thread.getResult());
            } else {
                System.out.println("The calculation for " + numbers.get(i) + " is still in progress. Waiting for it to complete...");
            }
        }
    }

    public static class FactorialThread extends Thread {
        private Long inputNumber;
        private BigInteger result = BigInteger.ZERO;
        private boolean isFinished = false;
        public FactorialThread(Long inputNumber) {
            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
            result = computeFactorial(inputNumber);
            isFinished = true;
        }

        public BigInteger computeFactorial(Long number) {
            BigInteger fact = BigInteger.ONE;

            for (long i = 2; i <= number; i++) {
                fact = fact.multiply(BigInteger.valueOf(i));
            }

            return fact;
        }

        public boolean isFinished() {
            return isFinished;
        }

        public BigInteger getResult() {
            return result;
        }
    }
}


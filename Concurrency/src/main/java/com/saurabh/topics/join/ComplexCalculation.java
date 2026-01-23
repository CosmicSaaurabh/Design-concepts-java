package com.saurabh.topics.join;

import java.math.BigInteger;

public class ComplexCalculation {
    public static void main(String[] args) throws InterruptedException {
        ComplexCalculation complexCalculation = new ComplexCalculation();
        BigInteger result = complexCalculation.calculateResult(
                new BigInteger("100"),
                new BigInteger("30"),
                new BigInteger("200"),
                new BigInteger("15")
        );
        System.out.println("Final Result: " +  result);
    }
    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) throws InterruptedException {
        BigInteger result = BigInteger.ZERO;
        /*
            Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
            Where each calculation in (..) is calculated on a different thread
        */
        PowerCalculatingThread thread1 = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread thread2 = new PowerCalculatingThread(base2, power2);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        result = result.add(thread1.getResult()).add(thread2.getResult());

        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
           /*
           Implement the calculation of result = base ^ power
           */
            System.out.println("Calculating " + base + " ^ " + power);
            for (Long i = 0L; i < power.longValue(); i++) {
                result = result.multiply(base);
            }

            System.out.println("Completed calculation of " + base + " ^ " + power + " = " + result);
        }

        public BigInteger getResult() { return result; }
    }
}
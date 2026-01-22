package com.saurabh.topics.thread_inheritence;

import java.util.List;
import java.util.Random;

public class ThreadInheritence {
    public static void main(String[] args) {
        Random random = new Random();

//        Vault vault = new Vault(random.nextInt(10000));
        Vault vault = new Vault(7999); // For testing purpose
        System.out.println("Secret code is: " + vault.getSecretCode());

        List<Thread> threads = List.of(
                new AscendingHackerThread(vault),
                new DescendingHackerThread(vault),
                new PoliceThread()
        );

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static class Vault {
        private int secretCode;
        public Vault(int secretCode) {
            this.secretCode = secretCode;
        }

        public boolean isCorrectCode(int code) throws InterruptedException {
            Thread.sleep(2);
            return this.secretCode == code;
        }

        public int getSecretCode() {
            return secretCode;
        }
    }

    public static abstract class HackerThread extends Thread {
        protected Vault vault;

        public HackerThread(Vault vault) {
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public void start() {
            System.out.println("Starting thread: " + this.getName());
            super.start();
        }
    }

    public static class AscendingHackerThread extends HackerThread {
        public AscendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for (int guess = 0; guess <= 9999; guess++) {
                try {
                    if (vault.isCorrectCode(guess)) {
                        System.out.println(this.getName() + " guessed the code " + guess);
                        System.exit(0);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static class DescendingHackerThread extends HackerThread {
        public DescendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for (int guess = 9999; guess >= 0; guess--) {
                try {
                    if (vault.isCorrectCode(guess)) {
                        System.out.println(this.getName() + " guessed the code " + guess);
                        System.exit(0);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static class PoliceThread extends Thread {
        @Override
        public void run() {
            for (int i = 10; i > 0; i--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Time left: " + i + " seconds");
            }
            System.out.println("Game over for you hackers!");
            System.exit(0);
        }
    }
}

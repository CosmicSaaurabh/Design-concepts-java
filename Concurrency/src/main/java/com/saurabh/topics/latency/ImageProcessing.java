package com.saurabh.topics.latency;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ImageProcessing {
    public static final String IMAGE_FILE_LOCATION = "image.jpg";
    public static final String OUTPUT_FILE_LOCATION = "output.jpg";
    public static void main(String[] args) throws IOException {
        System.out.println(IMAGE_FILE_LOCATION);
        InputStream is = ImageProcessing.class
                .getClassLoader()
                .getResourceAsStream(IMAGE_FILE_LOCATION);

        if (is == null) {
            throw new IllegalArgumentException("Image not found on classpath: " + IMAGE_FILE_LOCATION);
        }
        BufferedImage originalImage = ImageIO.read(is);
        BufferedImage resultImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);

        long startTime = System.currentTimeMillis();
//        recolorSingleThreaded(originalImage, resultImage);
        int cores = Runtime.getRuntime().availableProcessors();
        int numberOfThreads = cores;
        recolorMultithreaded(originalImage, resultImage, numberOfThreads);
        long endTime = System.currentTimeMillis();

        long duration = endTime - startTime;

        File outputFile = new File(OUTPUT_FILE_LOCATION);
        ImageIO.write(resultImage, "jpg", outputFile);

        System.out.println(String.valueOf(duration));
    }

    public static void recolorMultithreaded(BufferedImage originalImage, BufferedImage resultImage, int numberOfThreads) {
        List<Thread> threads = new ArrayList<>();
        int width = originalImage.getWidth();
        int height = originalImage.getHeight() / numberOfThreads;

        for(int i = 0; i < numberOfThreads ; i++) {
            final int threadMultiplier = i;

            Thread thread = new Thread(() -> {
                int xOrigin = 0 ;
                int yOrigin = height * threadMultiplier;

                recolorImage(originalImage, resultImage, xOrigin, yOrigin, width, height);
            });

            threads.add(thread);
        }

        for(Thread thread : threads) {
            thread.start();
        }

        for(Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
        }
    }

    public static void recolorSingleThreaded(BufferedImage originalImage, BufferedImage resultImage) {
        recolorImage(originalImage, resultImage, 0, 0, originalImage.getWidth(), originalImage.getHeight());
    }

    public static void recolorImage(BufferedImage originalImage, BufferedImage resultImage, int leftCorner, int topCorner,
                                    int width, int height) {
        for(int x = leftCorner ; x < leftCorner + width && x < originalImage.getWidth() ; x++) {
            for(int y = topCorner ; y < topCorner + height && y < originalImage.getHeight() ; y++) {
                recolorPixel(originalImage, resultImage, x , y);
            }
        }
    }

    public static void recolorPixel(BufferedImage originalImage, BufferedImage resultImage, int x, int y) {
        int rgb = originalImage.getRGB(x, y);

        int red = getRed(rgb);
        int green = getGreen(rgb);
        int blue = getBlue(rgb);

        int newRed;
        int newGreen;
        int newBlue;

        if(isShadeOfGray(red, green, blue)) {
            newRed = Math.min(255, red + 10);
            newGreen = Math.max(0, green - 80);
            newBlue = Math.max(0, blue - 20);
        } else {
            newRed = red;
            newGreen = green;
            newBlue = blue;
        }
        int newRGB = createRGB(newRed, newGreen, newBlue);
        resultImage.setRGB(x, y, newRGB);
    }

    public static boolean isShadeOfGray(int red, int blue, int green) {
        return Math.abs(red - green) < 30 && Math.abs(red - blue) < 30 && Math.abs(green - blue) < 30;
    }

    public static int createRGB(int red, int green, int blue) {
        return ((red & 0xff) << 16) | ((green & 0xff) << 8) | (blue & 0xff);
    }

    public static int getRed(int rgb) {
        return (rgb & 0xff000000) >> 16;
    }

    public static int getGreen(int rgb) {
        return (rgb & 0x00ff0000) >> 8;
    }

    public static int getBlue(int rgb) {
        return (rgb) & 0x000000ff;
    }
}

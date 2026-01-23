package com.saurabh.topics.throughput;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {
    public static final String INPUT_FILE = "war_and_peace.txt";

    public static void main(String[] args) throws IOException {

        try (InputStream is = Main.class
                .getClassLoader()
                .getResourceAsStream(INPUT_FILE)) {

            if (is == null) {
                throw new IllegalArgumentException("File not found on classpath: " + INPUT_FILE);
            }

            String text = new String(is.readAllBytes());
            startServer(text);
        }
    }

    public static void startServer(String text) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/search", new SearchHandler(text));
        Executor executor = Executors.newFixedThreadPool(3);
        server.setExecutor(executor);
        server.start();
    }

    public static class SearchHandler implements HttpHandler {
        private final String text;

        public SearchHandler(String text) {
            this.text = text;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
           String query = exchange.getRequestURI().getQuery();
           String[] keyValue = query.split("=");
           String action = keyValue[0];
           String searchTerm = keyValue[1];

           if (!action.equals("word")) {
               exchange.sendResponseHeaders(400, 0);
               return;
           }

           long count = countWord(searchTerm);
           byte[] response = Long.toString(count).getBytes();
           exchange.sendResponseHeaders(200, response.length);
            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(response);
            outputStream.close();

        }

        private long countWord(String searchTerm) {
            String[] words = text.split("\\W+");
            long count = 0;
            for (String word : words) {
                if (word.equalsIgnoreCase(searchTerm)) {
                    count++;
                }
            }
            return count;
        }
    }
}

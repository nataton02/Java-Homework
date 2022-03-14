package de;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class TextSupplier implements Runnable{
    private final String filename;
    private final BlockingQueue<String> queue;

    public TextSupplier(String filename, BlockingQueue<String> queue) {
        this.filename = filename;
        this.queue = queue;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            //TODO read lines from the file one by one and place them into the queue
            String line;
            while ((line = br.readLine()) != null)
                queue.put(line);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

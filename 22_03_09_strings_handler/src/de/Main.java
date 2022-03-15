package de;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
	// Программа получает на вход файл, и должна выдать код с исполненными операциями, указанными в файле

        // create a print writer, which is shared among all the consumers
        PrintWriter pw = new PrintWriter("output.txt");

            // load operations
        List<String> operationPaths = getOperationPath("program.props");
        OperationContext operationContext = new OperationContext();
        operationContext.loadOperations(operationPaths);

        // create blocking queue
        BlockingQueue queue = new LinkedBlockingQueue();

        // create and start supplier
        TextSupplier textSupplier = new TextSupplier("input.txt", queue, 2);
        new Thread(textSupplier).start();

        // create and start several consumers
        TextConsumer consumer1 = new TextConsumer(queue, operationContext, pw);
        TextConsumer consumer2 = new TextConsumer(queue, operationContext, pw);

        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }

    private static List<String> getOperationPath(String filename) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(filename));
        String pathsString = properties.getProperty("paths");
        return Arrays.asList(pathsString.split(","));
    }
}

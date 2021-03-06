package de;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

public class TextConsumer implements Runnable{

    private final BlockingQueue<String> queue;
    private final OperationContext operationContext;
    private final PrintWriter pw;

    public TextConsumer(BlockingQueue<String> queue, OperationContext operationContext, PrintWriter pw) {
        this.queue = queue;
        this.operationContext = operationContext;
        this.pw = pw;
    }

    @Override
    public void run() {
        try {
             while (true) {
                 String line = queue.take();
                 if(line.equals("exit"))
                     return;
                 String newLine = handleLine(line);
                 pw.println(newLine);
                 pw.flush();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String handleLine(String line) {
        String[] words = line.split("#");
        if (words.length != 2) {
            return line + "#" + "wrong format";
        }
        String operationName = words[0];
        String text = words[1];

        IStringOperation operation = operationContext.getOperation(operationName);
        if (operation == null)
            return line + "#" + "operation not supported";
        return operation.operate(text);
    }
}

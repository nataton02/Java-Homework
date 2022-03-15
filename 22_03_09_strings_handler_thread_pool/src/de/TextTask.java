package de;

import java.io.PrintWriter;

public class TextTask implements Runnable{

    private final OperationContext operationContext;
    private final PrintWriter pw;
    private final String line;

    public TextTask(OperationContext operationContext, PrintWriter pw, String line) {
        this.operationContext = operationContext;
        this.pw = pw;
        this.line = line;
    }

    @Override
    public void run() {
        String res = handleLine(line);
        pw.println(res);
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

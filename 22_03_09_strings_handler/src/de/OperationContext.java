package de;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * loads and provides all operations by their names
 */
public class OperationContext {
    // stores operations by their names
    Map<String, IStringOperation> operationSource;

    /**
     * The method creates the instances for all the operations by their names and places into operationSource
     * @param operationsPaths the path to the operations ('de.operation.UpperCaseOperation')
     */
    public void loadOperations(List<String> operationsPaths) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //TODO implement
        operationSource = new HashMap<>();
        for (String path : operationsPaths) {
            Class classOperation = Class.forName(path);
            IStringOperation operation = (IStringOperation) classOperation.getConstructor().newInstance();
            operationSource.put(operation.getName(), operation);
        }
    }

    public IStringOperation getOperation(String name) {
        return operationSource.get(name);
    }
}

package de;

import java.lang.reflect.InvocationTargetException;

public class AnimalStore {
    //Violets the 2nd SOLID principle. (Нарушает второй принцип СОЛИД)
    // 1 principle - S - single responsibility - принцип единой ответственности - Метод должен решать одну задачу.
    //Класс должен описывать что-то одно.
    // 2 principle - O - open close - Код открыт к расширению, но закрыт к изменению

    /**
     * The method accepts the type of the wanted animal as a name of the class.
     * @param type the name of the class
     * @return an instance of the class
     */
    public Animal sale(String type) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException { // метод нарушает второй принцип
        //TODO remake so that the method does not violate the 2nd SOLID principle
        String typeAnimal = "de.animal.".concat(type);
        Class<Animal> classType = (Class<Animal>) Class.forName(typeAnimal);
        return classType.getConstructor().newInstance();
    };

}

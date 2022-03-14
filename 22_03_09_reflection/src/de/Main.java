package de;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
	// create an instance of a class by its name

        String type = "de.animal.Dog";

        // method forName("de.animal.Fish") returns the object de.animal.Fish.class
        Class classFromString = Class.forName(type);
        Animal animal = (Animal) classFromString.getConstructor().newInstance();
        System.out.println(animal.sound());


        AnimalStore animalStore = new AnimalStore();
        System.out.println(animalStore.sale("Dog"));
    }
}

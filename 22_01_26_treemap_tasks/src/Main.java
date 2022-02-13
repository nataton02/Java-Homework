//2. Есть класс автомобиль, в котором есть два три поля: Марка, Модель, Цена. Написать функцию,
// которая принимает лист автомобилей, а возвращает TreeMap, ключами которого являются марки автомобилей,
// а значениями будут TreeSet автомобилей, в котором автомобили расположены в лексикографическом порядке
// относительно модели, причем дешевые вперед (необходимо написать правильный компаратор, который будет
// складывать автомобили в TreeSet в правильном порядке)
//
//3. Написать метод, принимающий лист слов, а возвращающий TreeMap, ключами которого являются буквы,
//   в значениями - листы слов, начинающихся с данной буквы и расположенных в лексикографическом порядке
//   ({hello, world, hell} -> {h: [hell, hello], w: [world]})


import java.sql.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Auto auto0 = new Auto("Volvo", "c60", 10000);
        Auto auto1 = new Auto("Volvo", "c60", 15000);
        Auto auto2 = new Auto("Mercedes", "amers", 20000);
        Auto auto3 = new Auto("Volvo", "a60", 5000);
        Auto auto4 = new Auto("Mercedes", "bmers", 18000);
        Auto auto5 = new Auto("Mercedes", "bmers", 30000);

        List<Auto> autos = new ArrayList<>();
        autos.add(auto0);
        autos.add(auto1);
        autos.add(auto2);
        autos.add(auto3);
        autos.add(auto4);
        autos.add(auto5);

        Main solution = new Main();
        System.out.println(solution.autoByMake(autos));




        /*List<String> words = Arrays.asList("How", "World!", "Hello", "Are", "You", "hi");
        TreeMap<String, List<String>> r = Main.wordsToTreeMap(words);
        System.out.println("====> " + r);*/
	// write your code here
    }

    public TreeMap<String, TreeSet<Auto>> autoByMake (List<Auto> autos) {
        TreeMap<String, TreeSet<Auto>> autoByMake = new TreeMap<>();
        for (Auto auto : autos){
            if (autoByMake.containsKey(auto.make)) {
                TreeSet<Auto> value = autoByMake.get(auto.make);
                value.add(auto);
                autoByMake.put(auto.make, value);
            }
            else {
                TreeSet<Auto> value = new TreeSet<>(new ComparatorModel());
                value.add(auto);
                autoByMake.put(auto.make, value);
            }
        }
        return autoByMake;
    }

    public static TreeMap<String, List<String>> wordsToTreeMap(List<String> words) {
        TreeMap<String, List<String>> result = new TreeMap();
        for (String s : words) {
            String firstLetter = s.substring(0, 1).toLowerCase();
            List<String> currentValue = result.get(firstLetter);
            if (currentValue != null) {
                List<String> tempValue = new ArrayList<String>();
                tempValue.addAll(currentValue);
                tempValue.add(s);
                Collections.sort(tempValue);
                result.put(firstLetter, tempValue);
            } else {
                List<String> newValue = new ArrayList<String>();
                newValue.add(s);
                result.put(firstLetter, newValue);
            }
        }
        return result;
    }
}

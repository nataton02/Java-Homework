import list.AdvancedArrayList;
import list.CustomArrayList;
import list.CustomList;

import java.util.Arrays;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        CustomList<Integer> list = new AdvancedArrayList();

        list.add(10);
        list.add(15);
        list.add(10);
        list.add(3);// {10, 15, 3}

        list.println();

        // list.insert(2, 7);//{10, 15, 7, 3}
         list.println();

        list.removeByValue(10); //{15, 10, 3}
        list.println();

        CustomList<Integer> arrayList = new CustomArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(4);
        arrayList.add(10);
        System.out.println(arrayList.size());//4

        arrayList.insert(1, 2);
        System.out.println(arrayList.size());//5
        arrayList.println();// {6, 2, 10, 4, 10}

        arrayList.removeById(1);
        System.out.println(arrayList.size());//4
        arrayList.println();// {6, 10, 4, 10}

        arrayList.removeByValue(10);
        arrayList.println();

        list = new CustomArrayList();

        Iterator<Integer> iterator = list.getIterator();
        while (iterator.hasNext()) {
            int number = iterator.next();
            System.out.println(number);
        }




    }
}

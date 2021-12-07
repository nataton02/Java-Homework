import list.AdvancedArrayList;
import list.CustomArrayList;
import list.CustomList;

public class Main {

    public static void main(String[] args) {

        CustomList list = new AdvancedArrayList();

        list.add(10);
        list.add(15);
        list.add(3);// {10, 15, 3}

        list.println();

        list.insert(2, 7);//{10, 15, 7, 3}
        list.println();

        list.removeById(0); //{15, 7, 3}
        list.println();

        CustomList arrayList = new CustomArrayList();
        arrayList.add(6);
        arrayList.add(10);
        System.out.println(arrayList.size());//2

        arrayList.insert(1, 2);
        System.out.println(arrayList.size());//3
        arrayList.println();// {6, 2, 10}

        arrayList.removeById(0);
        System.out.println(arrayList.size());//2
        arrayList.println();// {2, 10}

    }
}

package DIO_soft;

/**
 * Created by oleksandr_khomenko on 09.10.2014.
 */

public class SecondLecture {
    public static void main(String[] args) {

//        Person sasha = new Person("Sasha", "Khomenko", "oleksandr88khomenko@gmail.com", new Integer(26), Position.DEVELOPER);
//        Person oleksii = new Person("Oleksii", "Vasylenko", "alex88vasylenko@gmail.com", new Integer(25), Position.ANALYST);
//        System.out.println(sasha.equals(oleksii));
//        int sashaHashcode = sasha.hashCode();
//        int oleksiiHashcode = oleksii.hashCode();
//        if (sashaHashcode == oleksiiHashcode)
//
//            System.out.println(true);


        int[] firstArr = {1, 3, 5, 7, 9};
        int[] secondArr = {2, 4, 6, 8, 10};

        int[] united = union(firstArr, secondArr);
        printArray(united);
    }

    public static int[] union(int[] firstArr, int[] secondArr) {

        int flength = firstArr.length;
        int slength = secondArr.length;

        int[] union = new int[flength + slength];

        int traceIndex = 0;

        for (int elem : firstArr)
            union[traceIndex++] = elem;

        for (int elem : secondArr)
            union[traceIndex++] = elem;

        return union;
    }

    public static void printArray(int[] array) {

        for(int elem : array )
            System.out.print(elem + " ");

    }


}

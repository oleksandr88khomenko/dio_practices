package DIO_soft.second_lecture;

import java.util.Arrays;

/**
 * Created by oleksandr_khomenko on 09.10.2014.
 */

public class SecondLectureHW {
    public static void main(String[] args) {

        int[] firstArr = {1, 5, 4, 23, 65, 32, 78};
        int[] secondArr = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};


        int[] united = union(firstArr, secondArr);
        printArray(united);
        System.out.println("just union ");


        int[] innerUnion = innerUnion(firstArr, secondArr);
        printArray(innerUnion);
        System.out.println("inner union ");


        int[] outerUnion = outerUnion(firstArr, secondArr);
        printArray(outerUnion);
        System.out.println("outer union ");
    }

    //outer union
    public static int[] outerUnion(int[] firstArr, int[] secondArr) {

        int[] innerUnion = innerUnion(firstArr, secondArr);
        int[] outerUnion = new int[(firstArr.length + secondArr.length) - innerUnion.length * 2 - 1];
        int[] union = union(firstArr, secondArr);
        Arrays.sort(innerUnion);
        int traceindex = 0;
        for (int elem : union) {
            if (Arrays.binarySearch(innerUnion, elem) < 0)
                outerUnion[traceindex++] = elem;
        }

        return outerUnion;

    }

    //inner union
    public static int[] innerUnion(int[] firstArr, int[] secondArr) {

        Arrays.sort(firstArr);
        Arrays.sort(secondArr);
        int[] innerUnion = null;
        int traceIndex = 0;
        int peersCounter = 0;
        for (int elem : firstArr) {
            int position = Arrays.binarySearch(secondArr, elem);
            if (position >= 0)
                peersCounter++;
        }

        innerUnion = new int[peersCounter];
        for (int elem : firstArr) {
            int position = Arrays.binarySearch(secondArr, elem);
            if (position >= 0) {
                innerUnion[traceIndex++] = secondArr[Arrays.binarySearch(secondArr, elem)];

            }
        }

        return innerUnion;

    }

    //merging two arrays considering duplicates
    public static int[] union(int[] firstArr, int[] secondArr) {

        int flength = firstArr.length;
        int slength = secondArr.length;
        int[] innerUnion = innerUnion(firstArr, secondArr);
        int[] union = new int[(flength + slength-1)-innerUnion.length];

        int traceIndex = 0;

        for (int elem : firstArr)
            union[traceIndex++] = elem;

        for (int elem : secondArr)
            if (Arrays.binarySearch(innerUnion, elem) < 0)
                union[traceIndex++] = elem;

        return union;
    }

    //printing arrays
    public static void printArray(int[] array) {

        for (int elem : array)
            System.out.print(elem + " ");

    }


}

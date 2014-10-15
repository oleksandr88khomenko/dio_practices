package DIO_soft.second_lecture;

import DIO_soft.third_lecture.MyExceptions;

import java.util.Arrays;

/**
 * Created by oleksandr_khomenko on 09.10.2014.
 */

public class SecondLectureHW {
    public static void main(String[] args) {

        SecondLectureHW secondLectureHW = new SecondLectureHW();

        int[] firstArr = {1, 5, 4, 23, 65, 32, 78};
        int[] secondArr = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};


        int[] united = new int[0];
        try {
            united = secondLectureHW.union(firstArr, secondArr);
        } catch (MyExceptions e) {
            System.out.println(e.getMessage());
        }
        printArray(united);
        System.out.println("just union ");


        int[] innerUnion = new int[0];
        try {
            innerUnion = secondLectureHW.innerUnion(firstArr, secondArr);
        } catch (MyExceptions e) {
            System.out.println(e.getMessage());
        }
        printArray(innerUnion);
        System.out.println("inner union ");


        int[] outerUnion = new int[0];
        try {
            outerUnion = secondLectureHW.outerUnion(firstArr, secondArr);
        } catch (MyExceptions e) {
            System.out.println(e.getMessage());
        }
        printArray(outerUnion);
        System.out.println("outer union ");
    }

    //outer union
    public int[] outerUnion(int[] firstArr, int[] secondArr) throws MyExceptions {

        if (firstArr == null || firstArr.length == 0 || secondArr == null || secondArr.length == 0)
            throw new MyExceptions(firstArr, secondArr);

        int[] innerUnion = new int[0];
        innerUnion = innerUnion(firstArr, secondArr);

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
    public int[] innerUnion(int[] firstArr, int[] secondArr) throws MyExceptions {

        if (firstArr == null || firstArr.length == 0 || secondArr == null || secondArr.length == 0)
            throw new MyExceptions(firstArr, secondArr);

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
    public int[] union(int[] firstArr, int[] secondArr) throws MyExceptions {

        if (firstArr == null || firstArr.length == 0 || secondArr == null || secondArr.length == 0)
            throw new MyExceptions(firstArr, secondArr);

        int flength = firstArr.length;
        int slength = secondArr.length;
        int[] innerUnion = new int[0];

        innerUnion = innerUnion(firstArr, secondArr);

        int[] union = new int[(flength + slength - 1) - innerUnion.length];

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

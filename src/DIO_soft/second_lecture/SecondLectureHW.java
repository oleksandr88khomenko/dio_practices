package DIO_soft.second_lecture;

import DIO_soft.Person;
import DIO_soft.Position;
import DIO_soft.fifth_lecture.ArrayHelper;
import DIO_soft.fifth_lecture.ServicDelegate;
import DIO_soft.third_lecture.MyExceptions;

import java.util.Arrays;
import java.util.List;

/**
 * Created by oleksandr_khomenko on 09.10.2014.
 */

public class SecondLectureHW {
    public static void main(String[] args) {

        //builder pattern
        Person sasha = new Person.Builder().firstName("Sasha").secondName("Khomenko").position(Position.DEVELOPER).age(new Integer(25)).email("sasha_email@.gmail.com").build();
        Person sasha1 = new Person.Builder().firstName("Sasha").secondName("Khimenko").position(Position.DEVELOPER).age(new Integer(26)).email("sasha_email@.gmail.com").build();
        Person vanya = new Person.Builder().firstName("Vanya").secondName("Grynenko").position(Position.DEVELOPER).age(new Integer(25)).email("my_email@.gmail.com").build();
        Person sergii = new Person.Builder().firstName("Sergii").secondName("Musenko").position(Position.DEVELOPER).age(new Integer(24)).email("denis_email@.gmail.com").build();
        Person vasya = new Person.Builder().firstName("Vasya").secondName("Larionov").position(Position.DEVELOPER).age(new Integer(20)).email("email@.gmail.com").build();
        Person valya = new Person.Builder().firstName("Valya").secondName("Lari").position(Position.DEVELOPER).age(new Integer(19)).email("lari_email@.gmail.com").build();
//        Person vakya = valya;

        SecondLectureHW secondLectureHW = new SecondLectureHW();

        List<Person> firstArr = Arrays.asList(sasha, sasha1, vanya);
        List<Person> secondArr = Arrays.asList(sergii, sasha, vanya);

        ArrayHelper arrayHelper = new ArrayHelper();
        ServicDelegate servicDelegate = new ServicDelegate(arrayHelper);
        try {
            servicDelegate.merge(firstArr, secondArr);
        } catch (MyExceptions myExceptions) {
            myExceptions.printStackTrace();
        }


//        int[] united = new int[0];
//        try {
//            united = secondLectureHW.union(firstArr, secondArr);
//        } catch (MyExceptions e) {
//            System.out.println(e.getMessage());
//        }
//        printArray(united);
//        System.out.println("just union ");
//
//
//        int[] innerUnion = new int[0];
//        try {
//            innerUnion = secondLectureHW.innerUnion(firstArr, secondArr);
//        } catch (MyExceptions e) {
//            System.out.println(e.getMessage());
//        }
//        printArray(innerUnion);
//        System.out.println("inner union ");
//
//
//        int[] outerUnion = new int[0];
//        try {
//            outerUnion = secondLectureHW.outerUnion(firstArr, secondArr);
//        } catch (MyExceptions e) {
//            System.out.println(e.getMessage());
//        }
//        printArray(outerUnion);
//        System.out.println("outer union ");
//
//        int[] leftUnion = new int[0];
//        try {
//            leftUnion = secondLectureHW.leftUnion(firstArr, secondArr);
//        } catch (MyExceptions myExceptions) {
//            myExceptions.printStackTrace();
//        }
//        printArray(leftUnion);
//        System.out.println("left union ");
//    }
//
//    //outer union
//    public int[] outerUnion(int[] firstArr, int[] secondArr) throws MyExceptions {
//
//        if (firstArr == null || firstArr.length == 0 || secondArr == null || secondArr.length == 0)
//            throw new MyExceptions(firstArr, secondArr);
//
//        int[] innerUnion = new int[0];
//        innerUnion = innerUnion(firstArr, secondArr);
//
//        int[] outerUnion = new int[(firstArr.length + secondArr.length) - innerUnion.length * 2 - 1];
//        int[] union = union(firstArr, secondArr);
//        Arrays.sort(innerUnion);
//        int traceindex = 0;
//        for (int elem : union) {
//            if (Arrays.binarySearch(innerUnion, elem) < 0)
//                outerUnion[traceindex++] = elem;
//        }
//
//        return outerUnion;
//
//    }
//
//    //inner union
//    public int[] innerUnion(int[] firstArr, int[] secondArr) throws MyExceptions {
//
//        if (firstArr == null || firstArr.length == 0 || secondArr == null || secondArr.length == 0)
//            throw new MyExceptions(firstArr, secondArr);
//
//        Arrays.sort(firstArr);
//        Arrays.sort(secondArr);
//        int[] innerUnion = null;
//        int traceIndex = 0;
//        int peersCounter = 0;
//        for (int elem : firstArr) {
//            int position = Arrays.binarySearch(secondArr, elem);
//            if (position >= 0)
//                peersCounter++;
//        }
//
//        innerUnion = new int[peersCounter];
//        for (int elem : firstArr) {
//            int position = Arrays.binarySearch(secondArr, elem);
//            if (position >= 0) {
//                innerUnion[traceIndex++] = secondArr[Arrays.binarySearch(secondArr, elem)];
//
//            }
//        }
//
//        return innerUnion;
//
//    }
//
//    //merging two arrays considering duplicates
//    public int[] union(int[] firstArr, int[] secondArr) throws MyExceptions {
//
//        if (firstArr == null || firstArr.length == 0 || secondArr == null || secondArr.length == 0)
//            throw new MyExceptions(firstArr, secondArr);
//
//        int flength = firstArr.length;
//        int slength = secondArr.length;
//        int[] innerUnion;
//        innerUnion = innerUnion(firstArr, secondArr);
//
//        int[] union = new int[(flength + slength - 1) - innerUnion.length];
//
//        int traceIndex = 0;
//
//        for (int elem : firstArr)
//            union[traceIndex++] = elem;
//
//        for (int elem : secondArr)
//            if (Arrays.binarySearch(innerUnion, elem) < 0)
//                union[traceIndex++] = elem;
//
//        return union;
//    }
//
//    //printing arrays
//    public static void printArray(int[] array) {
//
//        for (int elem : array)
//            System.out.print(elem + " ");
//
//    }
//
//    public int[] leftUnion(int[] firstArr, int[] secondArr) throws MyExceptions {
//
//        int[] leftUnion;
//        if (firstArr == null)
//            return null;
//        if (firstArr.length == 0)
//            return leftUnion = new int[0];
//
//        int[] innerUnion = innerUnion(firstArr, secondArr);
//        leftUnion = new int[firstArr.length + innerUnion.length];
//        System.arraycopy(firstArr, 0, leftUnion, 0, firstArr.length);
//        System.arraycopy(innerUnion, 0, leftUnion, firstArr.length, innerUnion.length);
//        return leftUnion;
//    }
    }
}
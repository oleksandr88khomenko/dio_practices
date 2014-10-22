package DIO_soft.fifth_lecture;

import DIO_soft.Person;
import DIO_soft.third_lecture.MyExceptions;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by oleksandr_khomenko on 22.10.2014.
 */
public class ArrayHelper {

    public Person[] union(Person[] firstArr, Person[] secondArr) throws MyExceptions {

        if (firstArr == null || firstArr.length == 0 || secondArr == null || secondArr.length == 0)
            throw new MyExceptions(firstArr, secondArr);

        int flength = firstArr.length;
        //System.out.println("" + firstArr.length);
        int slength = secondArr.length;
       // System.out.println(secondArr.length);
        Person[] innerUnion;
        innerUnion = innerUnion(firstArr, secondArr);
        int innLength = (innerUnion.length);
        Person[] union = new Person[(flength + slength) - innerUnion.length];

        int traceIndex = 0;

        for (Person elem : firstArr)
            union[traceIndex++] = elem;

        for (Person elem : secondArr)
            if (Arrays.binarySearch(innerUnion, elem) < 0)
                union[traceIndex++] = elem;

        return union;

    }

    public Person[] innerUnion(Person[] firstArr, Person[] secondArr) throws MyExceptions {

        if (firstArr == null || firstArr.length == 0 || secondArr == null || secondArr.length == 0)
            throw new MyExceptions(firstArr, secondArr);

        Arrays.sort(firstArr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getSecondName().equals(o2.getSecondName()))
                    return o1.getFirstName().compareTo(o2.getFirstName());
                return o1.getSecondName().compareTo(o2.getSecondName());
            }
        });
        Arrays.sort(secondArr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getSecondName().equals(o2.getSecondName()))
                    return o1.getFirstName().compareTo(o2.getFirstName());
                return o1.getSecondName().compareTo(o2.getSecondName());
            }
        });
        Person[] innerUnion = null;
        int traceIndex = 0;
        int peersCounter = 0;
        for (Person elem : firstArr) {
            int position = Arrays.binarySearch(secondArr, elem);
            if (position >= 0)
                peersCounter++;
        }

        innerUnion = new Person[peersCounter];
        for (Person elem : firstArr) {
            int position = Arrays.binarySearch(secondArr, elem);
            if (position >= 0) {
                innerUnion[traceIndex++] = secondArr[Arrays.binarySearch(secondArr, elem)];

            }
        }

        return innerUnion;

    }

}

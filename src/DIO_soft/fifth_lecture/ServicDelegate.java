package DIO_soft.fifth_lecture;

import DIO_soft.Person;
import DIO_soft.third_lecture.MyExceptions;

/**
 * Created by oleksandr_khomenko on 22.10.2014.
 */
public class ServicDelegate {

    public ArrayHelper getArrayHelper() {
        return arrayHelper;
    }

    private ArrayHelper arrayHelper;

    public ServicDelegate(ArrayHelper arrayHelper) {
        
        this.arrayHelper = arrayHelper;

    }

    public Person[] merge(Person[] array_one, Person[] arr_two) throws MyExceptions {

        System.out.println("merging two arrays of Person type");
        Person[] result = arrayHelper.union(array_one, arr_two);
        printArray(result);
        return result;

    }

    public static void printArray(Person[] array) {

        for (Person elem : array)
            System.out.println(elem.toString());

    }
}

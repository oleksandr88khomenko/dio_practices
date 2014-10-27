package DIO_soft.fifth_lecture;

import DIO_soft.Person;
import DIO_soft.third_lecture.MyExceptions;

import java.util.List;

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

    public List<Person> merge(List<Person> array_one, List<Person> arr_two) throws MyExceptions {

        System.out.println("merging two arrays of Person type");
        List<Person> result = arrayHelper.union(array_one, arr_two);
        printArray(result);
        return result;

    }

    public static void printArray(List<Person> array) {

        for (Person elem : array)
            System.out.println(elem.toString());

    }
}

package DIO_soft.third_lecture;

import java.util.List;

/**
 * Created by oleksandr_khomenko on 14.10.2014.
 */
public class MyExceptions extends Exception {

    private String cause;
    boolean plus;

    public MyExceptions(List firstArr, List secondArr) {

        if (firstArr == null || firstArr.size() == 0) {
            cause = "First argument is null or empty";
            plus = true;
        }

        if (secondArr == null || secondArr.size() == 0) {
            cause = "Second argument is null or empty";
            if (plus)
                cause = "and second argument is null or empty";
        }
    }

    public String getMessage() {
        return cause;
    }


}

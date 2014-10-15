package DIO_soft.secondLectureTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by oleksandr_khomenko on 15.10.2014.
 */
public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(SecondLectureHWTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.getDescription().getTestClass() + " " + failure.getDescription().getMethodName() + " " + failure.getException().getMessage());
            failure.getException().printStackTrace();
        }

    }
}

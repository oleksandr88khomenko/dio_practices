package DIO_soft.secondLectureTest;

import DIO_soft.second_lecture.SecondLectureHW;
import org.junit.Assert;
import org.junit.Test;

public class SecondLectureHWTest {

    SecondLectureHW secondLectureHW = new SecondLectureHW();

    int[] firstArr = {1, 5, 4, 23, 65, 32, 78};
    int[] secondArr = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};

    @Test
    public void testOuterUnion() throws Exception {

        int[] expectedArray = {23, 65, 78, 2, 3, 24, 34, 45};
        int[] result = secondLectureHW.outerUnion(firstArr, secondArr);
        Assert.assertArrayEquals(expectedArray, result);

    }

    @Test
    public void testInnerUnion() throws Exception {

        int[] expectedArray = {1, 4, 5, 32};
        int[] result = secondLectureHW.innerUnion(firstArr, secondArr);
        Assert.assertArrayEquals(expectedArray,result);
    }

    @Test
    public void testUnion() throws Exception {

        int[] expectedArray = {1, 4, 5, 23, 32, 65, 78, 2, 3, 24, 34, 45};
        int[] result = secondLectureHW.union(firstArr, secondArr);
        Assert.assertArrayEquals(expectedArray, result);

    }

}
package DIO_soft.fifth_lecture;

import DIO_soft.Person;
import DIO_soft.Position;
import org.junit.Assert;
import org.junit.Test;

public class ServicDelegateTest {

    @Test
    public void testMerge() throws Exception {

        ServicDelegate servicDelegate = new ServicDelegate(new ArrayHelper());

        Person sasha = new Person.Builder().firstName("Sasha").secondName("Khomenko").position(Position.DEVELOPER).age(new Integer(25)).email("sasha_email@.gmail.com").build();
        Person sasha1 = new Person.Builder().firstName("Sasha").secondName("Khimenko").position(Position.DEVELOPER).age(new Integer(26)).email("sasha_email@.gmail.com").build();
        Person vanya = new Person.Builder().firstName("Vanya").secondName("Grynenko").position(Position.DEVELOPER).age(new Integer(25)).email("my_email@.gmail.com").build();
        Person sergii = new Person.Builder().firstName("Sergii").secondName("Musenko").position(Position.DEVELOPER).age(new Integer(24)).email("denis_email@.gmail.com").build();
        Person vasya = new Person.Builder().firstName("Vasya").secondName("Larionov").position(Position.DEVELOPER).age(new Integer(20)).email("email@.gmail.com").build();
        Person valya = new Person.Builder().firstName("Valya").secondName("Lari").position(Position.DEVELOPER).age(new Integer(19)).email("lari_email@.gmail.com").build();

        Person[] firstArr = {sasha, sasha1, vanya};
        Person[] secondArr = {sergii, sasha, vanya};
        Person[] expected = {vanya, sasha1, sasha, sergii};
        Person[] result = servicDelegate.merge(firstArr, secondArr);
        Assert.assertArrayEquals(expected, result);
    }
}
package DIO_soft;

/**
 * Created by oleksandr_khomenko on 09.10.2014.
 */
public class Person {

    //local code review (vtegza): make fields final @ 12.10.14
    private final String firstName;
    private final String secondName;
    private final String email;
    private final Integer age;
    private final Enum<Position> position;

    public Person(String firstName, String secondName, String email, Integer age, Enum<Position> position) {

        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.age = age;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!age.equals(person.age)) return false;
        if (!email.equals(person.email)) return false;
        if (!firstName.equals(person.firstName)) return false;
        if (!position.equals(person.position)) return false;
        if (!secondName.equals(person.secondName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + secondName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + age.hashCode();
        result = 31 * result + position.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", position=" + position +
                '}';
    }
//local code review (vtegza): generate toString @ 12.10.14

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public Enum getPosition() {
        return position;
    }


}

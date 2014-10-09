package DIO_soft;

/**
 * Created by oleksandr_khomenko on 09.10.2014.
 */
public class Person {

    private String firstName;
    private String secondName;
    private String email;
    private Integer age;
    private Enum<Position> position;

    public Person() {

    }

    public Person(String firstName, String secondName, String email, Integer age, Enum position) {

        setAge(age);
        setEmail(email);
        setFirstName(firstName);
        setSecondName(secondName);
        setPosition(position);

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Enum getPosition() {
        return position;
    }

    public void setPosition(Enum position) {
        this.position = position;
    }


}

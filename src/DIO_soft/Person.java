package DIO_soft;

/**
 * Created by oleksandr_khomenko on 09.10.2014.
 */
public class Person implements Comparable<Person> {

    //local code review (vtegza): make fields final @ 12.10.14
    private final String firstName;
    private final String secondName;
    private final String email;
    private final Integer age;
    private final Enum<Position> position;


    private Person(Builder builder) {

        this.firstName = builder.firstName;
        this.secondName = builder.secondName;
        this.email = builder.email;
        this.age = builder.age;
        this.position = builder.position;
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

    @Override
    public int compareTo(Person o) {

        int otherPersonAge = ((Person) o).getAge();
        return this.age - otherPersonAge;

    }

    public static class Builder {

        private String firstName;
        private String secondName;
        private String email;
        private Integer age;
        private Enum<Position> position;

        public Builder() {

        }

        public Builder(Person person) {

            this.firstName = person.firstName;
            this.secondName = person.secondName;
            this.age = person.age;
            this.email = person.email;
            this.position = person.position;

        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder secondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder position(Enum<Position> position) {
            this.position = position;
            return this;
        }

        public Person build() {

            return new Person(this);

        }

    }


}

package OOP_Concepts;

import java.util.Objects;

public class Constructor {
    public static void main(String[] args) {
        /* test overloading methods */
        Person[] persons = new Person[3];
        persons[0] = new Person();
        persons[1] = new Person("ABC");
        persons[2] = new Person("DEF", 9);

        for(Person p : persons) {
            System.out.println(p.toString());
        }

        Worker worker = new Worker();
        Worker worker2 = new Worker("XYZ");
        Worker worker3 = new Worker("XYZ", 1);

    }
}

class Worker extends Person{

    /* new creates a base object
     * All constructors in an object inheritance must run when a new object is created */
    public Worker(){
//        super();
        System.out.println("Making a Worker");
    }
    public Worker(String name){
        super(name);
        System.out.println("Making a Worker");
    }
    public Worker(String name, int k){
        /* 'this' to call another constructor not from inheritance */
        this(name);
        System.out.println("Call another constructor within itself");
    }

}

class Person{
    String name;
    int height;

    public Person(){
        System.out.println("Making a default Person");
        this.name = "no name";
    }
    public Person(String name){
        System.out.println("Making a named Person");
        this.name = name;
    }
    public Person(String name, int height){
        this.name = name;
        this.height = height;
    }

    /* IntelliJ Shortcut  --> Alt + Insert */
    public String getName() {
        return this.name;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public String toString() {
        return String.format("Person{name='%s', height=%d}", this.name, this.height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getHeight() == person.getHeight() &&
                Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHeight());
    }
}

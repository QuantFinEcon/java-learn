package OOP_Concepts;

public class Polymorphism {
    /* final class = not extendable class */
    public static void main(String[] args) {

        Animal[] zoo = new Animal[3];
        /* Similar to List (Super) to ArrayList (Sub)
        List<Integer> x = new ArrayList<Integer>(); */

        /* Polymorphism in assignment. Here, Cat has more methods than Animal. */
        zoo[0] = new Dog("Jerry");
        zoo[1] = new Hippo("Linus");
        zoo[2] = new Lion("Madagascar");

        /* Like a factory, facade */
        for (int i = 0; i < zoo.length; i++) {
            zoo[i].makeNoise();
        }
        for (Animal a : zoo) {
            a.makeNoise();
        }
        System.out.println();

        /* Object a = new Dog()  ==> reference-type to Object, losses its Dogness methods
         * cast it back to retrieve its Dogness methods */
        Object d = new Dog();
        Dog d2 = (Dog) d;
        d2.makeNoise();
        System.out.println();

        Vet justin = new Vet();
        justin.giveShot(d2);
        System.out.println();


    }
}

interface Pet {
    /* all methods are by default
     * public abstract <type> <method name> */
    void play();
}

/* Does Animal a = new Animal(); makes sense? What's an animal? */
abstract class Animal {
    /* Super class */
    public String myName;
    private int length; // not pass down to subclasses.

    public Animal() {
        this.myName = "FillUpMyName";
    }

    /* Overload default constructor */
    public Animal(String name) {
        this.myName = name;
    }

    public void setLength(int len) {
        length = len;
    }

    public int getLength(int len) {
        return length;
    }

    private void sixSense() {
        /* Private = Cannot be inherited by subclasses */
        /* Not exposed, inaccessible to outside classes */
    }

    public void eat() {
        System.out.println("Animal is eating...");
    }

    /* abstract class need not make all methods abstract unlike interface
     * Forces subclass to implement and override superclass method. MUST be public. */
    abstract public void makeNoise();
    // No {Body}
    // implement downstream in subclasses. Since its too generic at this stage.

}

/* Canine a = new Canine(); What's a Canine? Its not fully concrete yet!!
 * Prevent instantiating of class with abstract class.
 * Abstract class have no value unless it is extended. */
abstract class Canine extends Animal {

    /* inherit constructor. Don't inherit by default. */
    public Canine() {
        super();
    }

    public Canine(String name) {
        super(name);
    }

    public static void nature() {
        /* static method cannot be override by subclasses */
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("Canine eats meat only...");
    }

    /* inherited methods are "equally accessible" , cannot be less */
    @Override
    public void makeNoise() {
        /* Canine overrides as reuse super implementation + decorate */
        System.out.println("Canine making Noise...");
    }
}

abstract class Feline extends Animal {
    /* inherit constructor */
    public Feline() {
        super();
    }

    public Feline(String name) {
        super(name);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("Would Feline eat meat only? ");
    }

    @Override
    public void makeNoise() {
        /* Canine overrides as reuse super implementation + decorate */
        System.out.println("Feline making Noise...");
    }
}

/* concrete class that's allowed to be instantiated */
class Lion extends Feline {

    public Lion() {
        super();
        System.out.println(this.myName + " lion is born.");
    }

    public Lion(String name) {
        super(name);
        System.out.println(this.myName + " lion is born.");
    }

    @Override
    public void makeNoise() {
        super.makeNoise();
        System.out.println("ROAR!!");
    }
}

/* Multiple inheritance leads to Diamond of Death.
 *  both super class has different implementation
 *  of the same method. Which to inherit??
 *
 *  Single inheritance (extend), (implements) multiple interfaces
 *  best way to hijack Pet qualities
 *  without forcing on all subclasses of animals.
 *  Don't care what class of inheritance you come from.
 *  */
class Dog extends Canine implements Pet {

    public Dog() {
        super();
        System.out.println(this.myName + " dog is born.");
    }

    public Dog(String name) {
        super(name);
        System.out.println(this.myName + " dog is born.");
    }

    @Override
    public void makeNoise() {
        super.makeNoise();
        System.out.println("Wolfh!");
    }

    @Override
    public void play() {
        System.out.println(this.myName + " wants to play");
    }
}


class Hippo extends Animal {

    public Hippo(String name) {
        super(name);
        System.out.println(this.myName + " hippo is born.");
    }

    public void makeNoise() {
        System.out.println("Hoo..");
    }

    /* Overloading doesn't override original implementation */
    /* Same method name, but different argument */
    public void makeNoise(String uniqueNoise) {
        this.makeNoise();
        /* Canine overrides as reuse super implementation + decorate */
        System.out.println("Hippo making " + uniqueNoise);
    }

    /* Change return type.
    ARGUMENT must change, else compiler assumes u intend to override
    ACCESS level can be upgraded or downgraded. */
    private int makeNoise(String anotherNoise, int dummyVar) {
        this.makeNoise();
        /* Canine overrides as reuse super implementation + decorate */
        System.out.println("Hippo making " + anotherNoise);
        return dummyVar;
    }

}


class Vet {
    public void giveShot(Animal a) {
        /* polymorphic method's input */
        /* Ultimate polymorhpism with the mother of all subclass
         * class Dog  ===> class Dog extends Object ... implicitly
         *
         * Object methods: equals(), toString(), getClass(), hashCode()
         * are non-final for overriding
         *
         * ArrayList Object get(Object enum) ....
         * similar to PYTHON duck-typing for adults, trade off type-safety
         * TRADE OFF: accepts any Objects --> Return Object, lose its quality!!!
         *
         * TRICK: ArrayList<Dog> hints to compiler to accept and return Dog type only
         *
         */
        a.makeNoise();
    }
}

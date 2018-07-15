package OOP_Concepts;

public class TestStatic {
    /*
    * Static methods won't interact with instance variables, only the arg
    * passed into method changes. A waste of memory to keep with object
    * instance in heap. Can force class to be un-instantiatable.
    *
    * Static != Final
    *
    * Final class: cannot extend anymore
    * Final method: cannot override in subclass
    * Final variable: cannot change its value
    * */
    public static void main(String[] args) {
        /* call static method using class name,
           Song.sing();
           vs
           call non-static method using reference variable name
           Song s = new Song();
           s.sing();
         * */
        String x = String.valueOf(StaticClass.min(99,77));
        System.out.println(x);

        Bird[] birds = new Bird[100];
        for(int i=0;i<10;i++){
            birds[i] = new Duck();
        }
        System.out.println(Bird.birdCount);

    }
}

class Bird{
    /* static so its init only when a class is first loaded, not each time a
    new instance is created. */
    // static var gets type default value if not initiated
    public static int birdCount;
    Bird(){
        birdCount++;
    }

    // subclasses cannot reference to static method. Still, static method can
    // be overloaded with different number / type arguments and can be
    // overridden with the same signature. It just hides base
    // class implementation.
    public static void makeNoise(){}
}

class Duck extends Bird{
    Duck(){
        super();
    }
    public static void makeNoise(){
//        super.makeNoise();
    }
}

class StaticClass{
    public int a;
//    Don't let anyone instantiate this class. e.g. Math
    private StaticClass(){
        this.a = 100;
    }

    public static int min(int a, int b){
        return Math.min(a,b);
        // static method cannot use instance var
        // return Math.min(this.a,b);
    }

}

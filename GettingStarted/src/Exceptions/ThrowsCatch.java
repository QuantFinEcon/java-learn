package Exceptions;

/*
 * RuntimeException is ignored by compiler, hence need not be declared or
 * wrapped in a try/catch. Compiler only cares about compiler-checked exceptions.
 * */
class BadException extends Exception {
    /* Polymorphic objects too. An object that can be thrown. */
    public BadException(String msg) {
        super(msg);
    }
}

class BadException2 extends BadException {

    public BadException2(String msg) {
        super(msg);
    }
}

public class ThrowsCatch {
    public static void main(String[] args) {

    }

    // which method throws? Explicit intention of error possibility by
    // declaring throws ... Here, BadException2 is a subclass of BadException
    // and is thus a duplicate throw
    public void takeRisk() throws BadException, BadException2 {
        /* throws Exception allows to throws any of its subclasses */
        Boolean bool = true;
        if (bool) {
            throw new BadException("Bad!");
        }
        if (bool) {
            throw new BadException2("Bad2!");
        }
    }

    //calls risky method must catch it exception thrown by method
    // catch smallest (sub class) to biggest (base class) exception
    public void crossFingers() {
        try {
            takeRisk();
        } catch (BadException2 ex2) { // catch specific critical exceptions
            System.out.println("message");
            ex2.printStackTrace();
        } catch (BadException ex) {
            System.out.println("message");
            ex.printStackTrace(); // no need to return as it returns void
        } catch (Exception e) { // catch any exception not in the above
            System.out.println("message");
            e.printStackTrace();
        } finally {
            System.out.println("code to run even if failure happens!");
        }
    }

    // if method avoids catching exception and throws it instead, it becomes a
    // risky method the next caller to catch. If delayed till main() and main
    // ducks the exception too, it throws to no one and JVM shuts down!
    public void duckException() throws BadException, BadException2 {
        takeRisk();
    }
}


package OOP_Concepts;

public class TestRefType {

    public static void main(String[] args) {
        NewObject A = new NewObject();
        Object B = new NewObject();

        /* Ctrl + Alt + T */
        try {
            A.method();
//            B.method(); // Down cast to Object type with no such method
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

    }
}

class NewObject extends Object {

    public NewObject() {
        super();
    }

    public void method(){
        System.out.println("called method");
    }
}

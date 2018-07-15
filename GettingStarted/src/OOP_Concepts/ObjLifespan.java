package OOP_Concepts;

public class ObjLifespan {
    /* object (instance variables) lives so long as there's > 1 reference
        pointer coming from stack local variables

        3 ways to kill an object in heap ( remove its only reference from
        stack )
            1)
                T obj = new T();
                obj = new T();
            2)
                T obj = new T():
                obj = null;
            3)
                {
                    T obj = new T();
                }

        */
    public static void main(String[] args) {
        TestLife t = new TestLife();
        t.read();
    }
}

class TestLife{
    public void read(){
        int s = 1; // alive in read() stack scope. sleep is a stack on top
        sleep(s);
    }
    public void sleep(int s){
        s += 7;
        System.out.println(String.valueOf(s));
    }
}
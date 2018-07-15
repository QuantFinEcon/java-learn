package DataStructure;

public final class ArrayIsObject
{
    public static void main(String[] args)
    {
        double[] a = { 100.5, 200.5, 300.5 };
        double[] b = { 100.5, 200.5, 300.5 };
        double[] c = b;
        System.out.println("a's class is " + a.getClass());
        System.out.println("a and b are " + ((a.equals(b)) ? "" : "not ") +
                "equal ");
        System.out.println("b and c are " + ((b.equals(c)) ? "" : "not ") +
                "equal ");
        double[] d = (double[]) c.clone();
        System.out.println("c and d are " + ((c.equals(d)) ? "" : "not ") +
                "equal ");
        for (int i = 0; i < d.length; i++)
            System.out.println(d[i]);
    }
}
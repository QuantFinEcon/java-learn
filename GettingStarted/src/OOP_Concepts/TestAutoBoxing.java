package OOP_Concepts;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TestAutoBoxing {
    /* Prevalent in input or return ref type */
    public static void main(String[] args) {

        // before Java 5
/*
        ArrayList listOfNum = new ArrayList();
        listOfNum.add(new Integer(3));
        Integer k = (Integer) listOfNum.get(0);
        int x = k.intValue();
*/

        // after Java 5 --> Autoboxing / Autocasting
        ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
        listOfNumbers.add(3); // int --> Integer
        int x2 = listOfNumbers.get(0); // Integer --> int

        Integer b = 3;
        Double d;
//        d = (Double) b;
        Double a = 3.0;

        String z1 = String.valueOf(1);
        Integer z2 = Integer.parseInt("1");
        String z3 = Integer.toString(1);
        // %[argument number] [flags] [width) [.precision)type
        String z4 = String.format("floating with , flag 100 width and 2 " +
                        "decimal precision = %,100.2f",
                1200000.123456);
        String z5 = String.format("char of 42 = %c",24);
        String z6 = String.format("hexadecimal of 42 = %x",24);
        String z7 = String.format("decimal of 42 = %d",24);

        /* Date is outdated. Only for today representation. Use Calendar. */
        Date today = new Date();
        String d1 = String.format("Complete datetime = %tc", today);
        String d2 = String.format("time only = %tr", today);
        String d3 = String.format("Weekday, Month, Date = %tA %tB %td",
                today, today, today);
        String d4 = String.format("Weekday, Month, Date (with < shortcut)= " +
                "%tA %<tB %<td", today);

        // Calendar is abstract but u can call its static method on class
        // and not on instance. Static method returns a concrete subclass
        // that extend Calendar e.g. GregorianCalendar extends Calendar.
        Calendar cal = Calendar.getInstance();
        cal.set(2018,0,12,17,59,55);
        System.out.println(cal.getTime().toString());

        long date2 = cal.getTimeInMillis();
        date2 += 1000 * 60 * 2; // add 2 min
        cal.setTimeInMillis(date2);
//        cal.roll(Calendar.MILLISECOND, 2*60);
        System.out.println(cal.getTime().toString());

        cal.roll(cal.DATE, 5);
        cal.roll(cal.MONTH, 1);
        cal.roll(cal.HOUR,2);
        cal.roll(cal.MINUTE,1);
        System.out.println(cal.getTime().toString());


        System.out.println(z4);
        System.out.println(z5);
        System.out.println(z6);
        System.out.println(z7);

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d4);


    }
}

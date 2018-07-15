/*
 * https://stackoverflow.com/questions/10242380/how-can-i-generate-a-list-or-array-of-sequential-integers-in-java
 *
 *
 * */

package basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class control_flows {
    public static void main(String[] args) {

        List<Integer> myArray = new ArrayList<Integer>();
        int x = 1;
        myArray.add(x);
        System.out.println(myArray.get(0));
        System.out.println();

        /* sequential int */
        List<Integer> filledArray = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        for (int i = 0; i < filledArray.size(); i++) {
            System.out.println(filledArray.get(i));
        }
        System.out.println();

        /* arrayList vs primitive list */
        int[] A = IntStream.range(1, 10).toArray();
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
        System.out.println();

        /* multidim array */
        int[][] multiArray = new int[2][2];
        System.out.println(Arrays.deepToString(multiArray));
        System.out.println();




    }
}

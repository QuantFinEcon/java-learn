package DataStructure;

public final class MatMult {
    public static void main(String[] args) {
        int[][] a = {{10, 30}, {20, 40}};
        int[][] b = {{10,30}, {20,40}};
        dump(a);
        System.out.println();

        dump(b);
        System.out.println();

        int[][] c = multiply(a, b);
        dump(c);
        System.out.println();

        /* ragged array */
        int[][] d = {{1,2,3},{4,5}};
        dump(d);

        int[][] x = new int[5][];
        x[0] = new int[] {1,2,3};
        x[1] = new int[] {1,2};;
        x[2] = new int[] {1,2,3,4,5};
        x[3] = new int[] {1};
        x[4] = new int[]{1, 2};
        dump(x);

    }

    private static void dump(int[][] x) {
        if (x == null) {
            System.err.println("array is null");
            return;
        }
        // Dump the matrix's element values to the standard output in a tabular
        // order.
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++)
                System.out.print(x[i][j] + " ");
            System.out.println();
        }
    }

    private static int[][] multiply(int[][] a, int[][] b) {
        // ====================================================================
        // 1. a.length contains a's row count
        //
        // 2. a[0].length (or any other a[x].length for a valid x) contains a's
        //    column count
        //
        // 3. b.length contains b's row count
        //
        // 4. b[0].length (or any other b[x].length for a valid x) contains b's
        //    column count
        // ====================================================================

        // If a's column count != b's row count, bail out

        if (a[0].length != b.length) {
            System.err.println("a's column count != b's row count");
            return null;
        }

        // Allocate result matrix with a size equal to a's row count times b's
        // column count

        int[][] result = new int[a.length][b[0].length];
        for (int i = 0; i < result.length; i++)
            result[i] = new int[b[0].length];

        // Perform the multiplication and addition

        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b[0].length; j++)
                for (int k = 0; k < a[0].length; k++) // or k < b.length
                    result[i][j] += a[i][k] * b[k][j];

        // Return the result matrix

        return result;
    }
}

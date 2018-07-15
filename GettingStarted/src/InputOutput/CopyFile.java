package InputOutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {

    public static void main(String args[]) throws IOException {

        final String dir = System.getProperty("user.dir");
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            System.out.println(dir);
            System.out.println("HELLO!");
            System.out.flush();

            in = new FileInputStream("scancsv.txt");
            out = new FileOutputStream("output.txt");

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
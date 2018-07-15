package InputOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScanCsv {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        File file = new File("scancsv.txt");
        Scanner scanner = new Scanner(file);
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());

        scanner.useDelimiter(",");
        while (scanner.hasNext()) {
            System.out.print(scanner.next() + "|");
        }
        scanner.close();
    }

}

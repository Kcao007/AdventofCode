/* Keith Cao
 * Day 1 of Advent of Code 2025
 * One Star
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day1 {
    public static void main(String[] args) {
        try {
            File f = new File("./Day1/input.txt");
            Scanner s = new Scanner(f);

            int pos = 50;
            int counter = 0;
            while(s.hasNextLine()) {
                String str = s.nextLine();
                char dir = str.charAt(0);
                int num = Integer.parseInt(str.substring(1));

                if(dir == 'L') {
                    num *= -1;
                }
                pos += num;

                while(pos < 0 || pos > 99) {
                    if(pos < 0) {
                        pos += 100;
                    } else if(pos > 99) {
                        pos -= 100;
                    }
                }

                if(pos == 0) {
                    counter++;
                } 
            }
            System.out.println(counter);

        } catch (FileNotFoundException e) {
            System.err.println("File not Found:" + e);
        }
    }
}
/* Keith Cao
 * Day 1 of Advent of Code 2025
 * Two Star
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class star2 {
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
                counter += num / 100;
                //num between 0 and 99 now
                num %= 100;

                if(dir == 'L') {
                    num *= -1;
                }
                pos += num;
                
                if(pos > 99) {
                    pos -= 100;
                    counter++;
                } else if(pos < 0) {
                    if(pos - num != 0) {
                        counter++;
                    }
                    pos += 100;
                } else if(pos == 0) {
                    counter++;
                }

            }
            System.out.println(counter);

        } catch (FileNotFoundException e) {
            System.err.println("File not Found:" + e);
        } 
    }
}
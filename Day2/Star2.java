/* Keith Cao
 * Advent of Code 2025 Day 2 Star 2
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Star2 {

    public Star2() {
    }

    public static void main(String[] args) {
        try {
            File file = new File("Day2/input.txt");
            Scanner s = new Scanner(file);
            String str = s.nextLine();
            s.close();

            String[] inputs = str.split(",");
            Star2 star = new Star2();
            long total = 0;

            for(int i = 0; i < inputs.length; i++) {
                String[] parts = inputs[i].split("-");
                total += star.findInvalid(Long.parseLong(parts[0]), Long.parseLong(parts[1]));
            }
            
            System.out.println(total);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public long findInvalid(long min, long max) {
        long total = 0;

        for(long i = min; i <= max; i++) {
            String s = String.valueOf(i);
            StringBuilder substr = new StringBuilder();
            for (int j = 0; j < s.length() / 2; j++) {
                substr.append(s.charAt(j));

                String clear = s.replaceAll(substr.toString(), "");

                if (clear.length() == 0) {
                    total += i;
                    break;
                }
            }
        }
        return total;
    }
}
/* Keith Cao
 * Advent of Code 2025 Day 2 Star 1
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Star1 {

    public Star1() {
    }

    public static void main(String[] args) {
        try {
            File file = new File("Day2/input.txt");
            Scanner s = new Scanner(file);
            String str = s.nextLine();
            s.close();

            String[] inputs = str.split(",");
            Star1 star = new Star1();
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
            if(s.length() % 2 == 1) {
                i = (long)Math.pow(10, s.length());
            } else if(s.substring(0, s.length()/2).equals(s.substring(s.length()/2))){
                total += i;
            }
        }
        return total;
    }
}
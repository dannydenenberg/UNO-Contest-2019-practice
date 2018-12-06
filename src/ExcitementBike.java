import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExcitementBike {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String in = "";

        List<String> Q = new ArrayList<>();
        while (!(in=sc.nextLine()).equals("-1")){
            Q.add(in);
        }

        for (String s : Q) {
            List<Integer> nums =new ArrayList<>();
            String[] ss = s.split(" ");
            for (int i = 0; i < ss.length; i++) {
                nums.add(Integer.parseInt(ss[i]));
            }

            System.out.println(getGallonsFrom(nums) + " ultra-gallons of Excitement Fuel are required.");
        }

    }

    public static int getGallonsFrom(List<Integer> nums) {
        int gallons = 0;

        for (int i = 0; i < nums.size() - 1; i++) {
            if (i==0) {
                gallons++;
                continue;
            }

            if (nums.get(i) > nums.get(i - 1)){
                gallons+=(nums.get(i)-nums.get(i-1)) * 2;
            }
            // horizontal
            gallons++;
        }

        gallons++; // for some reason it needs one more
        return gallons;
    }
}

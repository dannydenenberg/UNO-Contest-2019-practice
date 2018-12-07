import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rising {
    public static void main(String[] args) {
        List<Integer> res=new ArrayList<>();
        Scanner sc =new Scanner(System.in);

        int in=-1;
        while ((in=sc.nextInt())!=0){
            int nRising= 0;
            for (int i=1;i<in;i++){
                if (isRising(i)) nRising++;
            }
            res.add(nRising);
        }



        for (Integer i : res) {
            System.out.println(i);
        }

    }

    public static boolean isRising(int n) {
        String s = "" +n;
        if (s.length()==1) return true;
        for (int i = 1; i < s.length(); i++) {
            if (!(s.charAt(i) > s.charAt(i-1)) )return false;
        }

        return true;
    }
}

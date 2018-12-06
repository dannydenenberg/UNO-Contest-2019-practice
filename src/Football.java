import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Football {
    public static void main(String[] args) {
        List<String> anss = new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        int in =0;


        while((in=sc.nextInt())!=0){
            anss.add(find(in));
        }

        for (String s:anss){
            System.out.println(s);
        }
    }

    public static String find(int n){

        int ep=0,tp=0,s=0,fg=0,td=0;

        while (n >= 6) {
            td++;
            n-=6;
        }

        while (n >=3){
            fg++;
            n-=3;
        }

        int touchDownOther=td;

        while(n>=2){
            if (touchDownOther>0){
                touchDownOther--;
                tp++;
            } else {
                s++;
            }

            n-=2;
        }

        while(n>=1){
            if (touchDownOther>0){
                ep++;
                touchDownOther--;
                n-=1;
            }
        }


        return "" + td + " TD + " + ep + " EP + " + tp + " TP + "+fg+" FG + "+s+ " S = " + (ep+tp*2+s*2+fg*3+td*6) + " points.";
    }
}

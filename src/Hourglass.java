import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hourglass {
    public static void main(String[] args) {

        List<String> anss= new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        int in=0;
        while ((in=sc.nextInt())!=0){
            anss.add(hourGlass(in));
        }

        for (String s:anss){
            System.out.println(s);
        }
    }

    public static String hourGlass(int n){
        char[][] glass = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                glass[i][j]=' ';
            }
        }

        // first row
        for (int i = 0; i < n; i++) {
            glass[0][i]='*';
        }

        // last row
        for (int i = 0; i < n; i++) {
            glass[n-1][i]='*';
        }

        int s=1;
        int e=n-2;

        //middle rows
        for (int i = 1; i <= n - 2; i++) {
            if (s<=e) {
                glass[i][s]='*';
                glass[i][e]='*';
            } else {
                for (int j = e; j <= s; j++) {
                    glass[i][j]='*';
                }
            }

            s++;
            e--;
        }


        return arrToString(glass);
    }

    //GOOD
    public static String arrToString(char[][] arr){
        String s ="";
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                s+=arr[i][j];
            }
            s+="\n";
        }

        return s;
    }
}

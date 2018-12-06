import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Format {
    public static void main(String[] args) {
        double d = Math.PI;
        double h = 1.999;

        DecimalFormat df = new DecimalFormat("#.00");
        DecimalFormat df2 = new DecimalFormat("#.##"); // drop any trailing zeros

        DECODEPROBLEM();



    }


    public static void DECODEPROBLEM() {




        Scanner sc=new Scanner(System.in);

        int c=sc.nextInt();
        sc.nextLine();

        List<String> res = new ArrayList<>();


        for (int i = 0; i < c; i++) {
            String[][] mat = new String[2000][5];
            for (int x = 0; x < 1000; x++) {
                mat[x] = new String[]{"","","","",""};
            }


            String s=sc.nextLine();
            int row=0,col=0;
            for (int j = 0; j < s.length(); j++) {
                mat[row][col] = ""+s.charAt(j);

                col++;
                if (col > 4) {
                    row++;col=0;
                }
            }
            boolean go = true;

            String result = "";
            for (int j = 0; j < mat[0].length; j++) {
                for (int k = 0; k < mat.length; k++) {
                    if (mat[k][j].equals("*")) {
                        result += " ";
                        continue;
                    }

                    if (mat[k][j].equals("")) {
                        break;
                    }

                    result+=mat[k][j];
                }
            }

            res.add(result);

        }


        for (String s : res) {
            System.out.println(s);
        }
    }




    public static void CELLBLOCKSCODINGPROBLEM() {
        char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        List<String> combos = new ArrayList<>();

        for (char let : letters) {
            for (char let2 : letters) {
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        combos.add("" + let + let2 + i + j);
                    }
                }
            }
        }

        List<List<String>> res = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int c=sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < c; i++) {
            String in=sc.nextLine();
            List<String> x = new ArrayList<>();

            if (in.equals("AA00")) {
                x.add("ZZ99");
                x.add("AA00");
                x.add("AA01");
                res.add(x);
                continue;
            }

            x.add((combos.get(((combos.indexOf(in) - 1) % combos.size()))));
            x.add((combos.get(((combos.indexOf(in)) % combos.size()))));
            x.add((combos.get(((combos.indexOf(in) + 1) % combos.size()))));
            res.add(x);

        }


        for (List ll: res) {
            for (Object s: ll) {
                String ss = (String)s;
                System.out.print(ss + " ");
            }
            System.out.println();
        }


    }


}
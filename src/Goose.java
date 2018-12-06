import sun.dc.pr.PRError;

import java.io.IOException;
import java.util.Scanner;

public class Goose {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        printV('S',10000);
    }


    public static void clrscr(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printV(char dir, int n) {

        int rows = n%2==0 ? n/2 : n/2+1;


        // init and set to spaces
        char[][] geese = new char[rows][n];
        for (int i = 0; i < geese.length; i++) {
            for (int j = 0; j < geese[0].length; j++) {
                geese[i][j] = ' ';
            }
        }


        int j=0,k=n-1;
        for (int i = 0; i < rows; i++) {
            geese[i][j]='W';
            geese[i][k]='W';

            j++;
            k--;

            if (j>k) break;
        }



        /********** ROTATE GEESE ************/

        // if already good dir (SOUTH)
        if (dir=='S') {
            printA(geese);
            return;
        }

        if (dir=='N') {
            printA(flip(geese));
            return;
        }




        printA(geese);


    }



    static void printA(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static char[][] flip(char[][] arr) {
        int j=0,k=arr.length -1;

        for (int i = 0; i < arr.length; i++) {
            char[] temp = arr[j];
            arr[j] = arr[k];
            arr[k]=temp;

            j++;
            k--;

            if (j>k) break;
        }

        return arr;
    }
}

import java.util.*;
import java.util.stream.Collectors;

/***
1
160
1007 1111
544 5000 448
148
0

 should be 2970
 */

public class LazyLarry {
    public static List<Integer> pages;
    public static void main(String[] args) {
        main2();


    }


    public static void main2() {
        List<Integer> answers=new ArrayList<>();


        pages = new ArrayList<>();
        Scanner sc=new Scanner(System.in);

        List<List<Integer>> bookList = new ArrayList<>();


        int cases=sc.nextInt();

        //clear buffer
        sc.nextLine();

        while (cases>0){
            List<Integer> in = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            if (in.get(0)==0){
                // call the function
                find(bookList,0,0,0);

                // add it to list of answers
                answers.add(Collections.min(pages));


                /**
                for (Integer i : pages) {
                    System.out.println(i + " --> page");
                }
                 **/


                //reset for next case
                cases--;
                pages=new ArrayList<>();
                bookList=new ArrayList<>();
                continue;
            }


            bookList.add(in);

        }




        for (Integer i : answers) {
            System.out.println(i + " pages.");
        }


    }

    // NOT SURE ABOUT INT C. NECESSARY?
    public static void find(List<List<Integer>> books, int r, int booksRead, int sum) {
        if (booksRead>5)return;
        if (booksRead==5){
            pages.add(sum);
            return;
        }

        if (r>=books.size())return;

        // recursively add none
        find(books,r+1,booksRead,sum);

        // recursively return sum of the books in the series going from first book to last
        for (int i = 0; i < books.get(r).size(); i++) {
            find(books,r+1,booksRead+i+1,sum+sumListFromStartTo(i,books.get(r)));
        }
    }

    // including start and end
    public static int sumListFromStartTo(int end,List<Integer> list){
        int sum = 0;
        for (int i = 0; i <= end; i++) {
            sum+=list.get(i);
        }
        return sum;
    }
}

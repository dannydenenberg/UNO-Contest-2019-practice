import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;


/**
 *
 *
 */

public class SkatingScoring {
    public static void main(String[] args) {
        List<String> res=new ArrayList<>();
        Scanner sc =new Scanner(System.in);

        DecimalFormat df = new DecimalFormat("#.00");

        String in ="";

        for (int i = 0; i < 3; i++) {
            in=sc.nextLine();
            res.add(df.format(getScore(in)));
        }


        for (String s : res){
            System.out.println(s);
        }

    }

    public static double getScore(String scores) {
        // first parse and make double
        List<Double> scoresList = Arrays.stream(scores.split(" ")).map(Double::parseDouble).collect(Collectors.toList());

        Collections.sort(scoresList);

        scoresList.remove(0);
        scoresList.remove(scoresList.size()-1);

        double average = 0.0;

        for (double sc : scoresList) {
            average += sc;
        }

        average /= scoresList.size();

        return average;
    }
}

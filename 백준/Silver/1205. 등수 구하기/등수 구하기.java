import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //get n, score, p
        StringTokenizer stkn1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stkn1.nextToken());
        int newScore = Integer.parseInt(stkn1.nextToken());
        int boardLength = Integer.parseInt(stkn1.nextToken());
        int output = 1;

        List<Integer> leaderBoard = new ArrayList<>();

        if (n != 0) {
            StringTokenizer stkn2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                leaderBoard.add(Integer.parseInt(stkn2.nextToken()));
            }
            leaderBoard.sort(Comparator.reverseOrder());


            if (n == boardLength && newScore <= leaderBoard.get(n-1)) {
                output = - 1;
            } else {
                for (int i = 0; i < n; i++) {
                    if (newScore < leaderBoard.get(i)) {
                        output++;                        
                    } else {
                        break;
                    }
                }
            }
        }

        br.close();
        System.out.println(output);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

class Human{
    int height;
    int weight;

    public Human(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public static int compare (Human human1, Human human2){
        int result = 0;
        //if second human is bigger than first, then add 1
        if (human1.weight < human2.weight && human1.height < human2.height){
            result = 1;
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Human[] humanArray = new Human[n];
        int rank = 1;
        //Get input and store in array
        for (int i = 0; i < n; i++) {
            StringTokenizer stkn = new StringTokenizer(br.readLine());
            humanArray[i] = new Human(Integer.parseInt(stkn.nextToken()), Integer.parseInt(stkn.nextToken()));
        }
        br.close();

        for (int i = 0; i < n; i++) {
            rank = 1;
            for (int j = 0; j < n; j++) {
                if (i != j){
                    rank += Human.compare(humanArray[i], humanArray[j]);
                }
            }
            sb.append(rank + " ");
        }
        System.out.println(sb.toString().trim());
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] head = new int[2];
        //left arm, right arm, back, left leg, right leg
        int[] body = {0, 0, 0, 0, 0};
        //integer for counting * for checking back
        int count = 0;
        int n = Integer.parseInt(br.readLine());

        //flag for finding head
        boolean headFound = false;
        char[][] plateMatrix = new char[n][n];

        //convert input Strings to char matrix
        for (int i = 0; i < n; i++) {
            String inputString = br.readLine();
            plateMatrix[i] = inputString.toCharArray();
 
        }
        br.close();
        //finding head
        for (int i = 0; i < n && !headFound; i++) {
            for (int j = 0; j < n && !headFound; j++) {
                if (plateMatrix[i][j] == '*'){
                    // add 1 for each because plate starts with 1, 1 and add 1 for x
                    sb.append((i + 2) + " " + (j + 1) + "\n");
                    headFound = true;
                    head[0] = i;
                    head[1] = j;
                }
            }
        }
        //check next line of head for arms
        for (int j = 0; j < n; j++) {
            //if j is less than head.y it is left arm vice versa
            if (j < head[1] && plateMatrix[head[0] + 1][j] == '*'){
                body[0]++;
            } else if (j > head[1] && plateMatrix[head[0] + 1][j] == '*'){
                body[1]++;
            }
        }
        //check next line of arms for back
        for (int i = head[0] + 2; i < n; i++) {
            count = 0;
            for (char c : plateMatrix[i]) {
                if (c == '*') {
                    count++;
                }
            }
            if (count != 1) {
                break;
            }
            body[2]++;
        }
        //check leg
        for(int i = head[0] + 2 + body[2]; i < n; i++){
            for (int j = head[1] - 1; j < head[1] + 2; j++) {
                if (j < head[1] && plateMatrix[i][j] == '*') {
                    body[3]++;
                } else if (j > head[1] && plateMatrix[i][j] == '*') {
                    body[4]++;
                }
            }
        }

        sb.append(body[0] + " " + body[1] + " " + body[2] + " " + body[3] + " " + body[4]);

        System.out.println(sb.toString().trim());
    }
}
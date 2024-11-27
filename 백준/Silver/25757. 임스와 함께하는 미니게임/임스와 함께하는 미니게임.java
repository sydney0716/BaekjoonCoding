import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stkn = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stkn.nextToken());
        char gameType = stkn.nextToken().charAt(0);
        Set<String> nameSet = new HashSet<>();
        int output = 0;

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            nameSet.add(name);
        }
        br.close();

        switch (gameType) {
            case 'Y':
                output = nameSet.size();
                break;
            case 'F':
                output = nameSet.size() / 2;
                break;
            case 'O':
                output = nameSet.size() / 3;  
                break;
            default:
                break;
        }

        System.out.println(output);
    }
}
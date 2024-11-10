import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] channelArray = new String[n];

        for (int i = 0; i < n; i++) {
            channelArray[i] = br.readLine();
        }
        int kbs1 = Arrays.asList(channelArray).indexOf("KBS1");
        for (int i = 0; i < kbs1; i++) {
            sb.append("1");
        }
        
        for (int i = 0; i < kbs1; i++) {
            sb.append("4");
        }
        
        int kbs2 = Arrays.asList(channelArray).indexOf("KBS2");
        if (kbs2 < kbs1) {
            kbs2++;
        }
        
        for (int i = 0; i < kbs2; i++) {
            sb.append("1");
        }
        
        for (int i = 0; i < kbs2 - 1; i++) {
            sb.append("4");
        }
        br.close();
        System.out.println(sb.toString().trim());
    }
}
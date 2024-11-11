import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int[] add(int[] intArray, int n){
        intArray[n - 1] = 1;
        return intArray;
    }
    public static int[] remove(int[] intArray, int n){
        intArray[n - 1] = 0;
        return intArray;
    }
    public static int check(int[] intArray, int n){
        return intArray[n - 1];
    }
    public static int[] toggle(int[] intArray, int n){
        if (intArray[n - 1] == 0){
            intArray[n - 1] = 1;
        } else{
            intArray[n - 1] = 0;
        }
        return intArray;
    }
    public static int[] all(){
        int[] intArray = new int[20];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = 1;
        }
        return intArray;
    }
    public static int[] empty(){
        int[] intArray = new int[20];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = 0;
        }
        return intArray;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] inputLine = new String[2];
        
        int[] S = empty();

        for (int i = 0; i < n; i++) {
            inputLine = br.readLine().split(" ");
            switch (inputLine[0]) {
                case "add":
                    S = add(S, Integer.parseInt(inputLine[1]));
                    break;
                case "remove":
                    S = remove(S, Integer.parseInt(inputLine[1]));
                    break;
                case "check":
                    sb.append(check(S, Integer.parseInt(inputLine[1])));
                    sb.append("\n");
                    break;
                case "toggle":
                    S = toggle(S, Integer.parseInt(inputLine[1]));
                    break;
                case "all":
                    S = all();
                    break;
                case "empty":
                    S = empty();
                    break;
                default:
                    break;
            }

        }
        System.out.println(sb.toString().trim());
        br.close();
    }
}
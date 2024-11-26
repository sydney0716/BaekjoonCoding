import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            //initialize count and flag
            boolean flg = true;
            int vowelCount = 0;
            int consecCount = 0;
            char prev = '.';
            char current = '.';
            //boolean for vowel
            boolean isVowel = false;
            
            //read input
            String password = br.readLine();
            //if input is end break the infinite loop
            if (password.equals("end")){
                break;
            }
            
            //check by each character if password is okay
            for (int i = 0; i < password.length(); i++) {
                current = password.charAt(i);
                if (i != 0 && isVowel == isVowel(current)){
                    consecCount++;
                } else {
                    consecCount = 0;
                }
                
                isVowel = isVowel(current);
                if (isVowel) {
                    vowelCount++;
                }
                
                //if previous character and current character is same, and it is not e and o or vowel/consonant is repeated 3 times then break, and make flag flase
                if ((prev == current && current != 'e' && current != 'o') || consecCount >= 2){
                    flg = false;
                    break;
                }
                //set current character as previous character
                prev = current;
            }
            
            if (vowelCount == 0 || !flg){
                sb.append("<" + password + "> is not acceptable." + "\n");
            } else {
                sb.append("<" + password + "> is acceptable." + "\n");
            }
            
        }
        br.close();
        System.out.println(sb.toString());
    }
    
    public static boolean isVowel(char c){
        return "aeiou".indexOf(c) != -1;
    }
}
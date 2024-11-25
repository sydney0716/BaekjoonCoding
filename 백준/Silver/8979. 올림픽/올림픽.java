import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

class Country{
    public int id;
    public int gold;
    public int silver;
    public int bronze;
    //Initialize
    public Country(int id, int gold, int silver, int bronze){
        this.id = id;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    public static int compare(Country country1, Country country2){ 
        int flg = 1;
        if (country2.gold > country1.gold){
            flg = 2;
        } else if (country1.gold == country2.gold) {
            //compare silver medal
            if (country2.silver > country1.silver) {
                flg = 2;
            } else if (country1.silver == country2.silver) {
                //compare bronze medal
                if (country2.bronze > country1.bronze) {
                    flg = 2;
                } else if (country1.bronze == country2.bronze) {
                    //tie
                    flg = 0;
                }
            }
        }
        //if country 1 is high then 1, country 2 then 2, tie then 0
        return flg;
    } 
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stkn = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stkn.nextToken());
        int k = Integer.parseInt(stkn.nextToken()) - 1;
        Country[] countryArray = new Country[n];
        int rank = 1;
        int id = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer stknCountry = new StringTokenizer(br.readLine());
            id = Integer.parseInt(stknCountry.nextToken()) - 1;
            countryArray[id] = new Country(id, Integer.parseInt(stknCountry.nextToken()), Integer.parseInt(stknCountry.nextToken()), Integer.parseInt(stknCountry.nextToken()));
        }

        for (int i = 0; i < n; i++) {
            //compare with other but exclude itself
            if (i != k){
                //compare with other countries and if other contry is higher, add 1 to rank
                if (Country.compare(countryArray[k], countryArray[i]) == 2){
                    rank++;
                }
            }
        }
        br.close();
        System.out.println(rank);
    }
}
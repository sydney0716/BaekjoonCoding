import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point {
    int x = 0, y = 0;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    //두 점이 같다면 true return
    static boolean comparePoints(Point pt1, Point pt2){
        return (pt1.x == pt2.x && pt1.y == pt2.y);
    }

    //두 점의 거리 계산
    static double distance(Point pt1, Point pt2){
        return Math.sqrt(Math.pow(pt1.x - pt2.x,2) + Math.pow(pt1.y - pt2.y, 2));
    }
}

class Turret extends Point{
    int r = 0;

    Turret(int x, int y, int r){
        super(x, y);
        this.r = r;
    }

    //input이 array일 때 Constructor
    Turret(int[] arr){
        super(arr[0], arr[1]);
        this.r = arr[2];
    }

    //둘이 같은 터렛인지 확인
    boolean compareTurrents(Turret tur) {
        return Point.comparePoints(this, tur) && this.r == tur.r;
    }


    public int findEnemy(Turret tur){
        int enemy = 0;
        //만약 터렛의 중심이 같고 반지름도 같다면 둘의 교점은 무수하 많음
        if (this.compareTurrents(tur)){
            enemy = -1;
        } else {
            double distance = distance(this, tur);
            if (distance > this.r + tur.r){
                //터렛이 서로 다르고 두 중심 사이의 거리가 반지름의 합보다 크다면 교점이 존재하지 않음
                enemy = 0;
            } else if (distance == this.r + tur.r) {
                //두 중심 사이의 거리가 반지름의 합과 같다면 접함
                enemy = 1;
            } else {
                int max = Math.max(this.r, tur.r);
                int min = Math.min(this.r, tur.r);

                if (distance + min < max) {
                    //중심 사이의 거리에 작은 원의 반지름을 더한 값이 큰 원의 반지름 보다 작다면, 큰 원의 내부에 있음
                    enemy = 0;
                } else if (distance + min == max) {
                    //중심 사이의 거리에 작은 원의 반지름을 더한 값이 큰 원의 반지름과 같다면, 큰 원의 내부에 접함
                    enemy = 1;
                } else
                    //중심 사이의 거리에 작은 원의 반지름을 더한 값이 큰 원의 반지름 보다 크다면, 두 점에서 접함
                    enemy = 2;
                }
            }
        return enemy;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] inptArr = new int[3];
        //input은 T, T만큼 반복
        int T = Integer.parseInt(br.readLine());
        int enemy = 0;
        for (int i = 0; i < T; i++) {
            //input 읽기 위한 string tokenizer
            StringTokenizer stkn = new StringTokenizer(br.readLine());
            //다음 x1, y1, r1, x2, y2, r2
            inptArr[0] = Integer.parseInt(stkn.nextToken());
            inptArr[1] = Integer.parseInt(stkn.nextToken());
            inptArr[2] = Integer.parseInt(stkn.nextToken());
            Turret tur1 = new Turret(inptArr);

            inptArr[0] = Integer.parseInt(stkn.nextToken());
            inptArr[1] = Integer.parseInt(stkn.nextToken());
            inptArr[2] = Integer.parseInt(stkn.nextToken());
            Turret tur2 = new Turret(inptArr);


            System.out.println(tur1.findEnemy(tur2));

        }
    }
}

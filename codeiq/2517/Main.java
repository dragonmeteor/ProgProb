import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    int[][] table;
    int[][] position;
    boolean[] isPrime;

    void run() {
        fillTable();
        fillIsPrime();

        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.valueOf(input.readLine());

            int minDistance = Integer.MAX_VALUE;
            ArrayList<Integer> nearest = new ArrayList<>();
            for (int k = 1; k < 2000*2000+1; k++) {
                if (!isPrime[k])
                    continue;
                if (distance(k, n) < minDistance) {
                    minDistance = distance(k, n);
                    nearest.clear();
                    nearest.add(k);
                } else if (distance(k,n) == minDistance){
                    nearest.add(k);
                }
            }

            for (int i = 0; i < nearest.size(); i++) {
                System.out.print(nearest.get(i));
                if (i < nearest.size()-1)
                    System.out.print(",");
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    int distance(int a, int b) {
        int dx = position[a][0] - position[b][0];
        int dy = position[a][1] - position[b][1];
        return dx*dx + dy*dy;
    }

    void fillTable() {
        table = new int[2000][2000];
        position = new int[2000*2000+1][2];

        int num = 1;
        for (int k = 0; k < 2000; k++) {
            for (int i = 0; i < k+1; i++) {
                table[i][k] = num;
                position[num][0] = i;
                position[num][1] = k;
                num++;
            }
            for (int i= k-1; i>= 0; i--) {
                table[k][i] = num;
                position[num][0] = k;
                position[num][1] = i;
                num++;
            }
        }
    }

    void fillIsPrime() {
        isPrime = new boolean[2000*2000+1];
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }
        for (int k = 2; k < 2002; k++) {
            int num = 2*k;
            while (num < isPrime.length) {
                isPrime[num] = false;
                num += k;
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) {
        final int LEFT = 0;
        final int RIGHT = 1;

        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.valueOf(input.readLine());
            BigInteger[][][] c = new BigInteger[5][2][N+1];

            for (int x=0;x<5;x++) {
                c[x][RIGHT][0] = BigInteger.ZERO;
                c[x][LEFT][0] = BigInteger.ZERO;
            }
            c[2][RIGHT][0] = BigInteger.ONE;
            c[3][RIGHT][0] = BigInteger.ONE;
            c[4][RIGHT][0] = BigInteger.ONE;

            for (int n=1;n<=N;n++) {
                for (int x = 0; x < 5; x++) {
                    c[x][RIGHT][n] = BigInteger.ZERO;
                    for (int y = 1; y < x; y++) {
                        c[x][RIGHT][n] = c[x][RIGHT][n].add(c[y][LEFT][n-1]);
                    }
                }

                for (int x = 0; x < 5; x++) {
                    c[x][LEFT][n] = BigInteger.ZERO;
                    for (int y = x+1; y < 4; y++) {
                        c[x][LEFT][n] = c[x][LEFT][n].add(c[y][RIGHT][n-1]);
                    }
                }
            }

            BigInteger answer = BigInteger.ZERO;
            for (int n = 0; n < N + 1; n++) {
                answer = answer.add(c[0][LEFT][n]);
            }
            System.out.println(answer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        new Main().run();

    }

    private void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            String line = input.readLine();
            int n = Integer.valueOf(line);

            long result = 0;
            long Cnk = 1;
            for (int k=0;k<=n;k++) {
                result += countCash(Cnk);
                Cnk *= n-k;
                Cnk /= k+1;
            }
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    long[] cashes = {10000,5000,2000,1000,500,100,50,10,5,1};

    private long countCash(long x) {
        long result = 0;
        for (int i = 0; i < cashes.length; i++) {
            result += x / cashes[i];
            x %= cashes[i];
        }
        return result;
    }

}

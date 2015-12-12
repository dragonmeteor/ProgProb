import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    HashMap<Long, Long> count = new HashMap<>();
    long[] powers11;

    public static void main(String[] args) {
        new Main().run();
    }

    public int getRowToRemove(long config) {
        int maxPos = 0;
        long maxSoFar = 0;
        for (int i = 0; i < 11; i++) {
            long digit = config % 11;
            if (maxSoFar <= digit) {
                maxSoFar = digit;
                maxPos = i;
            }
            config /= 11;
        }
        return maxPos;
    }

    long getDigit(long config, int pos) {
        return (config / powers11[pos]) % 11;
    }

    long getCount(long config) {
        if (!count.containsKey(config)) {
            if (config == 0) {
                count.put(config, 1L);
            } else {
                int row = getRowToRemove(config);
                // Check rep
                long r0 = getDigit(config, row);
                long r1 = (row >= 1) ? (getDigit(config, row-1)) : 0;
                long r2 = (row >= 3) ? (getDigit(config, row-2)) : 0;
                long r3 = (row >= 3) ? (getDigit(config, row-3)) : 0;
                // 1x1
                long result = getCount(config - powers11[row]);
                // 2x2
                if (r0 >= 2 && r1 >= 2 && r1 == r0) {
                    result += (getCount(config - 2*powers11[row] - 2*powers11[row-1]));
                }
                // 4x2
                if (r0 >= 4 && r1 >= 4 && r1 == r0) {
                    result += (getCount(config - 4*powers11[row] - 4*powers11[row-1]));
                }
                // 4x4
                if (r0 >= 4 && r1 >= 4 && r2 >= 4 && r3 >= 4 && r1 == r0 && r2 == r0 && r3 == r0) {
                    result += (getCount(config - 4*powers11[row] - 4*powers11[row-1] - 4*powers11[row-2] - 4*powers11[row-3]));
                }
                count.put(config, result);
            }
        }
        return count.get(config);
    }

    public void run() {
        powers11 = new long[12];
        powers11[0] = 1;
        for (int i = 1; i < 12; i++) {
            powers11[i] = powers11[i-1]*11;
        }

        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            String line = input.readLine();
            String[] comps = line.split(",");
            int M = Integer.valueOf(comps[0]);
            int N = Integer.valueOf(comps[1]);

            long config = 0;
            for (int i = 0; i < N; i++) {
                config *= 11;
                config += M;
            }

            System.out.println(getCount(config));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

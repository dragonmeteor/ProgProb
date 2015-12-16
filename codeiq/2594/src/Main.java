import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    int n;
    int[] socks;
    long[] power2;
    HashMap<Long, Integer> minCost = new HashMap<>();

    public static void main(String[] args) {
        new Main().run();
    }

    public void printConfig(long config) {
        long lastNode = (config / power2[n]);
        long flags = config % power2[n];
        for (int i = 0; i < n; i++) {
            if ((flags & power2[i]) == 0)
                System.out.print("0");
            else
                System.out.print("1");
        }
        System.out.print(" ");
        System.out.print(lastNode);
    }

    public int getMinCost(long config) {
        if (!minCost.containsKey(config)) {
            int lastNode = (int)(config / power2[n]);
            long flags = config % power2[n];
            int weight = 0;
            for (int i = 0; i < n; i++) {
                if ((flags & power2[i]) == 0) {
                    weight += socks[i];
                }
            }
            weight += socks[lastNode];

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (i != lastNode && (flags & power2[i]) != 0) {
                    int cost = getMinCost((flags - power2[lastNode]) + power2[n]*i) + socks[i]*socks[lastNode]*weight;
                    if (min > cost) {
                        min = cost;
                    }
                }
            }
            minCost.put(config, min);
            //printConfig(config);
            //System.out.println(": " + min);
        }
        return minCost.get(config);
    }

    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            String line = input.readLine();
            n = Integer.valueOf(line);
            socks = new int[n];
            for (int i = 0; i < n; i++) {
                line = input.readLine();
                socks[i] = Integer.valueOf(line);
            }
            power2 = new long[n+1];
            power2[0] = 1L;
            for (int i = 1; i <= n; i++) {
                power2[i] = power2[i-1]*2;
            }

            // Initialize.
            for (int i = 0; i < n; i++) {
                minCost.put(power2[i] + power2[n] * i, 0);
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                long config = power2[n] - 1 + power2[n]*i;
                int cost = getMinCost(config);
                if (min > cost) {
                    min = cost;
                }
            }
            System.out.println(min);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

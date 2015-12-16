import java.util.ArrayDeque;
import java.util.HashMap;

public class Main {
    long[] power10 = new long[10];
    int[][] moves = new int[][] {
            {5,6},
            {5,6,7},
            {6,7,8},
            {7,8,9},
            {8,9},
            {0,1},
            {0,1,2},
            {1,2,3},
            {2,3,4},
            {3,4}
    };
    HashMap<Long, Integer> moveCount = new HashMap<>();
    HashMap<Long, Long> last = new HashMap<>();

    public long encode(long[] config) {
        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += power10[i] * config[i];
        }
        return result;
    }

    public long getDigit(long config, int k) {
        return (config / power10[k]) % 10;
    }

    public long swap(long config, int a, int b) {
        long aa = getDigit(config, a);
        long bb = getDigit(config, b);
        return config - aa*power10[a] - bb*power10[b] + aa*power10[b] + bb*power10[a];
    }

    public static void main(String[] args) {
        new Main().run();
    }


    public void printConfig(long config) {
        for (int i = 0; i < 5; i++) {
            char digit = (char)getDigit(config, i);
            System.out.print(String.format("%c", digit + 'A'));
        }
        System.out.println();
        for (int i = 5; i < 10; i++) {
            char digit = (char)getDigit(config, i);
            System.out.print(String.format("%c", digit + 'A'));
        }
        System.out.println();
        System.out.println();
    }

    void printPath(long config, long start) {
        if (config != start) {
            printPath(last.get(config), start);
        }
        printConfig(config);
    }

    public void run() {
        power10[0] = 1L;
        for (int i = 1; i < 10; i++) {
            power10[i] = power10[i-1] * 10;
        }

        long start = encode(new long[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        long end = encode(new long[] {9, 1, 2, 3, 4, 5, 6, 7, 8, 0});

        //printConfig(start);
        //printConfig(end);

        moveCount.put(start, 0);
        ArrayDeque<Long> queue = new ArrayDeque<>();
        queue.addLast(start);
        while (!moveCount.containsKey(end)) {
            long current = queue.removeFirst();
            int currentCount = moveCount.get(current);
            int aPos = 0;
            for (int i = 0; i < 10; i++) {
                if (getDigit(current,i) == 0) {
                    aPos = i;
                    break;
                }
            }
            for (int i = 0; i < moves[aPos].length; i++) {
                long next = swap(current, aPos, moves[aPos][i]);
                if (!moveCount.containsKey(next)) {
                    queue.addLast(next);
                    moveCount.put(next, currentCount+1);
                    last.put(next, current);
                }
            }
        }

        System.out.println(moveCount.get(end));
        //printPath(end, start);
    }
}

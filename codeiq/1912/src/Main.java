import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    int n;
    ArrayList<HashSet<Integer>> neighbors = new ArrayList<>();

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            String line = input.readLine();
            n = Integer.valueOf(line);
            for (int i = 0; i < n; i++) {
                neighbors.add(new HashSet<>());
            }

            line = input.readLine();
            while (line != null) {
                String[] comps = line.trim().split(" ");
                int u = Integer.valueOf(comps[0])-1;
                int v = Integer.valueOf(comps[1])-1;
                neighbors.get(u).add(v);
                neighbors.get(v).add(u);
                line = input.readLine();
            }

            int max = 0;
            for (int u = 0; u < n; u++) {
                for (int v = u+1; v < n; v++) {
                    HashSet<Integer> U = new HashSet<>(neighbors.get(u));
                    U.retainAll(neighbors.get(v));
                    if (max < U.size()) {
                        max = U.size();
                    }
                }
            }
            System.out.println(max);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

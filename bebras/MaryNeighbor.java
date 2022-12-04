import java.io.*;
import java.util.StringTokenizer;

public class MaryNeighbor {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    /*
    Input:
    8
    0 0 1 1 1 1 0 0
    0 0 0 0 0 1 0 1
    1 0 0 1 0 0 0 0
    1 0 1 0 1 0 1 0
    1 0 0 1 0 1 1 0
    1 1 0 0 1 0 1 1
    0 0 0 1 1 1 0 0
    0 1 0 0 0 1 0 0
    Output:
    4
    */
    static class Task {
        public void solve(InputReader in, PrintWriter out) {
            // Read input
            int n = in.nextInt();
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = in.nextInt();
                }
            }
            // Compute degrees
            int[] degrees = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    degrees[i] += map[i][j];
                }
            }
            // Find out who is mary
            for (int i = 0; i < n; i++) {
                if (degrees[i] == 2) {
                    int count = 0;
                    for (int j = 0; j < n; j++) {
                        if (map[i][j] == 1 && degrees[j] == 4) {
                            count++;
                        }
                    }
                    if (count == 2) {
                        // This is Niki
                        for (int j = 0; j < n; j++) {
                            // Add code here to find out Mary

                        }
                    }
                }
            }

        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}

import java.io.*;
import java.util.StringTokenizer;

public class Movie {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    // Example 1:
    /*
    Input:
    6 7
    3 3 3 3 3 3 3
    2 3 3 2 2 3 3
    1 1 1 2 1 1 1
    1 2 2 2 1 2 1
    3 2 1 1 2 3 3
    2 1 2 1 3 2 2
    Output:
    2
    */
    // Example 2:
    /*
    Input:
    1 1
    1
    Output:
    0
    */
    // Example 3:
    /*
    Input:
    5 3
    3 1 3
    3 1 2
    1 2 1
    1 2 2
    1 2 1
    Output:
    2
    */
    static class Task {
        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] ratings = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ratings[i][j] = in.nextInt();
                }
            }
            // Add code here to output the minimum number of changes

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

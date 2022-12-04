import java.io.*;
import java.util.StringTokenizer;

public class NutsBolts {
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
    // Input:
    // NNBBNBNNNB
    // Output:
    // No
    // Example 2:
    // Input:
    // NBNNBNNBBB
    // Output:
    // Yes
    // Example 3:
    // Input:
    // NNBNNBBBBN
    // Output:
    // No
    static class Task {
        public void solve(InputReader in, PrintWriter out) {
            String s = in.next();
            String ans = "No";
            int diff = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'N') {
                    diff++;
                } else {
                    diff--;
                    if (diff < 0) {
                        break;
                    }
                }
            }
            if (diff == 0) {
                ans = "Yes";
            }
            out.println(ans);
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

import java.io.*;
import java.util.StringTokenizer;

public class cipher8 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();

    }

    static class Task {
        void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            String[] dict = new String[n];
            for (int i = 0; i < n; i++) {
                dict[i] = in.next();
            }
            String word = in.next();
            int lastIndex = 0; // added line 1
            for (int j = 0; j < word.length(); j++) {
                String s = word.substring(j, j + 1);
                for (int i = 0; i < n; i++) {
                    int index = (lastIndex + i) % n; // added line 2
                    int pos = dict[index].indexOf(s); // changed line
                    if (pos >= 0) {
                        if (j > 0) {
                            out.print("-");
                        }
                        out.print(i);
                        out.print(pos + 1);
                        lastIndex = index; // added line 3
                        break;
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
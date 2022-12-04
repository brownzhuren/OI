import java.io.*;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class TicTacToe {
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
    3
    xox
    oxo
    oox
    Output:
    No
    */
    // Example 2:
    /*
    Input:
    3
    xox
    ox-
    oxx
    Output:
    No
    */
    // Example 3
    /*
    Input:
    3
    xxo
    -ox
    oox
    Output:
    Yes
    */
    // Example 4
    /*
    Input:
    3
    xox
    oxo
    ox-
    Output:
    No
    */
    static class Task {
        // Returns 1 if x wins, 2 if o wins, 3 if both wins, 0 if no one wins
        int whoWins(int[][] board, int n) {
            boolean xw = false;
            boolean ow = false;
            int sum_diag = 0;
            int sum_diag_other = 0;
            // Check each row and column
            for (int i = 0; i < n; i++) {
                sum_diag += board[i][i];
                sum_diag_other += board[i][n - 1 - i];
                int sum_row = 0;
                int sum_col = 0;
                for (int j = 0; j < n; j++) {
                    sum_row += board[i][j];
                    sum_col += board[j][i];
                }
                if (sum_row == n || sum_col == n) {
                    xw = true;
                }
                if (sum_row == -n || sum_col == n) {
                    ow = true;
                }
            }
            // Check the diagonals
            if (sum_diag == n || sum_diag_other == n) {
                xw = true;
            }
            if (sum_diag == -n || sum_diag_other == -n) {
                ow = true;
            }
            // Output answer
            int ans = 0;
            if (xw) {
                ans++;
            }
            if (ow) {
                ans += 2;
            }
            return ans;
        }

        void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[][] board = new int[n][n];
            int countX = 0;
            int countO = 0;
            for (int i = 0; i < n; i++) {
                String s = in.next();
                for (int j = 0; j < n; j++) {
                    if (s.charAt(i) == 'x') {
                        board[i][j] = 1;
                        countX++;
                    } else {
                        board[i][j] = -1;
                        countO++;
                    }
                }
            }
            // Add code here to complete the program

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
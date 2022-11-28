import java.io.*;
import java.util.*;

class Solver {
    void solve(InputReader in, PrintWriter out) throws IOException {
        
    }
}

public class Solution {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            PrinterWriter out = new PrintWriter(System.out);
            new Solver().solve(in, out);
            out.close();
        } catch (IOException e) {
        }
    }
}

class InputReader {
    BufferedReader reader;
    StringTokenizer tokenizer;

    InputReader(InputStream in) {
        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = new StringTokenizer("");
    }

    String nextToken() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
}

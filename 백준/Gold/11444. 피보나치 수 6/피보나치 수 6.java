import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final long MOD = 1_000_000_007L;

    static class Mat2 {
        long a, b, c, d;
        Mat2(long a, long b, long c, long d) {
            this.a = a; this.b=b; this.c=c; this.d=d;
        }
    }

    static Mat2 mul(Mat2 x, Mat2 y) {
        long na = (x.a * y.a + x.b * y.c) % MOD;
        long nb = (x.a * y.b + x.b * y.d) % MOD;
        long nc = (x.c * y.a + x.d * y.c) % MOD;
        long nd = (x.c * y.b + x.d * y.d) % MOD;
        return new Mat2(na, nb, nc, nd);
    }

    static Mat2 pow(Mat2 x, long exp) {
        Mat2 res = new Mat2(1, 0, 0, 1);
        while (exp > 0) {
            if ((exp & 1L) == 1L) res = mul(res, x);
            x = mul(x, x);
            exp >>= 1;
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());

        Mat2 A = new Mat2(1, 1, 1, 0);
        Mat2 An = pow(A, n);

        System.out.println(An.b % MOD);

    }

}
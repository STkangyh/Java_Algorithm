import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] S = new int[305];
        int t = 0;
        for (int i = 1; i <= n; i++) {
            S[i] = Integer.parseInt(br.readLine());
            t += S[i];
        }
        int[] dp = new int[305]; // i번째 계단까지 밟지 않을 계단의 합의 최솟값
        if (n > 2){
            dp[1] = S[1];
            dp[2] = S[2];
            dp[3] = S[3];
            for (int i = 4; i < n; i++) {
                dp[i] = S[i] + Math.min(dp[i - 2], dp[i - 3]);
            }
            System.out.println(t - Math.min(dp[n-1], dp[n-2]));
        } else {
            System.out.println(t);
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9095 {
    static int[] arr;
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        arr = new int[T];
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
        }
        d = new int[20]; // n번째 수를 3가지 방법으로 표현할 수 있는 개수
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for (int i = 4; i < 12; i++) {
            d[i] = d[i-1] + d[i-2] + d[i-3];
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(d[arr[i]]);
        }
    }
}
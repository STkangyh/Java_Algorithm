import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7576 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static int M, N;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        int x = 0, y = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        while (!q.isEmpty()) {
            int[] a = q.poll();
            int j = a[0];
            int k = a[1];
            for (int i = 0; i < 4; i++) {
                //Printing();
                //System.out.println();
                int nx = j + dx[i];
                int ny = k + dy[i];
                if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[0].length)
                    continue;
                if (arr[nx][ny] == 0){
                    arr[nx][ny] = arr[j][k] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        int max = Integer.MIN_VALUE;
        if (checkZero())
            return -1;
        else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (max < arr[i][j])
                        max = arr[i][j];
                }
            }
            return max - 1;
        }
    }
    static boolean checkZero(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0)
                    return true;
            }
        }
        return false;
    }

    static void Printing() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println( );
        }
    }
}
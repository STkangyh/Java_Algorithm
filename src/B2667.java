import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B2667 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static int N;
    static int num = 0;
    static ArrayList<Integer> answer;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        answer = new ArrayList<>();
        cnt = 1;
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(row.charAt(j) + "");
            }
        }
        //Printing();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != 0){
                    DFS(i, j);
                    //Printing();
                    answer.add(cnt);
                    cnt = 1;
                    num++;
                }
            }
        }
        Collections.sort(answer);
        System.out.println(num);
        for (int i = 0; i < num; i++) {
            System.out.println(answer.get(i));
        }
    }
    static void DFS(int x, int y){
        arr[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length && arr[nx][ny] != 0) {
                cnt++;
                DFS(nx, ny);
                //Printing();
            }
        }
    }
    static void Printing(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
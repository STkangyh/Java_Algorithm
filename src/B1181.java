import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2); // 사전 순 정렬
                }
                else {
                    return s1.length() - s2.length();
                }
            }
        });

        System.out.println(arr[0]);
        for (int i = 1; i < n; i++) {
            if (!arr[i].equals(arr[i-1])) {
                System.out.println(arr[i]);
            }
        }
    }
}
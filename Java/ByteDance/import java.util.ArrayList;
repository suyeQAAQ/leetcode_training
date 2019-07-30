import java.util.Scanner;

public class solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < t; i++) {
            String s = sc.nextLine();
            String[] ss = s.split(" ");
            long n = Long.parseLong(ss[0]);
            long k = Long.parseLong(ss[1]);
            long d1 = Long.parseLong(ss[2]);
            long d2 = Long.parseLong(ss[3]);
            boolean target = game(n, k, d1, d2) || game(n, k, -d1, d2) || game(n, k, d1, -d2) || game(n, k, -d1, -d2);

            System.out.println(target ? "yes" : "no");
        }
    }

    public static boolean game(long n, long k, long d1, long d2) {
        long temp1 = 2 * d1 + d2;
        long temp2 = n - k;
        if (k >= temp1 && (k - temp1) % 3 == 0) {
            if ((temp1 + temp2) >= 0 && (temp1 + temp2) % 3 == 0 &&
                    (k - temp1) / 3 <= n / 3 &&
                    (k - temp1) / 3 + d1 <= n / 3 &&
                    (k - temp1) / 3 + d1 + d2 <= n / 3
            ) return true;
            else return false;
        } else {
            return false;
        }
    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nm = sc.nextLine();
        String[] temp = nm.split(" ");
        int m = Integer.parseInt(temp[1]);
        String s = sc.nextLine();
        System.out.println(Math.max(opt(m, s, 'a'), opt(m, s, 'b')));
    }

    public static int opt(int m, String s, char c) {

        ArrayList<Integer> index = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) index.add(i);
        }
        index.add(s.length());

        if (m >= index.size()) return s.length();
        int max = index.get(m);

        for (int i = m + 1; i < index.size(); i++) {
            max = Integer.max(max, index.get(i) - index.get(i - m - 1) - 1);
        }

        return max;
    }
}
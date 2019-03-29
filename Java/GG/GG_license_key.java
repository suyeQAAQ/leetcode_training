import java.util.ArrayList;

class Solution {
    public static String solution(String S, int K) {
        S = S.toUpperCase();
        int len = 0;
        ArrayList<String> ss = new ArrayList();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '-') {
                len += 1;
                ss.add(S.substring(i, i + 1));
            }
        }

        int first = len % K;
        int others = len / K;
        String sf = "";
        String so = "";
        int count = 0;

        if (first != 0) {
            for (int i = 0; i < first; i++) {
                sf = sf + ss.get(i);
            }
            sf += "-";
        }

        for (int i = first; i < len; i++) {
            sf += ss.get(i);
            count++;

            if (count == K && i != len - 1) {
                sf += "-";
                count = 0;
            }
        }


        return sf;
    }


    public static void main(String[] args) {
        String x = "2-4A0r7-4k";
        System.out.println(solution(x, 3));
    }
}
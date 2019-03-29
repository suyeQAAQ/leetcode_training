public class keyboardPath {
    public static int solution(String S1, String S2) {
        if (S2.length() == 0) {
            return 0;
        }
        int len1 = S1.length();
        int[] ss = new int[S2.length()];
        int init = 0;

        for (int i = 0; i < S2.length(); i++) {
            String s = S2.substring(i, i + 1);
            ss[i] = S1.indexOf(s);
        }

        int sum = 0;

        for (int i = 0; i < ss.length; i++) {
            sum += (ss[i] - init) > 0 ? (ss[i] - init) : (init - ss[i]);
            init = ss[i];
        }

        return sum;
    }

    // write your code in Java SE 8
    public static void main(String[] args) {
        System.out.println(solution("abcdefghijklmnopqrstuvwxyz", ""));
    }
}

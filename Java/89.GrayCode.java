public class grayCode {
    class Solution {
        public List<Integer> grayCode(int n) {
            if (n == 0) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(0);
                return list;
            }
            if (n == 1) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(0);
                list.add(1);
                return list;
            }
            List<Integer> grayCode = grayCode(n - 1);
            List<Integer> list = new ArrayList<Integer>();
            /* core thinking: first half of graycode(n) is same with graycode(n - 1),
             * the second half is the reverse copy of first half but with 2^(n - 1) added for every element
             */
            for (int i = 0; i < Math.pow(2, n); i++) {
                if (i < Math.pow(2, n - 1)) {
                    list.add(grayCode.get(i));
                } else {
                    int res = grayCode.get((int) Math.pow(2, n) - i - 1) + (int) Math.pow(2, n - 1);
                    list.add(res);
                }
            }
            return list;
        }
    }
}

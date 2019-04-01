/**
 * @author Linh
 * @class solution to find the path in triangle which contains the largest sum
 */
class Solution {

        public int minimumTotal(List<List<Integer>> triangle) {

            // there should be at least one element in the triangle
            if (triangle.size() == 0 || triangle == null)
                return -1;
            if (triangle.get(0).size() == 0 || triangle.get(0) == null)
                return -1;

            int n = triangle.size();
            //temp[i][j] means the sum of path from (0,0) to (i,j)
            int[][] temp = new int[n][n];

            temp[0][0] = triangle.get(0).get(0);

            // from top to down, transfer data
            for (int i = 1; i < n; i++) {
                temp[i][0] = temp[i - 1][0] + triangle.get(i).get(0);
                temp[i][i] = temp[i - 1][i - 1] + triangle.get(i).get(i);
            }

            // from top to down
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < i; j++) {
                    temp[i][j] = Math.min(temp[i - 1][j], temp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }

            // find the min sum
            int min = temp[n - 1][0];
            for (int i = 0; i < n; i++) {
                min = Math.min(min, temp[n - 1][i]);
            }

            return min;

        }

}
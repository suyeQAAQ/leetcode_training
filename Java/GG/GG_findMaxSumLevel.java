/**
 * @author Linh
 * @class solution to find the level of the binary tree of given array, which has the largest sum
 */
public class findMaxSumLevel {
    public static int solution(int[] A) {
        int max = A[0];
        int total = 0;
        int i = 1;
        int index = i;
        while(total < A.length){
            int sum = 0;
            total += Math.pow(2, i - 1);

            for(int j = (int)Math.pow(2, i - 1) - 1; j < Math.min(Math.pow(2, i) - 1, A.length ); j++){
                sum += A[j];
            }

            if(sum > max) {
                max = sum;
                index = i;
            }
                i++;
        }

        return index;
    }
    public static void main(String args[]){
        int[] n = {10,12,31,43,22};
        System.out.println(solution(n));
    }
}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // test case 1: 6 2 1 3 2 4 3 5 2 6 1
        // tees case 2: 7 2 1 3 1 4 1 5 2 6 5 7 3 8 4
        // test case 3: 2 2 1
        // test case 4: 3 2 1 3 2
        // test case 5: 3 2 1 3 1
        // test case 6: 6 3 2 4 3 5 2 6 1 2 1
        ArrayList<HashSet<Integer>> list = new ArrayList<>();
        int way = 0;
        int count = 1;

        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        int potential = 0;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 1) System.out.println(0);
        else if (n == 2) System.out.println(1);
        else {
            while (count < n) {
                while(sc.hasNextInt()) {
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    if (b == 1) {
                        list.add(new HashSet<>());
                        list.get(way++).add(a);
                        count++;
                        continue;
                    }

                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j).contains(a)) {
                            list.get(j).add(b);
                            count++;
                            break;
                        } else if (list.get(j).contains(b)) {
                            list.get(j).add(a);
                            count++;
                            break;
                        } else {
                            temp.add(new ArrayList<>());
                            temp.get(potential++).add(a, b);
                        }
                    }
                }

                while (!temp.isEmpty()) {
                    for (int i = 0; i < temp.size(); i++) {
                        int a = temp.get(i).get(0);
                        int b = temp.get(i).get(1);
                        for (int j = 0; j < list.size(); j++) {
                            if (list.get(j).contains(a)) {
                                list.get(j).add(b);
                                count++;
                                temp.remove(i);
                                break;
                            }
                            if (list.get(j).contains(b)) {
                                list.get(j).add(a);
                                count++;
                                temp.remove(i);
                                break;
                            }
                        }
                    }
                    System.out.println("break");
                }
                System.out.println(list.size() + " " +list.get(0).size());
            }

        }

        int maxSubTree = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            maxSubTree = Math.max(maxSubTree, list.get(i).size());
        }
        System.out.println(maxSubTree);

    }
//        HashSet<Integer> left = new HashSet<>();
//        HashSet<Integer> right = new HashSet<>();
//
//        while(true){
//            if(left.size()+right.size()>=n-1)   break;;
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            if(b == 1){
//                if(flag ==1){
//                    right.add(a);
//                } else {
//                    left.add(a);
//                    flag =1;
//                }
//
//                continue;
//            }
//            if(left.contains(a)){
//                left.add(b);
//            }
//            if(left.contains(b)){
//                left.add(a);
//            }
//            if(right.contains(b)){
//                right.add(a);
//            }
//            if(right.contains(a)){
//                right.add(b);
//            }
//        }
//        System.out.println(Math.max(left.size(),right.size()));
//        left.clear();
//        right.clear();
}
// 6 2 1 3 2 4 3 5 2 6 1
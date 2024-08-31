import java.io.*;
import java.util.*;

/**
 * 리스트쓰는게나을듯 자동으로 인덱스조절해주니까
 */
public class Main {
    static List<Integer> list1 = new LinkedList<>();
    static List<Integer> list2 = new LinkedList<>();
    static List<Integer> list3 = new LinkedList<>();
    static List<Integer> list4 = new LinkedList<>();
    static int score;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String one = br.readLine();
        for(int i = 0; i<8; i++){
            list1.add(one.charAt(i)-'0');
        }

        String two = br.readLine();
        for(int i = 0; i<8; i++){
            list2.add(two.charAt(i)-'0');
        }

        String three = br.readLine();
        for(int i = 0; i<8; i++){
            list3.add(three.charAt(i)-'0');
        }

        String four = br.readLine();
        for(int i = 0; i<8; i++){
            list4.add(four.charAt(i)-'0');
        }

        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
        //극이 다르면 반대방향회전 같으면 회전안함
            if(n == 1){
                if(d == 1){
                    int r1 = list1.get(2);
                    int l2 = list2.get(6);
                    int r2 = list2.get(2);
                    int l3 = list3.get(6);
                    int r3 = list3.get(2);
                    int l4 = list4.get(6);
                    turnRight(list1);
                    if(r1 != l2){
                        turnLeft(list2);
                        if(r2 != l3){
                            turnRight(list3);
                            if(r3 != l4){
                                turnLeft(list4);
                            }
                        }
                    }

                }
                else if(d == -1){
                    int r1 = list1.get(2);
                    int l2 = list2.get(6);
                    int r2 = list2.get(2);
                    int l3 = list3.get(6);
                    int r3 = list3.get(2);
                    int l4 = list4.get(6);
                    turnLeft(list1);
                    if(r1 != l2){
                        turnRight(list2);
                        if(r2 != l3){
                            turnLeft(list3);
                            if(r3 != l4){
                                turnRight(list4);
                            }
                        }
                    }
                }
            }
            else if(n==2){
                if(d==1){
                    int r1 = list1.get(2);
                    int l2 = list2.get(6);
                    int r2 = list2.get(2);
                    int l3 = list3.get(6);
                    int r3 = list3.get(2);
                    int l4 = list4.get(6);
                    turnRight(list2);
                    if(r1 != l2) {
                        turnLeft(list1);
                    }
                    if (r2 != l3) {
                        turnLeft(list3);
                        if (r3 != l4) {
                            turnRight(list4);
                        }
                    }
                }
                else if(d==-1){
                    int r1 = list1.get(2);
                    int l2 = list2.get(6);
                    int r2 = list2.get(2);
                    int l3 = list3.get(6);
                    int r3 = list3.get(2);
                    int l4 = list4.get(6);
                    turnLeft(list2);
                    if(r1 != l2) {
                        turnRight(list1);
                    }
                    if (r2 != l3) {
                        turnRight(list3);
                        if (r3 != l4) {
                            turnLeft(list4);
                        }
                    }
                }
            }

            else if(n==3){
                if(d==1){
                    int r1 = list1.get(2);
                    int l2 = list2.get(6);
                    int r2 = list2.get(2);
                    int l3 = list3.get(6);
                    int r3 = list3.get(2);
                    int l4 = list4.get(6);
                    turnRight(list3);
                    if(l3 != r2){
                        turnLeft(list2);
                        if(l2 != r1) {
                            turnRight(list1);
                        }
                    }
                    if(r3 != l4){
                        turnLeft(list4);
                    }
                }
                else if(d==-1){
                    int r1 = list1.get(2);
                    int l2 = list2.get(6);
                    int r2 = list2.get(2);
                    int l3 = list3.get(6);
                    int r3 = list3.get(2);
                    int l4 = list4.get(6);
                    turnLeft(list3);
                    if(l3 != r2){
                        turnRight(list2);
                        if(l2 != r1) {
                            turnLeft(list1);
                        }
                    }
                    if(r3 != l4){
                        turnRight(list4);
                    }
                }
            }

            else if(n==4){
                if(d==1){
                    int r1 = list1.get(2);
                    int l2 = list2.get(6);
                    int r2 = list2.get(2);
                    int l3 = list3.get(6);
                    int r3 = list3.get(2);
                    int l4 = list4.get(6);
                    turnRight(list4);
                    if(l4 != r3){
                        turnLeft(list3);
                        if(l3 != r2) {
                            turnRight(list2);
                            if(l2 != r1){
                                turnLeft(list1);
                            }
                        }
                    }
                }
                else if(d==-1){
                    int r1 = list1.get(2);
                    int l2 = list2.get(6);
                    int r2 = list2.get(2);
                    int l3 = list3.get(6);
                    int r3 = list3.get(2);
                    int l4 = list4.get(6);
                    turnLeft(list4);
                    if(l4 != r3){
                        turnRight(list3);
                        if(l3 != r2) {
                            turnLeft(list2);
                            if(l2 != r1){
                                turnRight(list1);
                            }
                        }
                    }
                }
            }

        }
        calScore(list1, 1);
        calScore(list2, 2);
        calScore(list3, 3);
        calScore(list4, 4);
        System.out.println(score);
    }
    public static void turnRight(List<Integer> list){
        int last = list.get(7);
        list.remove(7);
        list.add(0, last);
    }

    public static void turnLeft(List<Integer> list){
        int first = list.get(0);
        list.remove(0);
        list.add(7, first);
    }

    public static void calScore(List<Integer> list, int num){
        if(list.get(0) == 1 && num ==1)
            score += 1;
        if(list.get(0) == 1 && num ==2)
            score += 2;
        if(list.get(0) == 1 && num ==3)
            score += 4;
        if(list.get(0) == 1 && num ==4)
            score += 8;
    }
}

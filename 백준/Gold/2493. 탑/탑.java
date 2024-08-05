import java.io.*;
import java.util.*;

/**
 * 1.스택 최상단 탑의 높이가 현재 탑 높이보다 크거나 같으면 -> 스택 최상단의 인덱스 출력
 * 2.그게 아니면 스택 pop / 6 9 5 7 4 -> 5다음에 7이 나오는데 5보다 큰 7이나오면 다음부터 5는 어떠한 경우에서도 레이저를 받을 수 없음
 * 3.스택이 비어 있으면 0출력 (초기데이터)
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Stack<int[]> stack = new Stack<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            int razer = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()){
                if(stack.peek()[1] >= razer){
                    System.out.print(stack.peek()[0] +" ");
                    break;
                }
                else{
                    stack.pop();
                }
            }

            //스택이 비어있으면 0(초기 데이터)
            if(stack.isEmpty())
                System.out.print("0 ");
            stack.push(new int[] {i, razer});
        }
    }
}

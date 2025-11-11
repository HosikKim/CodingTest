import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        //약수의 순서 저장 변수
        int count = 0;
        //k번째 약수 저장 변수
        int result = 0;
        
        //약수를 구하는 반복문
        for(int i=1; i<=N/2; i++){
            //약수가 하나 나올때마다 count +1
            if(N % i == 0){
                count++;
            }
            //count와 K가 같아지면 해당 약수가 K번째 약수이기에 break;
            if(count == K){
                result = i;
                break;
            }
        }
        //약수에 자기자신 추가
        count += 1;
        if(count == K){
            System.out.println(N);
        }else if(count < K){
            System.out.println("0");
        }else{
            System.out.println(result);
        }    
        
    }
}
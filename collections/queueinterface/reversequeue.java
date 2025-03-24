package collections.queueinterface;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class reversequeue {
    public static void reverseResult(Queue<Integer> q){
        Stack<Integer> st = new Stack<>();
        while(!q.isEmpty()){
            st.push(q.poll());
        }
        while(!st.isEmpty()){
            q.add(st.pop());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> st = new LinkedList<>();
        for(int i=0;i<n;i++){
            int a = sc.nextInt();
            st.add(a);
        }

        reverseResult(st);

        System.out.println(st);


    }
}

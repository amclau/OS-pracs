import java.util.*;
import java.io.*;


class bestfit{
    public static void main(String[] args) {
        
        Stack<Integer> stack = new Stack<Integer>();
        int []mem;
        mem = new int[] { 100,50,30,20};
        int flag=0;
        
        Stack<Integer> available = new Stack<Integer>();
        available.push(50);
        available.push(40);
        available.push(30);
        available.push(10);

        while(flag<4){
        for (int i = 0; i < 4; i++) {
            if(mem[i]>=available.peek())
            {
                
                stack.push(mem[i]);
                mem[i]=0;
                available.pop();
                flag++;
            }
        }
    }
    if(stack.size()==4)
    {
        System.out.println(stack);
    }
    else{
        // System.out.println("Best FIT is not possible");
        System.out.println(stack);

    }

    }
}
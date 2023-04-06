import java.util.*;
import java.io.*;
class bankers{
    public static void printmatrix(int a[][])
    {
        int n = 5; // Number of processes
        int m = 3; 
        for (int i = 0;i < n; i++)
        {
            for (int j = 0;j < m; j++)
             {
            System.out.print(a[i][j]+" ");
             }
             System.out.println();
        } 
    }



    public static int findprocess(int need[][],int avail[]) {
        int flag=0;
int mprocess=0;
int n = 5; // Number of processes
int m = 3;

for (int i = 0;i < n; i++)
{
  
    for (int j = 0;j < m; j++)
     {
    if(need[i][j]<=avail[j])
    {
        // System.out.println(i);
        flag+=1;
        // System.out.println(flag);
        if(flag==3)
     {
        mprocess=i;
        // System.out.println("terminating ");
        return i;
     }
    }

     }
     
    
}  
return mprocess;    
    }
    public static void main(String[] args) {
        int n = 5; // Number of processes
    int m = 3; // Number of resources
    int need[][] = new int[n][m];
    int [][]max;
    int [][]alloc;
    int []avail;
    int safeSequence[] = new int[n];
    Stack<Integer> stack = new Stack<Integer>();

    alloc = new int[][] { { 0, 1, 0 }, //P0  
    { 2, 0, 0 }, //P1
    { 3, 0, 2 }, //P2
    { 2, 1, 1 }, //P3
    { 0, 0, 2 } }; //P4

// MAX Matrix
max = new int[][] { { 7, 5, 3 }, //P0
{ 3, 2, 2 }, //P1
{ 9, 0, 2 }, //P2
{ 2, 2, 2 }, //P3
{ 4, 3, 3 } }; //P4

 
avail = new int[] { 3, 3, 2 };

for (int i = 0;i < n; i++)
{
    for (int j = 0;j < m; j++)
     {
    need[i][j] = max[i][j]-alloc[i][j];
     }
}   

printmatrix(need);

int mprocess=findprocess(need, avail);
stack.push(mprocess);

for (int i = 0; i < 3; i++) {
    avail[i]-=need[mprocess][i];
}

for (int i = 0; i < 3; i++) {
    avail[i]+=max[mprocess][i];
}


System.out.println(avail[0]+" "+avail[1]+" "+avail[2]);

for (int i = 0; i < 3; i++) {
   need[mprocess][i]=1000;
}

System.out.println("neeed matrix 1");
printmatrix(need); 

mprocess=findprocess(need, avail);
stack.push(mprocess);
for (int i = 0; i < 3; i++) {
    avail[i]-=need[mprocess][i];
}

for (int i = 0; i < 3; i++) {
    avail[i]+=max[mprocess][i];
}


System.out.println(avail[0]+" "+avail[1]+" "+avail[2]);

for (int i = 0; i < 3; i++) {
   need[mprocess][i]=1000;
}

System.out.println("neeed matrix 2");
printmatrix(need);    

mprocess=findprocess(need, avail);
stack.push(mprocess);
for (int i = 0; i < 3; i++) {
    avail[i]-=need[mprocess][i];
}

for (int i = 0; i < 3; i++) {
    avail[i]+=max[mprocess][i];
}


System.out.println(avail[0]+" "+avail[1]+" "+avail[2]);

for (int i = 0; i < 3; i++) {
   need[mprocess][i]=1000;
}

System.out.println("neeed matrix 3");
printmatrix(need);   

mprocess=findprocess(need, avail);
stack.push(mprocess);
for (int i = 0; i < 3; i++) {
    avail[i]-=need[mprocess][i];
}

for (int i = 0; i < 3; i++) {
    avail[i]+=max[mprocess][i];
}


System.out.println(avail[0]+" "+avail[1]+" "+avail[2]);

for (int i = 0; i < 3; i++) {
   need[mprocess][i]=1000;
}

System.out.println("neeed matrix 4");
printmatrix(need);   

mprocess=findprocess(need, avail);
stack.push(mprocess);
for (int i = 0; i < 3; i++) {
    avail[i]-=need[mprocess][i];
}

for (int i = 0; i < 3; i++) {
    avail[i]+=max[mprocess][i];
}


System.out.println(avail[0]+" "+avail[1]+" "+avail[2]);

for (int i = 0; i < 3; i++) {
   need[mprocess][i]=1000;
}

System.out.println("neeed matrix step 5");
printmatrix(need);   

System.out.println(stack);

    }
}
import java.util.Scanner;

class SJFPrem
{

    public static int findMin(int bt[]) 
    {
    int minP=0;    
    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.println("SJF Prem :-\n");

        System.out.println("Enter no of process :");
        int process=sc.nextInt();
        int At[]={0,1,2,3,4,5};
        int Bt[]={7,5,3,1,2,1};
        int ct[]=new int[process];
        int Tat[]=new int[process];
        int wt[]=new int[process];
        int Tbt=19;
        System.out.println("Enter arrival times & Burst times :\n");
        
        // for(int i=0;i<process;i++)
        // {
        // System.out.println("Enter Arrival Time of process "+(i+1)+'\n');
        // At[i]=sc.nextInt();           
        // System.out.println("Enter Burst Time of process "+(i+1)+'\n');
        // Bt[i]=sc.nextInt(); 
        // }

int current_time=0;
for (int i = 0; i <=Tbt; i++) {
    current_time++;
    processIndex=findMin();

}





for(int i=0;i<process;i++)
    { 
        Tat[i]=ct[i]-At[i];    
        wt[i]=Tat[i]-Bt[i]; 
    }
    

for(int i=0;i<process;i++)
{
   System.out.println("completion time of process "+(i+1)+" is "+ct[i]);
}

System.out.println("CT"+"\t"+"TAT"+"\t"+"WT");
for(int i=0;i<process;i++)
{
   System.out.println(ct[i]+"\t"+Tat[i]+"\t"+wt[i]);
}

int ATAT=0,AWT=0;
for(int i=0;i<process;i++)
{
    ATAT=Tat[i]+ATAT;
    AWT=wt[i]+AWT;
}
ATAT=ATAT/process;
AWT=AWT/process;
System.out.println("AVERAGE TAT IS "+ATAT);
System.out.println("AVERAGE WT IS "+AWT);



    }
}
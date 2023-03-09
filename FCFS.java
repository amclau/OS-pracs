import java.util.Scanner;

class FCFS
{
 
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.println("FCFS CODE :-\n");

        System.out.println("Enter no of process :");
        int process=sc.nextInt();
        int At[]={0,1,2,3,6};
        int Bt[]={2,6,4,9,12};
        int ct[]=new int[process];
        int Tat[]=new int[process];
        int wt[]=new int[process];
        System.out.println("Enter arrival times & Burst times :\n");
        
        for(int i=0;i<process;i++)
        {
        System.out.println("Enter Arrival Time of process "+(i+1)+'\n');
        At[i]=sc.nextInt();           
        System.out.println("Enter Burst Time of process "+(i+1)+'\n');
        Bt[i]=sc.nextInt(); 
        }

    ct[0]=Bt[0];
    for(int i=1;i<process;i++)
    {
        ct[i]=Bt[i]+ct[i-1];   
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
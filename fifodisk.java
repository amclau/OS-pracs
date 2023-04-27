import java.util.Scanner;
class fifodisk
{
    public static void main(String args[])
{
    Scanner sc = new Scanner(System.in);

int num, oldTotalTime,newTotalTime;
System.out.print("Enter no of requests ");
num = sc.nextInt();
int mainData[] = new int[num];
for(i = 0; i < num; i++)
mainData[i] = sc.nextInt();

for(i = 1; i < num; i++)
{   int max,min;
    int current=mainData[i];
    int prevcurrent=mainData[i-1];
    if(current>prevcurrent)
    {
        max=current;
        min=prevcurrent;
    }
    else{
        min=current;
        max=prevcurrent;
    }
    int sum=max-min;
    System.out.println("local sum is"+sum);
    oldTotalTime+=sum;
    
}

}
}
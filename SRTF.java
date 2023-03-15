import java.util.Scanner;

class SRTF {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter number of processes: ");
        n = sc.nextInt();
        int p[] = new int[n]; // Process id array
        int at[] = new int[n]; // Arrival time array
        int bt[] = new int[n]; // Burst time array
        int flag[] = new int[n]; // To check if process is completed
        int i, j, min1, min2, min3;
        for (i = 0; i < n; i++) {
            p[i] = i + 1;
            System.out.print("Enter arrival time: ");
            at[i] = sc.nextInt();
            System.out.print("Enter burst time: ");
            bt[i] = sc.nextInt();
            flag[i] = 0;
        }
        for (i = 0; i < n; i++) {
            min1 = at[i];
            min2 = bt[i];
            min3 = p[i];
            j = i - 1;
            while (j >= 0 && at[j] > min1) {
                at[j + 1] = at[j];
                bt[j + 1] = bt[j];
                p[j + 1] = p[j];
                j--;
            }
            at[j + 1] = min1;
            bt[j + 1] = min2;
            p[j + 1] = min3;
        }
        int cur_t = 0; // Current time
        int st[] = new int[n]; // Starting time of each process
        int ct[] = new int[n]; // completion time array
        int tot = 0; // To count number of processes completed
        int minbt = 1000; // To store the shortest bt
        int c = 0; // To track id of process to be scheduled next
        while (tot < n) {
            for (i = 0; i < n; i++) {
                if ((at[i] <= cur_t) && (flag[i] == 0) && (bt[i] <= minbt)) {
                    minbt = bt[i];
                    c = i;
                }
            }
            ct[c] = cur_t + minbt;
            st[c] = cur_t;
            flag[c] = 1;
            cur_t = ct[c];
            tot++;
            minbt = 1000; // reset so that bt values of remaining processes are compared
        }
        int tat[] = new int[n]; // Turnaround Time array
        int wt[] = new int[n]; // Waiting Time array
        float sum1 = 0, sum2 = 0; // sum1 for tat and sum2 for wt
        System.out.println("\nProcess No.\tA.T\tB.T.\tC.T.\tT.A.T.\tW.T.");
        for (i = 0; i < n; i++) {
            tat[i] = ct[i] - at[i];
            wt[i] = tat[i] - bt[i];
            System.out.println(
                    "Process" + p[i] + "\t" + at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + tat[i] + "\t" + wt[i]);
            sum1 += tat[i];
            sum2 += wt[i];
        }
        System.out.println("Average Turn Around Time: " + (sum1 / n));
        System.out.println("Average Waiting Time: " + (sum2 / n));
        // To prepare Gantt Chart processes are soted according to start time
        for (i = 0; i < n; i++) {
            min1 = st[i];
            min2 = ct[i];
            min3 = p[i];
            j = i - 1;
            while (j >= 0 && st[j] > min1) {
                st[j + 1] = st[j];
                ct[j + 1] = ct[j];
                p[j + 1] = p[j];
                j--;
            }
            st[j + 1] = min1;
            ct[j + 1] = min2;
            p[j + 1] = min3;
        }
        System.out.println("\n\t\tGANTT CHART\nPROCESS \tStart Time\tCompletion Time");
        for (i = 0; i < n; i++) {
            System.out.println("PROCESS " + p[i] + "\t\t" + st[i] + "\t\t" + ct[i]);
        }
    }
}
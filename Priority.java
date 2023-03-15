import java.util.Scanner;

class Priority {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter number of processes: ");
        n = sc.nextInt();
        int p[] = new int[n]; // Process id array
        int at[] = new int[n]; // Arrival time array
        int bt[] = new int[n]; // Burst time array
        int flag[] = new int[n]; // To check if process is completed
        int priority[] = new int[n];
        int i, j, min1, min2, min3, min4;
        int cur_t = 0; // Current time
        int st[] = new int[n]; // Starting time of each process
        int ct[] = new int[n]; // completion time array
        int tot = 0; // To count number of processescompleted
        int minpri = 1000; // To store the highest priority
        int c = 0;
        int b[] = new int[n]; // To store a copy of burst time array
        for (i = 0; i < n; i++) {
            p[i] = i + 1;
            System.out.print("Enter arrival time: ");
            at[i] = sc.nextInt();
            System.out.print("Enter burst time: ");
            bt[i] = sc.nextInt();
            System.out.print("Enter priority [smallest number is high]: ");
            priority[i] = sc.nextInt();
            flag[i] = 0;
            st[i] = -1;
        }
        for (i = 0; i < n; i++) {
            min1 = at[i];
            min2 = bt[i];
            min3 = p[i];
            min4 = priority[i];
            j = i - 1;
            while (j >= 0 && at[j] > min1) {
                at[j + 1] = at[j];
                bt[j + 1] = bt[j];
                p[j + 1] = p[j];
                priority[j + 1] = priority[j];
                j--;
            }
            at[j + 1] = min1;
            bt[j + 1] = min2;
            p[j + 1] = min3;
            priority[j + 1] = min4;
        }
        for (i = 0; i < n; i++)
            b[i] = bt[i];
        while (tot < n) {
            for (i = 0; i < n; i++) {
                if ((priority[i] <= minpri) && (at[i] <= cur_t) && (flag[i] == 0)) {
                    minpri = priority[i];
                    c = i;
                }
            }
            if (st[c] == -1) {
                st[c] = cur_t;
                ct[c] = cur_t;
            }
            b[c]--;
            cur_t++;
            ct[c]++;
            for (i = 0; i < n; i++) {
                if ((c != i) && (st[i] != -1) && (flag[i] == 0))
                    ct[i]++;
            }
            if (b[c] == 0) {
                flag[c] = 1;
                tot++;
            }
            minpri = 1000;
        }
        int tat = 0; // Turnaround Time
        int wt = 0; // Waiting Time array
        float sum1 = 0, sum2 = 0, rt = 0; // sum1 for tat and sum2 for wt and response time
        System.out.println("\nProcess No.\tPriority\tA.T\tB.T.\tC.T.\tT.A.T.\tW.T.\tR.T.");
        for (i = 0; i < n; i++) {
            tat = ct[i] - at[i];
            wt = tat - bt[i];
            rt = st[i] - at[i];
            System.out.println("Process" + p[i] + "\t" + priority[i] + "\t\t" + at[i] + "\t" + bt[i] + "\t" + ct[i]
                    + "\t" + tat + "\t" + wt + "\t" + rt);
            sum1 += tat;
            sum2 += wt;
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
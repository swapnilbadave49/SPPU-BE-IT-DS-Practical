import java.util.Scanner;

public class T {

    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of processes");
        n=sc.nextInt();

        int []pid=new int[n];
        boolean []alive=new boolean[n];
        for (int i=0;i<n;i++)
        {
            System.out.println("Enter PID");
            pid[i]=sc.nextInt();
            alive[i]=true;
        }

        System.out.println("Enter Start");
        int start=sc.nextInt();
        System.out.println("ENter FAiled");
        alive[sc.nextInt()]=false;
        int max=pid[start];
        int curr=start;
        System.out.println("Message Passed");
        do {
            int next=(curr+1)%n;

            while (!alive[next])
            {
                next=(next+1)%n;
            }
            System.out.println("Process"+pid[curr]+"Send msg to "+pid[next]);
            if(pid[next]>max)
            {
                max=pid[next];
            }
            curr=next;
        }while(curr!=start);


        System.out.println("NEW CO-ordinator is="+max);
    }
}

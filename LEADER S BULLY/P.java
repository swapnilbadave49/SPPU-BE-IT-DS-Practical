import java.util.Scanner;

public class P {

    static boolean[]alive;
    static  int n;

    public void ele(int p)
    {
        System.out.println("Election started by"+p);

        for (int i=p+1;i<n;i++)
        {

            if(alive[i])
            {  System.out.println("Process "+p+"Sends elec msg to "+i);
                ele(i);
                return;
            }
        }

        System.out.println("Process"+p+"becomes coordinator");
        for (int i=0;i<n;i++)
        { if(i!=p && alive[i])
        {
            System.out.println(p+" Sends msg to "+i);
        }

        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
     P m1=new P();
        System.out.println("Enter number of pro");
        n= sc.nextInt();
        alive=new boolean[n];

        for (int i=0;i<n;i++)
        {
            alive[i]=true;
        }

        System.out.println("Enter failed process");

        int failed=sc.nextInt();

        alive[failed]=false;

        System.out.println("Enter ele process");
        int p=sc.nextInt();

        if(!alive[p])
        {
            System.out.println("process is down");
        }
        else
        {
            m1.ele(p);
        }
    }

}

import java.util.Random;
import mpi.*;
public class P2 {
    public static void main(String[] args) {
        MPI.Init(args);
        int r=MPI.COMM_WORLD.Rank();
        int s=MPI.COMM_WORLD.Size();
        int n=8;
        int ch=n/s;

        int [] send=null;
        int [] rec=new int[ch];

        if(r==0)
        {
            Random rand=new Random();
            send=new int[n];
            System.out.println("Original Array is=");
            for (int i=0;i<n;i++)
            {
                send[i]=rand.nextInt(10)+1;
                System.out.print(send[i]+" ");
            }
        }
        else
        {
            send=new int[n];
        }

        MPI.COMM_WORLD.Scatter(send,0,ch,MPI.INT,rec,0,ch,MPI.INT,0);

        int sum=0;

        for (int i=0;i<rec.length;i++)
        {
            sum+=rec[i];
        }
//        System.out.println("Process "+r+" "+"has sum="+ sum);

        double lavg= (double) sum /ch;

        System.out.println("Local avg for P"+r+"is="+lavg);
        double[] g=new double[s];
        MPI.COMM_WORLD.Gather(new double[]{lavg},0,1,MPI.DOUBLE,g,0,1,MPI.DOUBLE,0);

        if (r==0)
        { double ans=0;
            for(int i=0;i<s;i++)
            {
                ans+=g[i];
            }

            System.out.println("Final="+ans/s);
        }

        MPI.Finalize();


    }

}

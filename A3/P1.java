import mpi.*;
public class P1 {

    public static void main(String[] args) {
        MPI.Init(args);

        int rank=MPI.COMM_WORLD.Rank();
        int size=MPI.COMM_WORLD.Size();


        int n=8;
        int chunksize=n/size;

        int [] send=null;

        if(rank==0)
        {
            send=new int[]{1,2,3,4,5,6,7,8};
        }
        else
        {
            send=new int[n];
        }
        int [] rec=new int[chunksize];
        MPI.COMM_WORLD.Scatter(send,0,chunksize,MPI.INT,rec,0,chunksize,MPI.INT,0);
        double localsum=0;
        for(int i=0;i<rec.length;i++)
        {
            localsum+=rec[i];
        }
//        System.out.println("Process:- "+rank+" "+"Sum:- "+sum)

        double localavg=localsum / chunksize;
        System.out.println("Process="+rank+" "+"LOCAVG= "+localavg);
        double []gathered=new double[size];
        MPI.COMM_WORLD.Gather(new double[]{localavg},0,1,MPI.DOUBLE,gathered,0,1,MPI.DOUBLE,0);

        double sum=0;
       if (rank==0)
       {
           for(int i=0;i<gathered.length;i++)
           {
               sum+=gathered[i];
           }
           double avg=sum/size;

           System.out.println("Final avg is="+avg);
       }
MPI.Finalize();
    }

}

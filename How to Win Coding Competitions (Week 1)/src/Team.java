import java.io.*;
import java.util.*;

public class Team {

    static Scanner newInput() throws IOException {
        return new Scanner(new File("team.in"));
    }
    
    static PrintWriter newOutput() throws IOException {
        return new PrintWriter("team.out");
    }

    public static void main(String[] args) throws IOException {
        try (Scanner in = newInput(); PrintWriter out = newOutput()) {
            
            // get values out of file
            double A1 = in.nextDouble();
            double A2 = in.nextDouble();
            double A3 = in.nextDouble();
            double B1 = in.nextDouble();
            double B2 = in.nextDouble();
            double B3 = in.nextDouble();
            double C1 = in.nextDouble();
            double C2 = in.nextDouble();
            double C3 = in.nextDouble();
            
            // square them all
            A1 = A1*A1;
            A2 = A2*A2;
            A3 = A3*A3;
            B1 = B1*B1;
            B2 = B2*B2;
            B3 = B3*B3;
            C1 = C1*C1;
            C2 = C2*C2;
            C3 = C3*C3;
            
            double[] sumOfSquares = new double[6];
            sumOfSquares[0]= A1+B2+C3;
            sumOfSquares[1]= A1+B3+C2;
            sumOfSquares[2]= A2+B1+C3;
            sumOfSquares[3]= A2+B3+C1;
            sumOfSquares[4]= A3+B1+C2;
            sumOfSquares[5]= A3+B2+C1;
            
            double maxSumOfSquares = 0.0;
            for(int i=0; i<6; i++)
            {
                if(sumOfSquares[i]>maxSumOfSquares) maxSumOfSquares=sumOfSquares[i];
            }
            
            out.print(java.lang.Math.sqrt(maxSumOfSquares));
        }
    }

}


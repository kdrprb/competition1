import java.io.*;
import java.util.*;

public class GenerateTests {

    // NOTE: the set of HCN is found online: http://wwwhomes.uni-bielefeld.de/achim/highly.html
    private static final int[] highlyCompositeNumbers = {1,2,4,6,12,24,36,48,60,120,180,240,360,720,840,1260,1680,2520,5040,7560,10080,15120,20160,25200,27720,45360,50400,55440,83160,110880,166320,221760,277200,332640,498960,554400,665280,720720,1081080,1441440,2162160,2882880,3603600,4324320,6486480,7207200,8648640,10810800,14414400,17297280,21621600,32432400,36756720,43243200,61261200,73513440,110270160,122522400,147026880,183783600};
    //private static final int[] numberOfDivisors = {1,1,2,3,4,6,8,9,10,12,16,18,20,24,30,32,36,40,48,60,64,72,80,84,90,96,100,108,120,128,144,160,168,180,192,200,216,224,240,256,288,320,336,360,384,400,432,448,480,504,512,576,600,640,672,720,768,800,864,896,960};
    
    static Scanner newInput() throws IOException {
        return new Scanner(new File("testgen.in"));
    }
    
    static PrintWriter newOutput() throws IOException {
        return new PrintWriter("testgen.out");
    }

    private static int findIndexOfLowerHCN(int testNumber)
    {
        int index = 0;
        for(int i=0; i<highlyCompositeNumbers.length; i++)
        {
            if(testNumber>=highlyCompositeNumbers[i]) index=i;
        }
        return index;
    }
    
    public static void main(String[] args) throws IOException {
        try (Scanner in = newInput(); PrintWriter out = newOutput()) {
            int K = in.nextInt();
            int idx = findIndexOfLowerHCN(K);
            int nextLowerHighlyCompositeNumber = highlyCompositeNumbers[idx];
            int maximalTests = (K-nextLowerHighlyCompositeNumber)+1;
            out.println(maximalTests);
        }
    }
}


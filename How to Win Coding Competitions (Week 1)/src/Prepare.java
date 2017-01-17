import java.io.*;
import java.util.*;

public class Prepare {

    static Scanner newInput() throws IOException {
        return new Scanner(new File("prepare.in"));
    }
    
    static PrintWriter newOutput() throws IOException {
        return new PrintWriter("prepare.out");
    }

    public static void main(String[] args) throws IOException {
        try (Scanner in = newInput(); PrintWriter out = newOutput()) {
            int n = in.nextInt();
            
            int[] p = new int[n];
            for(int i=0; i<n; i++){
                p[i] = in.nextInt();
            }

            int[] t = new int[n];
            for(int i=0; i<n; i++){
                t[i] = in.nextInt();
            }
            
            int minPracticeOverTheoryLoss = -1;
            //int minPracticeOverTheoryLossIdx = -1;
            int minTheoryOverPracticeLoss = -1;
            //int minTheoryOverPracticeLossIdx = -1;
            
            boolean atLeastOnePractice = false;
            boolean atLeastOneTheory = false;
            //int[] prepare = new int[n];
            int total = 0;
            
            for(int i=0; i<n; i++){
                if(p[i]>=t[i]){
                    total+=p[i];
                    atLeastOnePractice=true;
                    int currentPracticeMargin = p[i]-t[i];
                    
                    if(minPracticeOverTheoryLoss < 0) // uninitialized
                    {
                        minPracticeOverTheoryLoss = currentPracticeMargin;
                        //minPracticeOverTheoryLossIdx = i;
                    }
                    else
                    {
                        if(minPracticeOverTheoryLoss > currentPracticeMargin) {
                            minPracticeOverTheoryLoss = currentPracticeMargin;
                            //minPracticeOverTheoryLossIdx = i;   
                        }                        
                    }
                }
                else
                {
                    total+=t[i];
                    atLeastOneTheory=true;
                    int currentTheoryMargin = t[i]-p[i];

                    if(minTheoryOverPracticeLoss < 0) // uninitialized
                    {
                        minTheoryOverPracticeLoss = currentTheoryMargin;
                        //minTheoryOverPracticeLossIdx = i;
                    }
                    else
                    {
                        if(minTheoryOverPracticeLoss > currentTheoryMargin) {
                            minTheoryOverPracticeLoss = currentTheoryMargin;
                            //minTheoryOverPracticeLossIdx = i;   
                        }                        
                    }
                }
            }
            
            if(!atLeastOnePractice)
            {
                total-=minTheoryOverPracticeLoss;
            }
            
            if(!atLeastOneTheory)
            {
                total-=minPracticeOverTheoryLoss;
            }

            out.print(total);
        }
    }

}


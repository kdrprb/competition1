import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class WinTheCompetition {
    
    private static int testLengthInSeconds = 300*60;

    static Scanner newInput() throws IOException {
        return new Scanner(new File("win.in"));
    }
    
    static PrintWriter newOutput() throws IOException {
        return new PrintWriter("win.out");
    }
    
/*    private static int totalOfIntegerSet(Set<Integer> toBeSummed)
    {
        int total = 0;
        Iterator<Integer> toBeSummedIterator = toBeSummed.iterator();
        while(toBeSummedIterator.hasNext()) total+=toBeSummedIterator.next();
        return total;
    }*/

    
    private static int knapsack2(Set<Integer> costs, int totalCapacity)
    {
        if(costs.size()==1)
        {
            
            if(costs.iterator().next()<=totalCapacity)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        else
        {
            Iterator<Integer> costsIterator = costs.iterator();
            Integer currentElement = costsIterator.next();
            Set<Integer> remainingELements = new HashSet<Integer>();
            while(costsIterator.hasNext()) remainingELements.add(costsIterator.next());
            
            if(currentElement.intValue() > totalCapacity)
            {
                // exclude currentElement and return maximum out of remaining elements
                return knapsack2(remainingELements,totalCapacity);
            }
            else
            {
                // return higher value of excluding or including currentElement
                return Math.max(knapsack2(remainingELements,totalCapacity), knapsack2(remainingELements,totalCapacity-currentElement.intValue())+1);
            }
            
        }        
    }

        
/*    private static Set<Integer> knapsack(Set<Integer> costs, int totalCapacity)
    {
        Set<Integer> maximalSet = new HashSet<Integer>();
        int totalCosts = totalOfIntegerSet(costs);
        
        if(costs.size()==1)
        {
            if(totalCosts<totalCapacity)
            {
                maximalSet.add(costs.iterator().next());
                return maximalSet;
            }
            else
            {
                return maximalSet;
            }
        }
        else
        {
            Iterator<Integer> costsIterator = costs.iterator();
            Integer currentElement = costsIterator.next();
            Set<Integer> remainingELements = new HashSet<Integer>();
            while(costsIterator.hasNext()) remainingELements.add(costsIterator.next());
            
            if(currentElement.intValue() > totalCapacity)
            {
                return knapsack(remainingELements,totalCapacity);
            }
            else
            {
                // exclude currentElement
                Set<Integer> maxOfRemainingElementsSet1 = knapsack(remainingELements,totalCapacity);
                int totalOfRemainingElements1 = totalOfIntegerSet(maxOfRemainingElementsSet1);
                int numRemainingElements1 = maxOfRemainingElementsSet1.size();
                
                // include currentElement
                Set<Integer> maxOfRemainingElementsSet2 = knapsack(remainingELements,totalCapacity-currentElement.intValue());
                maxOfRemainingElementsSet2.add(currentElement);
                int totalOfRemainingElements2 = totalOfIntegerSet(maxOfRemainingElementsSet2);
                int numRemainingElements2 = maxOfRemainingElementsSet2.size();
                
                if(numRemainingElements2>numRemainingElements1)
                {
                    return maxOfRemainingElementsSet2;
                }
                else if(numRemainingElements2>numRemainingElements1)
                {
                    return maxOfRemainingElementsSet1;
                }
                else // break tie with lowest weight
                {
                    if(totalOfRemainingElements2<=totalOfRemainingElements1) 
                    {
                        return maxOfRemainingElementsSet2;
                        
                    }
                    else
                    {
                        return maxOfRemainingElementsSet1;
                        
                    }
                        
                }
            }
            
        }
    }
*/
    
    
    // this problem can be solved recursively: http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
    public static void main(String[] args) throws IOException {
        try (Scanner in = newInput(); PrintWriter out = newOutput()) {

            // first line: # tests
            //int numTests = Integer.parseInt(in.nextLine());
            in.nextLine();

            // second line: tests
            Set<Integer> testSet = new HashSet<Integer>();
            while(in.hasNext()) testSet.add(in.nextInt());
            
            //System.out.println(numTests);
            //System.out.println(testSet);
            
            //Set<Integer> doableTests = knapsack((HashSet<Integer>) testSet,testLengthInSeconds);
            //out.println(doableTests.size());
            
            out.println(knapsack2((HashSet<Integer>) testSet,testLengthInSeconds));
        }
    }
    
    
}


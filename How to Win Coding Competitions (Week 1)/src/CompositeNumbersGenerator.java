import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CompositeNumbersGenerator {

    static Scanner newInput() throws IOException {
        return new Scanner(new File("highly-composite-numbers.in"));
    }
    
    static PrintWriter newOutput() throws IOException {
        return new PrintWriter("highly-composite-numbers.out");
    }

    // note this list was provided here: http://wwwhomes.uni-bielefeld.de/achim/highly.html
    public static void main(String[] args) throws IOException {
        try (Scanner in = newInput(); PrintWriter out = newOutput()) {
            
            int[] highlyCompositeNumbers = new int[60];
            int[] numberOfDivisors = new int[60];
            int counter = 0;
            Pattern findNumbers = Pattern.compile("(\\d+)");
            
            while(in.hasNext())
            {
                String s = in.nextLine();
                //System.out.println("line " + counter + ":" + s);
                //String[] lineArray = s.trim().split(" ");
                //System.out.println("line array:" + lineArray.toString());
                //String compositeNumber = s.split(" ")[1];
                //System.out.print("composite number:" + compositeNumber);
                //highlyCompositeNumbers[counter] = Integer.parseInt(s.split(" ")[1]);
                
                Matcher matcher = findNumbers.matcher(s);
                //if(matcher.find()) System.out.println("index: " + matcher.group());
                //if(matcher.find()) System.out.println("composite #: " + matcher.group());
                matcher.find();
                matcher.find();
                highlyCompositeNumbers[counter] = Integer.parseInt(matcher.group());
                //if(matcher.find()) System.out.println("divisors: " + matcher.group());
                matcher.find();
                numberOfDivisors[counter] = Integer.parseInt(matcher.group());
                counter++;
            }
            
            out.print("{");
            out.print(highlyCompositeNumbers[0]);
            for(int i=1; i<highlyCompositeNumbers.length; i++) 
            {
                out.print(","+highlyCompositeNumbers[i]);                
            }
            out.println("}");
            
            out.print("{");
            out.print(numberOfDivisors[0]);
            for(int i=0; i<numberOfDivisors.length; i++) 
            {
                out.print(","+numberOfDivisors[i]);                                
            }           
            out.println("}");

        }
    }
    
    
}


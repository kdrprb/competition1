import java.io.*;
import java.util.*;

public class Chairs {

    static Scanner newInput() throws IOException {
        return new Scanner(new File("chairs.in"));

    }
    
    static PrintWriter newOutput() throws IOException {
        return new PrintWriter("chairs.out");
    }

    public static void main(String[] args) throws IOException {
        try (Scanner in = newInput(); PrintWriter out = newOutput()) {
            Double s1 = in.nextDouble();
            Double s2 = in.nextDouble();
            Double s3 = in.nextDouble();
            
            out.print( (s1+s2+s3)/6 );
        }
    }

}


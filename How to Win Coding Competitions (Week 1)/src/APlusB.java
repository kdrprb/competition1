import java.io.*;
import java.util.*;

public class APlusB {

    static Scanner newInput() throws IOException {
        return new Scanner(new File("aplusb.in"));
/*        if (System.getProperty("JUDGE") == null) {
            return new Scanner(new File("aplusb.in"));
        } else {
            return new Scanner(System.in);
        }*/
    }
    
    static PrintWriter newOutput() throws IOException {
        return new PrintWriter("aplusb.out");
/*        if (System.getProperty("JUDGE") == null) {
            return new PrintWriter("aplusb.out");
        } else {
            return new PrintWriter(System.out);
        }*/
    }

    public static void main(String[] args) throws IOException {
        try (Scanner in = newInput(); PrintWriter out = newOutput()) {
            out.print(in.nextInt() + in.nextInt());
        }
    }

}


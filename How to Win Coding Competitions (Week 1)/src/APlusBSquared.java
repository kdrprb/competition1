import java.io.*;
import java.util.*;

public class APlusBSquared {

    static Scanner newInput() throws IOException {
        return new Scanner(new File("aplusbb.in"));
    }
    
    static PrintWriter newOutput() throws IOException {
        return new PrintWriter("aplusbb.out");
    }

    public static void main(String[] args) throws IOException {
        try (Scanner in = newInput(); PrintWriter out = newOutput()) {
            int a = in.nextInt();
            long b = in.nextLong();
            out.print(a + b*b);
        }
    }

}


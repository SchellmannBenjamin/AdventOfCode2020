import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Reader {
    File file;

    public Reader(File file) {
        this.file = file;
    }

    public LinkedList<Integer> read() throws IOException {
        LinkedList<Integer> input = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String s = br.readLine(); s != null; s = br.readLine()) {
                input.add(Integer.parseInt(s));
            }
        }
        return input;
    }
}
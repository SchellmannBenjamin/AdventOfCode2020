import java.io.*;
import java.util.LinkedList;

public class Reader {
    File file;

    public Reader(File file) {
        this.file = file;
    }

    public LinkedList<Password> read() throws IOException {
        LinkedList<Password> input = new LinkedList<>();
        String[] elems;
        String[] minmax;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String s = br.readLine(); s != null; s = br.readLine()) {
                elems = s.split(" ");
                minmax = elems[0].split("-");

                input.add(new Password(Integer.parseInt(minmax[0]), Integer.parseInt(minmax[1]), elems[1].charAt(0), elems[2]));
            }
        }
        return input;
    }

}
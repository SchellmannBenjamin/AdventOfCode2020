import java.io.File;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\Ben\\Documents\\GitHub\\AdventOfCode\\AdventOfCode2020\\008. December 8th\\src\\input.txt";
        Reader reader = new Reader(new File(path));
        HashMap<Integer, Command> hm = new HashMap<>();
        System.out.println(reader.read(hm));
        System.out.println(reader.read2());
    }
}

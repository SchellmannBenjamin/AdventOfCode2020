import java.io.File;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\Ben\\Documents\\GitHub\\AdventOfCode\\AdventOfCode2020\\006. December 6th\\src\\input2.txt";
        Reader reader = new Reader(new File(path));
        System.out.println(reader.read2());
    }
}

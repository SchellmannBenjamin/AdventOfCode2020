import java.io.File;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\Benjamin\\Documents\\Github\\AdventOfCode2020\\009. December 9th\\src\\input.txt";
        Reader reader = new Reader(new File(path));
        HashMap<Integer, Long> numbersmap = reader.read();
        long part1 = reader.part1(numbersmap);
        long part2 = reader.part2(numbersmap, part1);
        System.out.println("Part 1: " + part1);
        System.out.println("Part 2: " + part2);
    }
}

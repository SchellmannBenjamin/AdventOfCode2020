import java.io.File;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\Ben\\Documents\\GitHub\\AdventOfCode\\AdventOfCode2020\\003. December 3rd\\src\\input.txt";
        int len = 323;
        int xmulti = 1;
        int ymulti = 1;
        Reader reader = new Reader(new File(path), len, xmulti, ymulti);
        int[][] matrix = reader.read();
        PathCalculator pathCalculator = new PathCalculator(matrix);
        System.out.println(pathCalculator.calculateTrees(len, xmulti, ymulti));
    }

    //60, 225, 57, 58, 25
}

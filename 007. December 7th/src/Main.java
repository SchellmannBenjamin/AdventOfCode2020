import java.io.File;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> count = new LinkedList<>();
        String path = "C:\\Users\\Ben\\Documents\\GitHub\\AdventOfCode\\AdventOfCode2020\\007. December 7th\\src\\input.txt";
        Reader reader = new Reader(new File(path));
        LinkedList<Bag> bags = reader.read();
        count.add("shinygold");

        for (int i = 0; i < 10; i++) {
            count = reader.searchBag(bags, count);
        }
        System.out.println(count.size()-1);

        System.out.println(reader.countBagsIn(reader.getDict(), "shiny gold"));


    }
}

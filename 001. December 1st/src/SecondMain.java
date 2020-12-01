import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class SecondMain {
    static LinkedList<Integer> input;

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Ben\\Documents\\GitHub\\AdventOfCode\\AdventOfCode2020\\001. First\\src\\input.txt");
        Reader reader = new Reader(file);
        input = reader.read();

        System.out.println(findNumber());


    }

    public static Integer findNumber(){
        for (Integer first: input) {
            for(Integer second: input){
                for(Integer third: input){
                    if(first+second+third==2020)return first*second*third;
                }
            }
        }
        return 0;
    }
}

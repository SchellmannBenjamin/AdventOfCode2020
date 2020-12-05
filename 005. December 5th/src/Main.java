import java.io.File;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\Ben\\Documents\\GitHub\\AdventOfCode\\AdventOfCode2020\\005. December 5th\\src\\input.txt";
        Reader reader = new Reader(new File(path));
        LinkedList<Seat> seats = reader.read();
        int highestID = 0;
        for(Seat s : seats){
                if(s.getSeatID()>highestID)highestID=s.getSeatID();
            }
        System.out.println(highestID);
    }
}

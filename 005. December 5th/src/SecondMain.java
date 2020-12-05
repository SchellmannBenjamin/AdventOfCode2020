import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;

public class SecondMain {
    public static void main(String[] args) {
        String path = "C:\\Users\\Ben\\Documents\\GitHub\\AdventOfCode\\AdventOfCode2020\\005. December 5th\\src\\input.txt";
        Reader reader = new Reader(new File(path));

        HashMap<Integer, Seat> IDSeatMap = new HashMap<>();
        LinkedList<Seat> seats = reader.read();
        int highestID = 0;

        for(Seat s : seats){
            if(s.getSeatID()>highestID)highestID=s.getSeatID();
            IDSeatMap.put(s.getSeatID(),s);
        }

        for (int i = 0; i <= highestID; i++) {
            if(IDSeatMap.get(i)==null&&i>45) System.out.println(i);
        }


    }
}

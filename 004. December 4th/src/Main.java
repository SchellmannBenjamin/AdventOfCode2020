import java.io.File;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        int validPassports = 0;
        String path = "C:\\Users\\Ben\\Documents\\GitHub\\AdventOfCode\\AdventOfCode2020\\004. December 4th\\src\\input.txt";
        Reader reader = new Reader(new File(path));
        LinkedList<Passport> passports = reader.read();
        for(Passport p : passports){
            if(p.isReallyValid())validPassports++;
        }
        System.out.println(validPassports);
    }
}

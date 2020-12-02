import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class SecondMain {
    public static void main(String[] args) throws IOException {
        int count = 0;
        LinkedList<Password> passwordslist = new LinkedList<>();
        String path = "C:\\Users\\Ben\\Documents\\GitHub\\AdventOfCode\\AdventOfCode2020\\002. December 2nd\\src\\input.txt";
        Reader reader = new Reader(new File(path));
        passwordslist = reader.read();
        PasswordChecker pwc = new PasswordChecker();
        for(Password pw : passwordslist){
            if(pwc.checkPasswordSecond(pw.getMin(), pw.getMax(), pw.getCharacter(), pw.getPassword()))count++;
        }
        System.out.println(count);
    }
}

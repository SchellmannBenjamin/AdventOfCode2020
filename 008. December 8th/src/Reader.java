import java.io.*;
import java.util.*;

public class Reader {
    File file;

    public Reader(File file) {
        this.file = file;
    }

    public int read(HashMap<Integer, Command> commandsMap) {
        String elems[];
        int poscount = 0;
        int acc = 0;
        Command c;
        LinkedList<Integer> used = new LinkedList<>();
        int pos = 0;
        if(commandsMap.size()<1) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {

                for (String s = br.readLine(); s != null; s = br.readLine()) {
                    elems = s.split(" ");
                    commandsMap.put(poscount, new Command(elems[0], Integer.parseInt(elems[1])));
                    poscount++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

            while (!used.contains(pos) && used.size() < commandsMap.size() && pos < commandsMap.size()) {
                used.add(pos);
                c = commandsMap.get(pos);

                switch (c.getName()) {
                    case "acc":
                       // System.out.println("acc");
                        acc += c.getValue();
                        pos++;
                        break;

                    case "jmp":
                       // System.out.println("jmp");
                        pos += c.getValue();
                        break;

                    case "nop":
                      //  System.out.println("nop");
                        pos++;
                        break;
                    default:
                        System.out.println("Not Found");
                        break;
                }

            }

        return acc;
    }

    public int read2() {
        String[] elems;
        HashMap<Integer, Command> commandsMap = new HashMap<>();
        int poscount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String s = br.readLine(); s != null; s = br.readLine()) {
                elems = s.split(" ");
                commandsMap.put(poscount, new Command(elems[0], Integer.parseInt(elems[1])));
                poscount++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < commandsMap.size(); i++){
            Command c = commandsMap.get(i);

            if(c.getName().equals("jmp") || c.getName().equals("nop")) {
                if (c.getName().equals("jmp")) c.setName("nop");
                else if (c.getName().equals("nop")) c.setName("jmp");

                if (reachesEnd(commandsMap)) return read(commandsMap);

                if (c.getName().equals("jmp")) c.setName("nop");
                else if (c.getName().equals("nop")) c.setName("jmp");
            }
        }

        return 0;

    }

    private boolean reachesEnd(HashMap<Integer, Command> commandsMap){
        LinkedList<Command> used = new LinkedList<>();

        for(int i = 0; i < commandsMap.size(); i++){
            Command c = commandsMap.get(i);

            if(used.contains(c))
                return false;

            if(c.getName().equals("jmp"))i += (c.getValue() - 1);

            used.add(c);
        }

        return true;
    }
}
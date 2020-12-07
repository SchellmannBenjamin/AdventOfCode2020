import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Reader {
    File file;

    public Reader(File file) {
        this.file = file;
    }

    public LinkedList<Bag> read() {
        String elems[];
        String str = "";
        Bag bag = new Bag("first");
        int anz = 0;
        int count = 0;
        LinkedList<Bag> bagList = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String s = br.readLine(); s != null; s = br.readLine()) {
                elems = s.split(" ");

                for (int i = 0; i < elems.length; i++) {
                    if(!elems[i].equals("bags"))str+=elems[i];
                    else {
                        count=i+2;
                        break;
                    } }
                bag = new Bag(str);
                for (int i = count; i < elems.length; i+=4) {
                    if(elems[i].equals("no"))break;
                    anz = Integer.parseInt(elems[i]);
                    str = elems[i+1]+elems[i+2];
                    bag.put(str, anz);
                }
                bagList.add(bag);
                anz = 0;
                str = "";
                count = 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bagList;
    }

    public LinkedList<String> searchBag(LinkedList<Bag> bags, LinkedList<String> bagnames){
        LinkedList<String> ret = new LinkedList<>();
        ret.addAll(bagnames);
        for(Bag b: bags){
            for(String s: bagnames)
            if(b.getContains().containsKey(s)&&!ret.contains(b.getName())){
                ret.add(b.getName());
            }
        }
        return ret;
    }

    public Map<String, List<String>> getDict() {
        Path path = Paths.get("src/input.txt");
        Map<String, List<String>> dict = new HashMap<>();
        try {
            Files.readAllLines(path).forEach(l ->{
                String[] bcb = l.replaceAll("bags", "").replaceAll("bag", "").replaceAll("\\.", "").trim().split("contain");
                List<String> v = new ArrayList<>();
                if (!bcb[1].trim().equals("no other")) {
                    for (String c: bcb[1].trim().split(",")) {
                        v.add(c.trim());
                    }
                }
                dict.put(bcb[0].trim(), v);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dict;
    }

    public long countBagsIn(final Map<String, List<String>> dict, final String color) {
        long count = 0;
        for (String s: dict.get(color)) {
            String copy = s;
            int numberOfBags = Integer.parseInt(copy.replaceAll("[^\\d]", ""));
            count = count + numberOfBags + numberOfBags * countBagsIn(dict, s.replaceAll("\\d", "").trim());
        }

        return count;
    }

}
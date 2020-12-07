import java.util.HashMap;

public class Bag {
    String name;
    HashMap<String, Integer> contains;
    public Bag(String name) {
        this.name = name;
        this.contains = new HashMap<>();
    }

    public void put(String b, int anz){
        contains.put(b, anz);
    }

    public HashMap<String, Integer> getContains(){
        return contains;
    }

    public String getName(){
        return name;
    }
}

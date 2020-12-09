import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

public class Reader {
    File file;

    public Reader(File file) {
        this.file = file;

    }

    public long part1(HashMap<Integer, Long> numbermap){
        String[] elems;
        int count = 0;
        boolean ret = true;

            for (int i = 25; i < numbermap.size(); i++) {
                for (int j = i-25; j < i; j++) {
                    for (int k = i-25; k < i; k++) {
                        if(numbermap.get(i)==numbermap.get(j)+numbermap.get(k)&&j!=k){
                            ret = false;
                        }
                    }
                }
                if(ret)return numbermap.get(i);
                else ret = true;
            }
        return 0;
    }

    public HashMap<Integer, Long> read() {
        int count = 0;
        HashMap<Integer, Long> numbermap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String s = br.readLine(); s != null; s = br.readLine()) {
                numbermap.put(count, Long.parseLong(s));
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbermap;
    }

    public int getPos(HashMap<Integer, Long> numbersmap, long number){
        for(int i = 0; i < numbersmap.size(); i++){
            if(numbersmap.get(i)==number)return i;
        }
        return 0;
    }

    public long part2(HashMap<Integer, Long> numbersmap, long number){
        long tmp = 0;
        for (int i = 0; i < getPos(numbersmap, number) ; i++) {
            tmp = checkNumber(i, getPos(numbersmap, number), numbersmap);
            if(tmp!=0)return tmp;
        }


        return 0;
    }

    public long checkNumber(int i, int pos, HashMap<Integer, Long> numbersmap){
        long ret = 0;
        TreeSet<Long> nums = new TreeSet();
        for (int j = i; j < pos; j++) {
            ret+=numbersmap.get(j);
            nums.add(numbersmap.get(j));
            if(ret==numbersmap.get(pos))return nums.first()+nums.last();
        }
        return 0;
    }
}
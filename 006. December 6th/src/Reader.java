import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

public class Reader {
    File file;

    public Reader(File file) {
        this.file = file;
    }


    public int read2(){
        HashMap<Integer, LinkedList<String>> IDAnswerMap = new HashMap<>();
        TreeSet<String> strings = new TreeSet<>();
        String line[];
        int ret = 0;
        int max = 0;
        LinkedList<String> alreadyUsed = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String s = br.readLine(); s != null; s = br.readLine()) {
                line = s.split("");

                if(line[0].equals("")){
                    for(String str : strings) {
                        if (search(IDAnswerMap, 0, str, max)) {
                            ret++;
                        }
                    }
                    IDAnswerMap = new HashMap<>();
                    strings = new TreeSet<>();
                    max=0;
                }else {
                    for (int i = 0; i < line.length; i++) {
                        alreadyUsed.add(line[i]);
                        strings.add(line[i]);
                    }
                    IDAnswerMap.put(max,alreadyUsed);
                    alreadyUsed = new LinkedList<>();
                    max++;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public boolean search(HashMap<Integer, LinkedList<String>> IDAnswerMap, int count, String s, int max){
        for(String string : IDAnswerMap.get(count)){
            if(string.equals(s)&&count<(max-1)){
                if(search(IDAnswerMap, (count+1), s, max))return true;
            }else if(string.equals(s))return true;
        }
        return false;
    }

    public int read() {
        String elems[];
        int count = 0;
        boolean b = false;
        LinkedList<String> alreadyUsed = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String s = br.readLine(); s != null; s = br.readLine()) {
                elems = s.split("");

                if(elems[0].equals("")){
                    alreadyUsed.clear();
                }else {
                    for (int i = 0; i < elems.length; i++) {
                        for (String used : alreadyUsed) {
                            if (used.equals(elems[i])) {
                                b = true;
                                break;
                            }
                        }
                        if(!b){
                            alreadyUsed.add(elems[i]);
                            count++;
                        }
                        b = false;
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    }
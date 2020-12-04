import java.io.*;
import java.util.LinkedList;

public class Reader {
    File file;
    int len;
    int xmulti;
    int ymulti;

    public Reader(File file, int len, int xmulti, int ymulti) {
        this.file = file;
        this.len = len;
        this.xmulti = xmulti;
        this.ymulti = ymulti;
    }

    public int[][] read() {
        int[][] ret = new int[len*ymulti][len*xmulti];
        String[] elems;
        int line = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String s = br.readLine(); s != null; s = br.readLine()) {
                elems = s.split("");
                for (int i = 0; i < len*xmulti; i+=ymulti) {
                    if(elems[i%31].equals("."))ret[line][i] = 0;
                    else ret[line][i] = 1;
                }
                line++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

}
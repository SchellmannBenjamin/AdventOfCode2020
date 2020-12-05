import java.io.*;
import java.util.LinkedList;

public class Reader {
    File file;

    public Reader(File file) {
        this.file = file;
    }

    public LinkedList<Seat> read() {
        LinkedList<Seat> seats = new LinkedList<>();
        String[] line;
        Seat seat = new Seat();
        int rowmin = 0;
        int rowmax = 128;
        int columnmin = 0;
        int columnmax = 8;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String s = br.readLine(); s != null; s = br.readLine()) {
                line = s.split("");

                for (int i = 0; i < 6; i++) {
                    if(line[i].equals("F")){
                        rowmax-=(rowmax-rowmin)/2;
                    }else if(line[i].equals("B")){
                        rowmin+=(rowmax-rowmin)/2;
                    }
                }
                rowmax--;
                if(line[6].equals("F")){
                    seat.setRow(rowmin);
                }else seat.setRow(rowmax);

                for (int i = 7; i < 9; i++) {
                    if(line[i].equals("R")){
                        columnmin+=(columnmax-columnmin)/2;
                    }else if(line[i].equals("L")){
                        columnmax-=(columnmax-columnmin)/2;
                    }
                }
                columnmax--;
                if(line[9].equals("R")){
                    seat.setColumn(columnmax);
                }else if(line[9].equals("L")){
                    seat.setColumn(columnmin);
                }

                seats.add(seat);
                seat = new Seat();
                columnmax = 8;
                columnmin = 0;
                rowmax = 128;
                rowmin = 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return seats;
    }

}
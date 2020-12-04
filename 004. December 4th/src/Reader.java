import java.io.*;
import java.util.LinkedList;

public class Reader {
    File file;

    public Reader(File file) {
        this.file = file;
    }

    public LinkedList<Passport> read() {
        LinkedList<Passport> passports = new LinkedList<>();
        String[] line;
        String[] elems;
        Passport passport1 = new Passport();


        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String s = br.readLine(); s != null; s = br.readLine()) {
                line = s.split(" ");
                if(line[0].equals("")) {
                    passports.add(passport1);
                    passport1 = new Passport();
                }else{
                    for (int i = 0; i < line.length; i++) {
                        elems = line[i].split(":");
                        insertintopassport(passport1, elems);
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        passports.add(passport1);
        return passports;
    }

    public void insertintopassport(Passport passport, String[] elems){
        try {
            switch (elems[0]) {
                case "byr":
                    passport.setBirthyear(Integer.parseInt(elems[1]));
                    break;

                case "iyr":
                    passport.setIssueyear(Integer.parseInt(elems[1]));
                    break;

                case "eyr":
                    passport.setExpirationyear(Integer.parseInt(elems[1]));
                    break;

                case "hgt":
                    passport.setHeight(elems[1]);
                    break;

                case "hcl":
                    passport.setHaircolor(elems[1]);
                    break;

                case "ecl":
                    passport.setEyecolor(elems[1]);
                    break;

                case "pid":
                    passport.setPassportid((elems[1]));
                    break;

                case "cid":
                    passport.setCountryid(Integer.parseInt(elems[1]));
                    break;

                default:
                    return;
            }
        }catch (NumberFormatException e){
            System.out.println("NumberFormatException");
            System.out.println(elems[0]+" "+elems[1]);
        }
    }

}
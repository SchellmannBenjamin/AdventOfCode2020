public class Passport {
    int birthyear;
    int issueyear;
    int expirationyear;
    String height;
    String haircolor;
    String eyecolor;
    String passportid;
    int countryid;

    public Passport() {
        this.birthyear = 0;
        this.issueyear = 0;
        this.expirationyear = 0;
        this.height = "";
        this.haircolor = "";
        this.eyecolor = "";
        this.passportid = "";
        this.countryid = 0;
    }

    public int getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(int birthyear) {
        this.birthyear = birthyear;
    }

    public int getIssueyear() {
        return issueyear;
    }

    public void setIssueyear(int issueyear) {
        this.issueyear = issueyear;
    }

    public int getExpirationyear() {
        return expirationyear;
    }

    public void setExpirationyear(int expirationyear) {
        this.expirationyear = expirationyear;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHaircolor() {
        return haircolor;
    }

    public void setHaircolor(String haircolor) {
        this.haircolor = haircolor;
    }

    public String getEyecolor() {
        return eyecolor;
    }

    public void setEyecolor(String eyecolor) {
        this.eyecolor = eyecolor;
    }

    public String getPassportid() {
        return passportid;
    }

    public void setPassportid(String passportid) {
        this.passportid = passportid;
    }

    public int getCountryid() {
        return countryid;
    }

    public void setCountryid(int countryid) {
        this.countryid = countryid;
    }

    public boolean isValid(){
        if(birthyear==0||issueyear==0||expirationyear==0||height.equals("")||haircolor.equals("")||eyecolor.equals("")||passportid=="")return false;
        return true;
    }

    public int getRawHeight(){
        String parser = "";
        String[] elems = height.split("");
        for (int i = 0; i < elems.length; i++) {
                try{
                    if(elems[i].matches("[0-9]"))parser+=elems[i];
                }catch (Exception e){
            }
        }
        return Integer.parseInt(parser);
    }


    public boolean isReallyValid(){
        if(birthyear<1920||birthyear>2002||issueyear<2010||issueyear>2020||expirationyear<2020||expirationyear>2030)return false;
        if(height.matches("[0-9]*cm")){
            if(getRawHeight()<150||getRawHeight()>193)return false;
        }else if(height.matches("[0-9]*in")){
            if(getRawHeight()<59||getRawHeight()>76)return false;
        }else return false;
        if(!haircolor.matches("[#][0-9|a-f]{6}"))return false;
        if(!eyecolor.equals("amb")&&!eyecolor.equals("blu")&&!eyecolor.equals("brn")&&!eyecolor.equals("gry")&&!eyecolor.equals("grn")&&!eyecolor.equals("hzl")&&!eyecolor.equals("oth"))return false;
        if(!passportid.matches("[0-9]{9}"))return false;

        return true;
    }

}

public class PasswordChecker {

    public PasswordChecker(){};

    public boolean checkPassword(int min, int max, char c, String password){
        int count = 0;
        String[] arr = password.split("");
        for (String s : arr) {
            if(s.charAt(0)==c)count++;
        }
        if(min<=count&&max>=count)return true;
        return false;
    }

    public boolean checkPasswordSecond(int firstpos, int secondpos, char c, String password){
        if(password.charAt(firstpos-1)==c){
            if(password.charAt(secondpos-1)==c)return false;
            else return true;
        }
        if(password.charAt(secondpos-1)==c){
            if(password.charAt(firstpos-1)==c)return false;
            else return true;
        }
        return false;
    }


}

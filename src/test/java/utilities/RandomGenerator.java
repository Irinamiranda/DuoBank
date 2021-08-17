package utilities;

import java.util.Locale;

public class RandomGenerator {

    public static void main(String[] args) {
        System.out.println(generateEmail(generateName()));
    }

    public static String generateName(){
        String firstName = "";
        for (int i = 0; i < 8; i++) {
            firstName += (char)((int)(Math.random() * 26) + 97);
        }
        firstName = firstName.substring(0,1).toUpperCase(Locale.ROOT) + firstName.substring(1);
        return firstName;
    }

    public static String generateEmail(String name){
        String email = "";
        email += name + "2021@gmail.com";

        return email;
    }




}

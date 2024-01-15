package me.twostinkysocks.pingspoof.client;

public class Util {

    public static boolean isInt(String str) {
        try {
            int i = Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}

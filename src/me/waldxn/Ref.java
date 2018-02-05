package me.waldxn;

public class Ref {

    static String TOKEN = "";
    static String GUILD_ID = "";
    public static String PREFIX = "-";
    public static String WEBSITE = "";
    public static String TWITTER = "";
    public static String EMAIL = "";
    public static String PORTFOLIO = "";

    public static String SUPPORT_ID = "";

    public static String CLIENT_ROLE = "";

    public static int getInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }
}
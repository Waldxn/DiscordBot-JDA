package me.waldxn;

public class Ref {

    //General Bot Settings
    static String TOKEN = "";
    static String GUILD_ID = "";
    public static String PREFIX = "-";

    //Information for the Info command
    public static String WEBSITE = "";
    public static String TWITTER = "";
    public static String EMAIL = "";
    public static String PORTFOLIO = "";

    //Category IDs
    public static String SUPPORT_ID = "";

    //Role IDs
    public static String CLIENT_ROLE = "";

    public static int getInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }
}
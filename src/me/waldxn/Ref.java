package me.waldxn;

public class Ref {

    static String TOKEN = "NDA5NDQ0MzAwNjExNTE4NDY0.DVjrSQ.gX3G2ewfvmYpS68LHq9s28F6854";
    static String GUILD_ID = "409003187689750528";
    public static String CLIENT_ID = "409697868618661889";
    public static String PREFIX = "-";
    public static String WEBSITE = "Website: Currently under construction";
    public static String TWITTER = "Twitter: https://twitter.com/McEthereal";
    public static String EMAIL = "Contact Us: business@ethereal.services, or PM a CEO on Discord";
    public static String PORTFOLIO = "Portfolio: Being built";

    public static String SUPPORT_ID = "409783196654501900";

    public static int getInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }
}
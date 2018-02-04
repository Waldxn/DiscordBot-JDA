package me.waldxn;

public class Ref {

    static String TOKEN = "NDA5Njk3ODY4NjE4NjYxODg5.DViYYw.g0BhKJGkTqGM3Qnq0MFHWdi0TYk";
    static String GUILD_ID = "409698014521851904";
    public static String CLIENT_ID = "409697868618661889";
    public static String PREFIX = "-";
    public static String WEBSITE = "Website: Currently under construction";
    public static String TWITTER = "Twitter: https://twitter.com/McEthereal";
    public static String EMAIL = "Contact Us: business@ethereal.services, or PM a CEO on Discord";
    public static String PORTFOLIO = "Portfolio: Being built";

    public static int getInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }
}

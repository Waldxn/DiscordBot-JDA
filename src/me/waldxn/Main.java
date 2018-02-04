package me.waldxn;

import me.waldxn.commands.*;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.managers.GuildController;

import javax.security.auth.login.LoginException;
import java.util.HashMap;

public class Main {

    public static GuildController guildController;
    public static HashMap<String, String> commands = new HashMap<>();

    public static void main(String[] args) {
        try {
            JDA jda = new JDABuilder(AccountType.BOT)
                    .setToken(Ref.TOKEN)
                    .buildBlocking();
            jda.addEventListener(new Apply());
            jda.addEventListener(new Bot());
            jda.addEventListener(new Clear());
            jda.addEventListener(new Help());
            jda.addEventListener(new Info());
            jda.addEventListener(new Order());
            jda.addEventListener(new Partner());
            jda.addEventListener(new Staff());
            guildController = jda.getGuildById(Ref.GUILD_ID).getController();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
        saveCommands();
    }

    private static void saveCommands(){
        commands.put(Apply.getCommandName(), Apply.getDescription());
        commands.put(Bot.getCommandName(), Bot.getDescription());
        commands.put(Clear.getCommandName(), Clear.getDescription());
        commands.put(Help.getCommandName(), Help.getDescription());
        commands.put(Info.getCommandName(), Info.getDescription());
        commands.put(Order.getCommandName(), Order.getDescription());
        commands.put(Partner.getCommandName(), Partner.getDescription());
        commands.put(Staff.getCommandName(), Staff.getDescription());
    }
}

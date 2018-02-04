package me.waldxn;

import me.waldxn.commands.*;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.managers.GuildController;

import javax.security.auth.login.LoginException;

public class Main {

    public static GuildController guildController;

    public static void main(String[] args) {
        try {
            JDA jda = new JDABuilder(AccountType.BOT)
                    .setToken(Ref.TOKEN)
                    .buildBlocking();
            jda.addEventListener(new Apply());
            jda.addEventListener(new Clear());
            jda.addEventListener(new Info());
            jda.addEventListener(new Order());
            jda.addEventListener(new Staff());
            guildController = jda.getGuildById(Ref.GUILD_ID).getController();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

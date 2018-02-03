package me.waldxn;

import me.waldxn.commands.*;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.managers.GuildController;

import javax.security.auth.login.LoginException;

public class Main {

    public static GuildController guildController;

    public static void main(String[] args)
            throws LoginException, RateLimitedException, InterruptedException {
        JDA jda = new JDABuilder(AccountType.BOT)
                .setToken(Ref.TOKEN)
                .buildBlocking();
        jda.setAutoReconnect(true);
        jda.addEventListener(new Apply());
        jda.addEventListener(new Info());
        jda.addEventListener(new Order());
        jda.addEventListener(new Staff());
        jda.addEventListener(new Clear());
        guildController = new GuildController(jda.getGuildById("409003187689750528"));
    }
}

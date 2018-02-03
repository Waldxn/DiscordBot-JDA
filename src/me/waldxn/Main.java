package me.waldxn;

import me.waldxn.commands.Apply;
import me.waldxn.commands.Info;
import me.waldxn.commands.Order;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] args)
            throws LoginException, RateLimitedException, InterruptedException {
        JDA jda = new JDABuilder(AccountType.BOT)
                .setToken(Ref.TOKEN)
                .buildBlocking();
        jda.setAutoReconnect(true);
        jda.addEventListener(new Apply());
        jda.addEventListener(new Info());
        jda.addEventListener(new Order());
    }
}

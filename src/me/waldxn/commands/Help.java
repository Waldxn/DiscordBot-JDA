package me.waldxn.commands;

import me.waldxn.Main;
import me.waldxn.Ref;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class Help extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] command = event.getMessage().getContentRaw().split(" ");

        if (!command[0].startsWith(Ref.PREFIX)) {
            return;
        }

        if (command[0].equalsIgnoreCase("-help")) {
            EmbedBuilder builder = new EmbedBuilder();
            builder.setTitle("Help");
            builder.setColor(Color.YELLOW);
            for (String s : Main.commands.keySet()) {
                builder.addField(s, Main.commands.get(s), false);
            }
            event.getChannel().sendMessage(builder.build()).queue();
        }
    }

    public static String getCommandName(){
        return "Help";
    }

    public static String getDescription() {
        return "-help - Displays this list";
    }
}

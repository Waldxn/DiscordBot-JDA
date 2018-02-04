package me.waldxn.commands;

import me.waldxn.Ref;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Bot extends ListenerAdapter {


    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] command = event.getMessage().getContentRaw().split(" ");

        if (!command[0].startsWith(Ref.PREFIX)) {
            return;
        }

        if (command[0].equalsIgnoreCase("-bot")) {
            event.getChannel().sendMessage(event.getMember().getAsMention() + ", you can view my source code at: https://github.com/Waldxn/EtherealBot.").queue();
        }
    }
}

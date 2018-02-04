package me.waldxn.commands;

import me.waldxn.Ref;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Test extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] command = event.getMessage().getContentRaw().split(" ");

        if (!command[0].startsWith(Ref.PREFIX)) {
            return;
        }

        if (command[0].equalsIgnoreCase("-test")) {
            event.getChannel().sendMessage("Test worked").queue();
        }
    }
}
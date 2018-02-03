package me.waldxn.commands;

import me.waldxn.Ref;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Order extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] command = event.getMessage().getContentRaw().split(" ");
        Role owner = event.getGuild().getRoleById("409003375125069824");

        if (!command[0].startsWith(Ref.PREFIX)) {
            return;
        }

        if (command[0].equalsIgnoreCase("-order")) {
           event.getChannel().sendMessage(event.getMember().getAsMention() + ", message a " + owner.getAsMention() + " to place an order!").queue();
        }
    }
}
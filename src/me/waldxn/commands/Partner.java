package me.waldxn.commands;

import me.waldxn.Ref;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Partner extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] command = event.getMessage().getContentRaw().split(" ");
        Role ceo = event.getGuild().getRoleById("409003375125069824");

        if (!command[0].startsWith(Ref.PREFIX)) {
            return;
        }

        if (command[0].equalsIgnoreCase("-partner")) {
            event.getChannel().sendMessage(event.getMember().getAsMention() +
                    ", if you are looking to for a partnership, feel free to email us at business@ethereal.services, or PM a "
                    + ceo.getAsMention()).queue();
        }
    }
}
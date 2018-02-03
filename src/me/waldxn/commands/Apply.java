package me.waldxn.commands;

import me.waldxn.Ref;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Apply extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] command = event.getMessage().getContentRaw().split(" ");

        if (!command[0].startsWith(Ref.PREFIX)) {
            return;
        }

        if (command[0].equalsIgnoreCase("-apply")) {
            if (command.length < 2) {
                event.getChannel().sendMessage(event.getMember().getAsMention() + ", please clarify which application you would like to see.").queue();
            } else if (command[1].equalsIgnoreCase("dev") ||
                    command[1].equalsIgnoreCase("developer") ||
                    command[1].equalsIgnoreCase("development")) {
                event.getChannel().sendMessage(event.getMember().getAsMention() + ", https://goo.gl/forms/UO3x5w1p2CQ3jyB83 - Developer Application").queue();
            } else if (command[1].equalsIgnoreCase("building") ||
                    command[1].equalsIgnoreCase("builder") ||
                    command[1].equalsIgnoreCase("build")) {
                event.getChannel().sendMessage(event.getMember().getAsMention() + ", https://goo.gl/forms/siJpb2qZLw8WgTg22 - Builder Application").queue();
            } else if (command[1].equalsIgnoreCase("gfx") ||
                    command[1].equalsIgnoreCase("graphic") ||
                    command[1].equalsIgnoreCase("graphics")) {
                event.getChannel().sendMessage(event.getMember().getAsMention() + ", https://goo.gl/forms/eBWbqQJahGJQF4RU2 - Graphics Designer Application").queue();
            } else {
                event.getChannel().sendMessage(event.getMember().getAsMention() + ", there is no application for the job specified").queue();
            }
        }
    }
}

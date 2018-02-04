package me.waldxn.commands;

import me.waldxn.Ref;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Info extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] command = event.getMessage().getContentRaw().split(" ");

        if (!command[0].startsWith(Ref.PREFIX)) {
            return;
        }

        if (command[0].equalsIgnoreCase("-info")) {
            event.getChannel().sendMessage(event.getMember().getAsMention() + ", \n" +
                    Ref.TWITTER + "\n" +
                    Ref.WEBSITE + "\n" +
                    Ref.EMAIL + "\n" +
                    Ref.PORTFOLIO + "\n").queue();
        }
    }

    public static String getCommandName(){
        return "Info";
    }

    public static String getDescription() {
        return "-info - Displays all important Ethereal links";
    }
}

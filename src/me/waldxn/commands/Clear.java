package me.waldxn.commands;

import me.waldxn.Ref;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.List;

public class Clear extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] command = event.getMessage().getContentRaw().split(" ");

        if (!command[0].startsWith(Ref.PREFIX)) {
            return;
        }

        if (command[0].equalsIgnoreCase("-clear")) {
            if (event.getMember().hasPermission(Permission.MESSAGE_MANAGE)) {
                if (command.length == 2) {
                    int amount = Ref.getInteger(command[1]);
                    MessageHistory history = event.getChannel().getHistory();
                    List<Message> msgs;
                    msgs = history.retrievePast(amount + 1).complete();
                    event.getChannel().deleteMessages(msgs).queue();
                }
            }
        }
    }

    public static String getCommandName(){
        return "Clear";
    }

    public static String getDescription() {
        return "-clear [number] - Clears a defined number of messages";
    }
}

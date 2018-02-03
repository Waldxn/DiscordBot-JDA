package me.waldxn.commands;

import me.waldxn.Ref;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Staff extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] command = event.getMessage().getContentRaw().split(" ");

        if (!command[0].startsWith(Ref.PREFIX)) {
            return;
        }

        if (command[0].equalsIgnoreCase("-staff")) {
            int online = 0;
            Role ceo = event.getGuild().getRoleById("409003375125069824");

            for (Member member : event.getGuild().getMembersWithRoles(ceo)) {
                if (member.getOnlineStatus() == OnlineStatus.ONLINE) {
                    online++;
                }
            }
            if (online == 1) {
                event.getChannel().sendMessage(event.getMember().getAsMention() + ", there is " + online + " staff member online.").queue();

            } else if (online == 0) {
                event.getChannel().sendMessage(event.getMember().getAsMention() + ", there are " + online + " staff members online.").queue();

            } else {
                event.getChannel().sendMessage(event.getMember().getAsMention() + ", there are " + online + " staff members online.").queue();

            }
        }
    }
}

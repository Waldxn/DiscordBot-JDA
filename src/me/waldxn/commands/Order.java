package me.waldxn.commands;

import me.waldxn.Ref;
import me.waldxn.Main;
import me.waldxn.managers.Orders;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Order extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] command = event.getMessage().getContentRaw().split(" ");
        Role client = event.getGuild().getRoleById(Ref.CLIENT_ROLE);

        if (!command[0].startsWith(Ref.PREFIX)) {
            return;
        }

        if (command[0].equalsIgnoreCase("-order")) {
            if (!Orders.orderRequest.contains(event.getMember())) {
                event.getChannel().sendMessage(event.getMember().getAsMention() + ", the Staff team has been notified that you want a commission.").queue();
                Orders.orderRequest.add(event.getMember());
                event.getGuild().getTextChannelById("409485023855771653").sendMessage(event.getMember().getAsMention() + " is looking for a commission!").queue();
            } else {
                event.getChannel().sendMessage(event.getMember().getAsMention() + ", you have already submitted a request. Please be patient.").queue();
            }
        }

        if (command.length == 2) {
            if (command[0].equalsIgnoreCase("-claimorder")) {
                for (Member member : Orders.orderRequest) {
                    if (member.getAsMention().equalsIgnoreCase(command[1])) {
                        member.getUser().openPrivateChannel().queue((channel) ->
                                channel.sendMessage(event.getAuthor().getAsMention() + " has claimed your commission. They will be messaging you shortly!").queue());
                        event.getAuthor().openPrivateChannel().queue((channel) ->
                                channel.sendMessage(event.getAuthor().getAsMention() + ", you have claimed " + member.getUser().getAsMention() + "'s commission. Please send them a PM to get more details.").queue());
                        Orders.orderRequest.remove(member);
                        Main.guildController.addRolesToMember(member, client).queue();
                    }
                }
            }
        }
    }

    public static String getCommandName(){
        return "Order";
    }

    public static String getDescription() {
        return "-order - Submits a commission request \n" +
                "-claimorder [User] - Claims the commission order";
    }
}
package me.waldxn.commands;

import me.waldxn.Main;
import me.waldxn.Ref;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Category;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;
import java.util.ArrayList;

public class Support extends ListenerAdapter {

    private ArrayList<Member> activeTickets = new ArrayList<>();

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] command = event.getMessage().getContentRaw().split(" ");

        if (!command[0].startsWith(Ref.PREFIX)) {
            return;
        }

        if (command[0].equalsIgnoreCase("-ticket") && command.length == 1) {
            if (!activeTickets.contains(event.getMember())) {
                createSupportChannel(event.getMember());
            } else {
                event.getChannel().sendMessage(event.getMember().getAsMention() + ", you already have an open support ticket.").queue();
            }
        }

        if (command[0].equalsIgnoreCase("-closeticket")) {
            if (event.getMessage().getCategory() == Main.guildController.getGuild().getCategoryById(Ref.SUPPORT_ID)) {
                deleteSupportChannel(event.getChannel());
            }
        }
    }


    private void createSupportChannel(Member member) {
        Category supportCategory = Main.guildController.getGuild().getCategoryById(Ref.SUPPORT_ID);
        int size = supportCategory.getTextChannels().size();
        supportCategory.createTextChannel("support-" + (size + 1)).queue(support -> {
            activeTickets.add(member);
            support.createPermissionOverride(member).setAllow(Permission.MESSAGE_READ, Permission.MESSAGE_WRITE).queue();
            EmbedBuilder builder = new EmbedBuilder();
            builder.setColor(Color.YELLOW)
                    .setTitle("Support Ticket #" + (size + 1))
                    .setDescription("A Staff member will be with you shortly " + member.getAsMention());
            ((TextChannel) support).sendMessage(builder.build()).queue();
        });
    }

    private void deleteSupportChannel(TextChannel channel) {
        for (Member member : channel.getMembers()) {
            if (activeTickets.contains(member)) {
                activeTickets.remove(member);
            }
        }
        channel.delete().queue();
    }

    public static String getCommandName() {
        return "Support";
    }

    public static String getDescription() {
        return "-ticket - Opens a support ticket with staff \n" +
                "-closeticket - Closes the support ticket with staff";
    }
}

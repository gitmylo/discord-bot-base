package com.mylo.base.commands.command.General;

import com.mylo.base.commands.Category;
import com.mylo.base.commands.Command;
import com.mylo.base.main.BotStart;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Ping extends Command {
    public Ping() {
        super(new String[]{"ping", "latency", "responsetime"}, new Permission[]{}, Category.General, "See the bot's ping");
    }

    @Override
    public void Run(MessageReceivedEvent e) {
        long ping = BotStart.instance.bot.getGatewayPing();
        int pingcolor = 0x00ff00;
        if (ping > 200){
            pingcolor = 0xFCFF00;
        }
        if (ping > 500){
            pingcolor = 0xFF9600;
        }
        if (ping > 1000){
            pingcolor = 0xff0000;
        }
        MessageEmbed embed = new EmbedBuilder().setColor(pingcolor).addField("Pong!", "Ping is " + ping + "MS!",false).build();
        e.getMessage().getChannel().sendMessage(embed).queue();
    }
}

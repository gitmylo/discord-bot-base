package com.mylo.base.commands.command.General;

import com.mylo.base.commands.Category;
import com.mylo.base.commands.Command;
import com.mylo.base.main.BotStart;
import com.mylo.base.utils.StringUtil;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public class Help extends Command {
    public Help() {
        super(new String[]{"help","?"}, new Permission[]{}, Category.General, "gives help");
    }

    @Override
    public void Run(MessageReceivedEvent e) {
        String[] args = StringUtil.getArgs(e);
        if (args.length == 2){
            Category cat = StringUtil.getCategoryString(args[1]);
            if (cat != null){
                ArrayList<Command> Commands = BotStart.instance.cmdman.getCommandsInCategory(cat);
                EmbedBuilder builder = new EmbedBuilder().setColor(BotStart.instance.ThemeColor).setTitle("Help for " + cat.name() + ".");
                Commands.forEach(command -> {
                    String Trigger = command.triggers[0];
                    builder.addField(BotStart.instance.prefix + Trigger, command.description, false);
                });
                e.getMessage().getChannel().sendMessage(builder.build()).queue();
            }
            else{
                MessageEmbed embed = new EmbedBuilder().setColor(BotStart.instance.ThemeColor).addField("oops.", "Something went wrong, did you type the correct category?",false).build();
                e.getMessage().getChannel().sendMessage(embed).queue();
            }
        }
        else{
            String categories = "";
            for (Category c: Category.values()){
                categories += c.name() + " ";
            }
            MessageEmbed embed = new EmbedBuilder().setColor(BotStart.instance.ThemeColor).addField("Please do " + BotStart.instance.prefix + "help (category)",categories,false).build();
            e.getMessage().getChannel().sendMessage(embed).queue();
        }
    }
}

package com.mylo.base.commands;

import com.mylo.base.commands.command.General.Help;
import com.mylo.base.main.BotStart;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;

public class CommandManager extends ListenerAdapter {
    private ArrayList<Command> Commands;

    public CommandManager(){
        System.out.println("creating Command manager");
        Commands = new ArrayList<>();
        //adding commands
        //General
        Commands.add(new Help());
        //Moderation

        //Fun

        //Register events
        for (Command c: Commands){
            BotStart.instance.bot.addEventListener(c);
        }
        BotStart.instance.bot.addEventListener(this);
        System.out.println("created Command manager");
    }

    public ArrayList<Command> getCommands() {
        return Commands;
    }

    public ArrayList<Command> getCommandsInCategory(Category c){
        ArrayList<Command> output = new ArrayList<>();
        Commands.forEach(command -> {
            if(command.category == c)
                output.add(command);
        });
        return output;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        Commands.forEach(c -> {
            boolean isAllowed = true;
            for (Permission p: c.requiredPerms){
                if (!(e.getGuild().getMember(e.getAuthor()).hasPermission(p))){
                    isAllowed = false;
                }
            }
            boolean isTriggered = false;
            for (String trigger: c.triggers){
                if (e.getMessage().getContentRaw().toLowerCase().startsWith(BotStart.instance.prefix.toLowerCase() + trigger.toLowerCase())){
                    isTriggered = true;
                }
            }
            if (isAllowed && isTriggered){
                c.Run(e);
            }
        });
    }

}

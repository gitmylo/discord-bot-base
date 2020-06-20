package com.mylo.base.commands;

import com.mylo.base.main.BotStart;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.hooks.SubscribeEvent;

import java.util.ArrayList;

public class CommandManager implements EventListener {
    private ArrayList<Command> Commands;

    public CommandManager(){
        Commands = new ArrayList<>();
        //adding commands
        //General

        //Moderation

        //Fun

        //Register events
        for (Command c: Commands){
            BotStart.instance.bot.addEventListener(c);
        }
        BotStart.instance.bot.addEventListener(this);
    }

    public ArrayList<Command> getCommands() {
        return Commands;
    }

    @Override
    public void onEvent(GenericEvent genericEvent) {

    }

    @SubscribeEvent
    public void onMessageRechieved(MessageReceivedEvent e){
        Commands.forEach(c -> c.Run(e));
    }

}

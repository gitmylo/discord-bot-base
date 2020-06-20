package com.mylo.base.commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public abstract class Command extends ListenerAdapter {
    public String[] triggers;
    public Permission[] requiredPerms;
    public String description;
    public Category category;
    public Command(String[] triggers, Permission[] requiredPerms, Category category, String description){
        this.triggers = triggers;
        this.requiredPerms = requiredPerms;
        this.category = category;
        this.description = description;
    }

    public abstract void Run(MessageReceivedEvent e);
}

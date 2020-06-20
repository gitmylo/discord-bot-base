package com.mylo.base.commands;

import net.dv8tion.jda.api.Permission;

public abstract class Command {
    String[] triggers;
    Permission[] requiredPerms;
    String description;
    Category category;
    public Command(String[] triggers, Permission[] requiredPerms, Category category, String description){
        this.triggers = triggers;
        this.requiredPerms = requiredPerms;
        this.category = category;
        this.description = description;
    }

    public abstract void Run(String[] args);
}

package com.mylo.base.commands;

import java.util.ArrayList;

public class CommandManager {
    private ArrayList<Command> Commands;

    public CommandManager(){
        Commands = new ArrayList<>();
        //adding commands
        //General

        //Moderation

        //Fun

    }

    public ArrayList<Command> getCommands() {
        return Commands;
    }
}

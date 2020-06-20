package com.mylo.base.commands.command.General;

import com.mylo.base.commands.Category;
import com.mylo.base.commands.Command;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Ping extends Command {
    public Ping(String[] triggers, Permission[] requiredPerms, Category category, String description) {
        super(triggers, requiredPerms, category, description);
    }

    @Override
    public void Run(MessageReceivedEvent e) {

    }
}

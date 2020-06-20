package com.mylo.base.utils;

import com.mylo.base.main.BotStart;
import net.dv8tion.jda.api.entities.User;

public class UserUtil {
    public static User getUserFromString(String user){
        String absoluteUser = user.replace("<@", "").replace(">", "");
        return BotStart.instance.bot.getUserById(absoluteUser);
    }
}

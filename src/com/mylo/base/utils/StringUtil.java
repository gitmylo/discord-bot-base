package com.mylo.base.utils;

import com.mylo.base.commands.Category;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class StringUtil {
    public static String[] getArgs(MessageReceivedEvent e){
        String Message = e.getMessage().getContentRaw();
        String[] Args = Message.split(" ");
        return Args;
    }

    public static Category getCategoryString(String s){
        for (Category c: Category.values()){
            if (s.equalsIgnoreCase(c.name())){
                return c;
            }
        }
        return null;
    }
}

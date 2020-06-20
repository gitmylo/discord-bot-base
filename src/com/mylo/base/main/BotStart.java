package com.mylo.base.main;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class BotStart {

    public static BotStart instance;

    public String prefix = "!";
    JDA bot;

    public BotStart(String token){
        try{
            bot = new JDABuilder(token).build();

        }
        catch (Exception e){

        }
    }

    public static void main(String[] args){
        if (args.length == 1){//was the token supplied?
            instance = new BotStart(args[0]);//create an instance
        }
        else{
            System.out.println("Please run the bot with the token as argument (java -jar bot.jar <token>)");//tell the user that there was no token supplied and exit
        }
    }
}

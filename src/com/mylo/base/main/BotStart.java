package com.mylo.base.main;

public class BotStart {

    public static BotStart instance;

    public String token;

    public BotStart(String token){
        this.token = token;
    }

    public static void main(String[] args){
        if (args.length == 1){
            instance = new BotStart(args[0]);
        }
        else{
            System.out.println("Please run the bot with the token as argument (java -jar bot.jar <token>)");
        }
    }
}

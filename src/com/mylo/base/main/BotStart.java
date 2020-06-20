package com.mylo.base.main;

import com.mylo.base.commands.CommandManager;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.hooks.SubscribeEvent;

import javax.annotation.Nonnull;
import javax.security.auth.login.LoginException;

public class BotStart extends ListenerAdapter {

    public static BotStart instance;

    public int ThemeColor = 0xffaa00;
    public String prefix = "!";
    public JDA bot;
    public CommandManager cmdman;

    public BotStart(String token) throws LoginException {
        bot = new JDABuilder(AccountType.BOT).setToken(token).addEventListeners(this).build();
    }

    @Override
    public void onReady(@Nonnull ReadyEvent event) {
        System.out.println("Bot starting");
        cmdman = new CommandManager();
    }

    public static void main(String[] args) throws LoginException {
        if (args.length == 1){//was the token supplied?
            instance = new BotStart(args[0]);//create an instance
        }
        else{
            System.out.println("Please run the bot with the token as argument (java -jar bot.jar <token>)");//tell the user that there was no token supplied and exit
        }
    }
}

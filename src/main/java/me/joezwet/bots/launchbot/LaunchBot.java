package me.joezwet.bots.launchbot;

import javax.security.auth.login.LoginException;

import me.joezwet.bots.launchbot.util.Ref;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

public class LaunchBot {
	
	public static void main(String[] args) {
		try {
			if(Ref.isBot) {
			JDA api = new JDABuilder(AccountType.BOT).setToken(Ref.BOT_TOKEN).addEventListener(new NextLaunches()).buildBlocking();
			api.getPresence().setGame(Game.of("To the SKY!"));
			} else {
			JDA api = new JDABuilder(AccountType.CLIENT).setToken(Ref.BOT_TOKEN).addEventListener(new NextLaunches()).buildBlocking();
			api.getPresence().setGame(Game.of("To the SKY!"));
			}
		} catch (LoginException | IllegalArgumentException | InterruptedException | RateLimitedException e) {
			e.printStackTrace();
		}
	}
}

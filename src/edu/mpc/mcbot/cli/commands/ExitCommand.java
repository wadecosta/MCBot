package edu.mpc.mcbot.cli.commands;

import edu.mpc.mcbot.MCBot;
import edu.mpc.mcbot.cli.ICLICommand;

public class ExitCommand implements ICLICommand {

	@Override
	public void invoke(String[] params) {
		MCBot.getInstance().shutdown();
	}

	@Override
	public String commandName() {
		return "exit";
	}

	@Override
	public String commandDescription() {
		return "Shutdown the bot.";
	}

	@Override
	public boolean caseSensitive() {
		return false;
	}

	@Override
	public boolean addToCompleter() {
		return true;
	}

}

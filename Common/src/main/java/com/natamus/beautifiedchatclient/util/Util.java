package com.natamus.beautifiedchatclient.util;

import com.natamus.beautifiedchatclient.config.ConfigHandler;

import com.natamus.collective.functions.ColourFunctions;
import net.minecraft.ChatFormatting;

public class Util {
	public static ChatFormatting getColour(String word) {
		ChatFormatting colour = ColourFunctions.getById(ConfigHandler.chatOtherSymbolsColour);
		if (word.equalsIgnoreCase("timestamp")) {
			colour = ColourFunctions.getById(ConfigHandler.chatTimestampColour);
		}
		else if (word.equalsIgnoreCase("username")) {
			colour = ColourFunctions.getById(ConfigHandler.chatUsernameColour);
		}
		else if (word.equalsIgnoreCase("chatmessage")) {
			colour = ColourFunctions.getById(ConfigHandler.chatMessageColour);
		}
		
		return colour;
	}
}

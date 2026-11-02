package com.serilum.beautifiedchatclient.events;

import com.mojang.datafixers.util.Pair;
import com.serilum.beautifiedchatclient.config.ConfigHandler;
import com.serilum.beautifiedchatclient.util.Util;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class BeautifulChatEvent {
	public static Component onClientChat(ChatType type, Component message, UUID senderUUID) {
		String chatInRaw = message.getString();

		int prefixEnd;
		int usernameStart;
		int usernameEnd;
		int messageStart;
		if (chatInRaw.startsWith("<") && chatInRaw.contains("> ")) {
			prefixEnd = 0;
			usernameStart = 1;
			usernameEnd = chatInRaw.indexOf("> ");
			messageStart = usernameEnd + 2;
		}
		else if (ConfigHandler.overwriteServerChatStyle) {
			String senderName = Util.findSenderName(chatInRaw, senderUUID);
			if (senderName.isEmpty()) {
				return message;
			}

			usernameStart = Util.getNameIndex(chatInRaw, senderName);
			usernameEnd = usernameStart + senderName.length();
			prefixEnd = chatInRaw.substring(0, usernameStart).stripTrailing().length();
			messageStart = Util.getMessageStart(chatInRaw, usernameEnd);
		}
		else {
			return message;
		}

		if (messageStart < 0 || messageStart >= chatInRaw.length()) {
			return message;
		}

		List<Pair<Style, String>> styledParts = Util.getStyledParts(message);
		boolean keepOwnColours = !ConfigHandler.overwriteServerChatStyle;
		String timestamp = new SimpleDateFormat(ConfigHandler.timestampFormat).format(new Date());

		MutableComponent output = Component.literal("");
		for (String word : ConfigHandler.chatMessageFormat.split("%")) {
			ChatFormatting colour = Util.getColour(word);

			MutableComponent wordComponent;
			if (word.equalsIgnoreCase("timestamp")) {
				wordComponent = Component.literal(timestamp).withStyle(colour);
			}
			else if (word.equalsIgnoreCase("prefix")) {
				wordComponent = Util.getStyledPrefix(styledParts, prefixEnd, colour);
			}
			else if (word.equalsIgnoreCase("username")) {
				ChatFormatting usernameColour = Util.getUsernameColour(chatInRaw.substring(usernameStart, usernameEnd), senderUUID);
				wordComponent = Util.getStyledText(styledParts, usernameStart, usernameEnd, usernameColour, keepOwnColours);
			}
			else if (word.equalsIgnoreCase("chatmessage")) {
				wordComponent = Util.getStyledText(styledParts, messageStart, chatInRaw.length(), colour, keepOwnColours);
			}
			else {
				wordComponent = Component.literal(word).withStyle(colour);
			}

			output.append(wordComponent);
		}

		return output;
	}
}

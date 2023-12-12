package com.natamus.beautifiedchatclient.events;

import com.natamus.beautifiedchatclient.config.ConfigHandler;
import com.natamus.beautifiedchatclient.util.Util;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class BeautifulChatEvent {
	public static Component onClientChat(ChatType type, Component message, UUID senderUUID) {
		String chatInRaw = message.getString();
		if (!chatInRaw.startsWith("<") || !chatInRaw.contains("> ")) {
			return message;
		}
		
		String[] cirspl = chatInRaw.split("> ");
		if (cirspl.length < 2) {
			return message;
		}
		
		String timestamp = new SimpleDateFormat(ConfigHandler.timestampFormat).format(new Date());
		String user = cirspl[0].substring(1);
		String messageString = chatInRaw.replace(cirspl[0] + "> ", "");
		
		MutableComponent output = Component.literal("");
		String raw_outputstring = ConfigHandler.chatMessageFormat;
		for (String word : raw_outputstring.split("%")) {
			ChatFormatting colour = Util.getColour(word);
			String toappend = word;
			
			if (word.equalsIgnoreCase("timestamp")) {
				toappend = timestamp;
			}
			else if (word.equalsIgnoreCase("username")) {
				toappend = user;
			}
			else if (word.equalsIgnoreCase("chatmessage")) {
				toappend = messageString;
			}
			
			MutableComponent wordcomponent = Component.literal(toappend);
			wordcomponent.withStyle(colour);
			output.append(wordcomponent);
		}

		return output;
	}
}

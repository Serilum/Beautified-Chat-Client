package com.natamus.beautifiedchatclient.neoforge.events;

import com.natamus.beautifiedchatclient.events.BeautifulChatEvent;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientChatReceivedEvent;

public class NeoForgeBeautifulChatEvent {
	@SubscribeEvent
	public static void onClientChat(ClientChatReceivedEvent e) {
		Component originalMessage = e.getMessage();
		Component newMessage = BeautifulChatEvent.onClientChat(null, e.getMessage(), e.getSender());
		
		if (originalMessage != newMessage) {
			e.setMessage(newMessage);
		}
	}
}

package com.natamus.beautifiedchatclient.forge.events;

import com.natamus.beautifiedchatclient.events.BeautifulChatEvent;
import net.minecraft.network.chat.Component;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

public class ForgeBeautifulChatEvent {
	public static void registerEventsInBus() {
		// BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeBeautifulChatEvent.class);

		ClientChatReceivedEvent.BUS.addListener(ForgeBeautifulChatEvent::onClientChat);
	}
	
	@SubscribeEvent
	public static void onClientChat(ClientChatReceivedEvent e) {
		Component originalMessage = e.getMessage();
		Component newMessage = BeautifulChatEvent.onClientChat(null, e.getMessage(), e.getSender());
		
		if (originalMessage != newMessage) {
			e.setMessage(newMessage);
		}
	}
}

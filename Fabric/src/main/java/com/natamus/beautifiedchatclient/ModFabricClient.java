package com.natamus.beautifiedchatclient;

import com.natamus.beautifiedchatclient.events.BeautifulChatEvent;
import com.natamus.collective.fabric.callbacks.CollectiveChatEvents;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;

import java.util.UUID;

public class ModFabricClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() { 
		registerEvents();
	}
	
	private void registerEvents() {
		CollectiveChatEvents.CLIENT_CHAT_RECEIVED.register((ChatType type, Component message, UUID senderUUID) -> {
			return BeautifulChatEvent.onClientChat(type, message, senderUUID);
		});
	}
}

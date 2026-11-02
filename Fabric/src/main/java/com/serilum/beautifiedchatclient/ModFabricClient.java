package com.serilum.beautifiedchatclient;

import com.serilum.beautifiedchatclient.events.BeautifulChatEvent;
import com.natamus.collective.fabric.callbacks.CollectiveChatEvents;
import net.fabricmc.api.ClientModInitializer;
import com.serilum.beautifiedchatclient.util.Reference;
import com.natamus.collective.check.ShouldLoadCheck;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;

import java.util.UUID;

public class ModFabricClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() { 
		if (!ShouldLoadCheck.shouldLoad(Reference.MOD_ID)) {
			return;
		}

		registerEvents();
	}
	
	private void registerEvents() {
		CollectiveChatEvents.CLIENT_CHAT_RECEIVED.register((ChatType type, Component message, UUID senderUUID) -> {
			return BeautifulChatEvent.onClientChat(type, message, senderUUID);
		});

		ClientReceiveMessageEvents.MODIFY_GAME.register((Component message, boolean overlay) -> {
			if (overlay) {
				return message;
			}

			return BeautifulChatEvent.onClientChat(null, message, null);
		});
	}
}

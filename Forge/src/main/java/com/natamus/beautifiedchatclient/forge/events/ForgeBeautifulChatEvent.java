package com.natamus.beautifiedchatclient.forge.events;

import com.natamus.beautifiedchatclient.events.BeautifulChatEvent;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ForgeBeautifulChatEvent {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public void onClientChat(ClientChatReceivedEvent e) {
		Component originalMessage = e.getMessage();
		Component newMessage = BeautifulChatEvent.onClientChat(null, e.getMessage(), e.getMessageSigner().profileId());
		
		if (originalMessage != newMessage) {
			e.setMessage(newMessage);
		}
	}
}

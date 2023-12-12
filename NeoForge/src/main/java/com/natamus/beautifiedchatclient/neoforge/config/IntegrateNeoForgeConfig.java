package com.natamus.beautifiedchatclient.neoforge.config;

import com.natamus.beautifiedchatclient.util.Reference;
import com.natamus.collective.config.DuskConfig;
import net.neoforged.neoforge.client.ConfigScreenHandler;
import net.neoforged.fml.ModLoadingContext;

public class IntegrateNeoForgeConfig {
	public static void registerScreen(ModLoadingContext modLoadingContext) {
		modLoadingContext.registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () -> {
			return new ConfigScreenHandler.ConfigScreenFactory((mc, screen) -> {
				return DuskConfig.DuskConfigScreen.getScreen(screen, Reference.MOD_ID);
			});
		});
	}
}

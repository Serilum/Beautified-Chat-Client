package com.natamus.beautifiedchatclient.forge.config;

import com.natamus.beautifiedchatclient.util.Reference;
import com.natamus.collective.config.DuskConfig;
import net.minecraftforge.client.ConfigGuiHandler;
import net.minecraftforge.fml.ModLoadingContext;

public class IntegrateForgeConfig {
	public static void registerScreen(ModLoadingContext modLoadingContext) {
		modLoadingContext.registerExtensionPoint(ConfigGuiHandler.ConfigGuiFactory.class, () -> {
			return new ConfigGuiHandler.ConfigGuiFactory((mc, screen) -> {
				return DuskConfig.DuskConfigScreen.getScreen(screen, Reference.MOD_ID);
			});
		});
	}
}

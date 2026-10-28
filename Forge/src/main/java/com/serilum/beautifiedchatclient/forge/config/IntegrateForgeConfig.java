package com.serilum.beautifiedchatclient.forge.config;

import com.serilum.beautifiedchatclient.util.Reference;
import com.natamus.collective.config.DuskConfig;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.fml.ModLoadingContext;

public class IntegrateForgeConfig {
	public static void registerScreen(ModLoadingContext modLoadingContext) {
		modLoadingContext.registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () -> {
			return new ConfigScreenHandler.ConfigScreenFactory((mc, screen) -> {
				return DuskConfig.DuskConfigScreen.getScreen(screen, Reference.MOD_ID);
			});
		});
	}
}

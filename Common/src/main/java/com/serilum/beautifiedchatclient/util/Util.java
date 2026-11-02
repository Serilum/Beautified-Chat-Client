package com.serilum.beautifiedchatclient.util;

import com.mojang.datafixers.util.Pair;
import com.natamus.collective.functions.ColourFunctions;
import com.serilum.beautifiedchatclient.config.ConfigHandler;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Util {
	public static ChatFormatting getColour(String word) {
		ChatFormatting colour = ColourFunctions.getById(ConfigHandler.chatOtherSymbolsColour);
		if (word.equalsIgnoreCase("timestamp")) {
			colour = ColourFunctions.getById(ConfigHandler.chatTimestampColour);
		}
		else if (word.equalsIgnoreCase("username")) {
			colour = ColourFunctions.getById(ConfigHandler.chatUsernameColour);
		}
		else if (word.equalsIgnoreCase("chatmessage")) {
			colour = ColourFunctions.getById(ConfigHandler.chatMessageColour);
		}

		return colour;
	}

	public static ChatFormatting getUsernameColour(String username, UUID senderUUID) {
		if (isOwnUsername(username, senderUUID)) {
			return ColourFunctions.getById(ConfigHandler.chatUsernameColour);
		}

		return ColourFunctions.getById(ConfigHandler.chatOtherUsernameColour);
	}

	public static boolean isOwnUsername(String username, UUID senderUUID) {
		LocalPlayer localPlayer = Minecraft.getInstance().player;
		if (localPlayer == null) {
			return true;
		}

		if (localPlayer.getUUID().equals(senderUUID)) {
			return true;
		}

		return username.equals(localPlayer.getName().getString());
	}

	public static List<Pair<Style, String>> getStyledParts(Component message) {
		List<Pair<Style, String>> styledParts = new ArrayList<>();
		message.visit((style, text) -> {
			styledParts.add(Pair.of(style, text));
			return Optional.empty();
		}, Style.EMPTY);

		return styledParts;
	}

	public static MutableComponent getStyledText(List<Pair<Style, String>> styledParts, int from, int to, ChatFormatting colour, boolean keepOwnColours) {
		MutableComponent styledText = Component.literal("").withStyle(colour);

		int position = 0;
		for (Pair<Style, String> styledPart : styledParts) {
			String partText = styledPart.getSecond();
			int partStart = position;
			int partEnd = position + partText.length();
			position = partEnd;

			if (partEnd <= from || partStart >= to) {
				continue;
			}

			String text = partText.substring(Math.max(from, partStart) - partStart, Math.min(to, partEnd) - partStart);

			Style style = styledPart.getFirst();
			if (!keepOwnColours) {
				style = style.withColor((TextColor)null);
			}

			styledText.append(Component.literal(text).setStyle(style));
		}

		return styledText;
	}

	public static MutableComponent getStyledPrefix(List<Pair<Style, String>> styledParts, int prefixEnd, ChatFormatting colour) {
		if (prefixEnd == 0) {
			return Component.literal("");
		}

		return getStyledText(styledParts, 0, prefixEnd, colour, true).append(" ");
	}

	public static String findSenderName(String chatInRaw, UUID senderUUID) {
		String senderName = "";
		int senderNameIndex = chatInRaw.length();

		for (String playerName : getPossibleSenderNames(senderUUID)) {
			int nameIndex = getNameIndex(chatInRaw, playerName);
			if (nameIndex < 0) {
				continue;
			}

			boolean comesFirst = nameIndex < senderNameIndex;
			boolean isLongerAtSameSpot = nameIndex == senderNameIndex && playerName.length() > senderName.length();
			if (comesFirst || isLongerAtSameSpot) {
				senderName = playerName;
				senderNameIndex = nameIndex;
			}
		}

		return senderName;
	}

	public static List<String> getPossibleSenderNames(UUID senderUUID) {
		List<String> playerNames = new ArrayList<>();

		ClientPacketListener connection = Minecraft.getInstance().getConnection();
		if (connection == null) {
			return playerNames;
		}

		if (senderUUID != null) {
			PlayerInfo senderInfo = connection.getPlayerInfo(senderUUID);
			if (senderInfo != null) {
				playerNames.add(senderInfo.getProfile().name());
				return playerNames;
			}
		}

		for (PlayerInfo playerInfo : connection.getOnlinePlayers()) {
			playerNames.add(playerInfo.getProfile().name());
		}

		return playerNames;
	}

	public static int getNameIndex(String chatInRaw, String playerName) {
		int nameIndex = chatInRaw.indexOf(playerName);
		while (nameIndex >= 0) {
			if (isStandaloneName(chatInRaw, playerName, nameIndex)) {
				return nameIndex;
			}

			nameIndex = chatInRaw.indexOf(playerName, nameIndex + 1);
		}

		return -1;
	}

	public static boolean isStandaloneName(String chatInRaw, String playerName, int nameIndex) {
		String textBefore = chatInRaw.substring(0, nameIndex).stripTrailing();
		String textAfter = chatInRaw.substring(nameIndex + playerName.length());

		if (!textBefore.isEmpty() && isWordCharacter(textBefore.charAt(textBefore.length() - 1))) {
			return false;
		}

		return textAfter.isEmpty() || !isWordCharacter(textAfter.charAt(0));
	}

	public static boolean isWordCharacter(char character) {
		return Character.isLetterOrDigit(character) || character == '_';
	}

	public static int getMessageStart(String chatInRaw, int usernameEnd) {
		String symbolsAfterName = getSymbolsAfterName(chatInRaw, usernameEnd);

		int separatorIndex = -1;
		for (String separator : Arrays.asList(": ", "> ", "\u00BB ", "| ")) {
			separatorIndex = Math.max(separatorIndex, symbolsAfterName.lastIndexOf(separator));
		}

		if (separatorIndex < 0) {
			return -1;
		}

		return usernameEnd + separatorIndex + 2;
	}

	public static String getSymbolsAfterName(String chatInRaw, int usernameEnd) {
		StringBuilder symbols = new StringBuilder();
		for (char character : chatInRaw.substring(usernameEnd).toCharArray()) {
			if (Character.isLetterOrDigit(character)) {
				break;
			}

			symbols.append(character);
		}

		return symbols.toString();
	}
}

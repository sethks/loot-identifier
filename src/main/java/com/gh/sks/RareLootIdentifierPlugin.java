package com.gh.sks;

import com.google.inject.Provides;
import javax.inject.Inject;
import java.util.Map.Entry;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.InteractingChanged;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.loottracker.LootReceived;

@Slf4j
@PluginDescriptor(
	name = "Rare Loot Identifier"
)
public class RareLootIdentifierPlugin extends Plugin
{

	@Inject
	private Client client;

	@Inject
	private RareLootIdentifierConfig config;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Getter(AccessLevel.PACKAGE)
	private Actor lastOpponent; // Used to get the actor the player is fighting

	@Provides
	RareLootIdentifierConfig provideConfig(ConfigManager configManager) { return configManager.getConfig(RareLootIdentifierConfig.class); }

	@Override
	protected void startUp() throws Exception
	{
		ListOfBosses.setListOfBosses(); // Instantiate our maps from ListOfBosses on startup
		ListOfBosses.setNUMap();
	}

	@Override
	protected void shutDown() throws Exception
	{
		lastOpponent = null;
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}
	}

	// RL Method to obtain the actor being interacted/attacked
	@Subscribe
	private void onInteractingChanged(InteractingChanged event)
	{
		if(event.getSource() != client.getLocalPlayer())
			return;

		Actor opponent = event.getTarget();

		if (opponent == null) { return; }

		lastOpponent = opponent;
	}

	// RL Method that manages sending messages to the players chat when an item is received
	private void sendChatMessage(String chatMessage)
	{
		String message = new ChatMessageBuilder()
				.append(ChatColorType.HIGHLIGHT)
				.append(chatMessage)
				.build();

		chatMessageManager.queue(
				QueuedMessage.builder()
						.type(ChatMessageType.CONSOLE)
						.runeLiteFormattedMessage(message)
						.build());
	}

	// Formats the String obtained from onLootReceived in a more workable format for checking with the maps in ListOfBosses
	private String formatLoot(String lootStackInformation)
	{
		//splitLootStack[2] = (id=426, quantity=
		String[] splitLootStack = lootStackInformation.split("ItemStack");
		String[] cleanIDArray = splitLootStack[2].substring(1).split(",");
		String formattedString = cleanIDArray[0];

		return formattedString;
	}

	// RL Method to obtain the information about the item that is received from drops
	@Subscribe
	private void onLootReceived(final LootReceived event)
	{
		if(ListOfBosses.listOfBosses.contains(lastOpponent.getName()) && config.showNUBossDropID())
		{
			String lootStack = event.getItems().toString().substring(1);
			String lootID = "";
			if((lootStack.length()) > 1)
				lootID = formatLoot(lootStack);
			String currentItem = "";

//			if(config.showAllBossDropID())
//			{
//				return;
//			}

			if(ListOfBosses.mapOfNUItems.containsValue(lootID))
			{
				for(Entry<String, String> entry: ListOfBosses.mapOfNUItems.entrySet())
				{
					if(entry.getValue().equals(lootID))
					{
						currentItem = entry.getKey();
						sendChatMessage("You got " + currentItem + " from a " + lastOpponent.getName());
					}
				}
			}
		}
	}
}

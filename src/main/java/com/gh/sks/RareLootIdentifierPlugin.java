package com.gh.sks;

import com.google.inject.Provides;
import javax.inject.Inject;

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

import java.util.ArrayList;
import java.util.List;

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
	private Actor lastOpponent;

	@Provides
	RareLootIdentifierConfig provideConfig(ConfigManager configManager) { return configManager.getConfig(RareLootIdentifierConfig.class); }

	@Override
	protected void startUp() throws Exception
	{
		ListOfBosses.setListOfBosses();
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

//	private void checkItemFromBoss()
//	{
//
//	}

	@Subscribe
	private void onInteractingChanged(InteractingChanged event)
	{
		if(event.getSource() != client.getLocalPlayer())
			return;

		Actor opponent = event.getTarget();

		if (opponent == null) { return; }

		lastOpponent = opponent;
		if(ListOfBosses.listOfBosses.contains(opponent.getName()))
		{

		}

		//sendChatMessage(opponent.getName());
	}

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
}

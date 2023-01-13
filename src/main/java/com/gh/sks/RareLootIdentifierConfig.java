package com.gh.sks;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("rarelootidentifier")
public interface RareLootIdentifierConfig extends Config
{
	@ConfigItem(
			keyName = "enableBossDropIDs",
			name = "Enable Boss Drop IDs",
			description = "Enable this to show the drop rate of items from all of Runescape's bosses",
			position = 0
	)
	default boolean showBossDropID() { return true; }

	@ConfigItem(
			keyName = "showAllNPCDropIDs",
			name = "Enable All NPC Drop IDs",
			description = "temp",
			position = 1
	)
	default boolean showAllNPCDropID() { return false; }
}

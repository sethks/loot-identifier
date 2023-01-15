package com.gh.sks;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("rarelootidentifier")
public interface RareLootIdentifierConfig extends Config
{
	@ConfigItem(
			keyName = "enableNUBossDropIDs",
			name = "Enable Non-Unique Boss Drops",
			description = "Enable this to show the drop rate of non-unique items ONLY from all of Runescape's bosses",
			position = 0
	)
	default boolean showNUBossDropID() { return true; }

	@ConfigItem(
			keyName = "showAllBossDropIDs",
			name = "Enable All Boss Drops",
			description = "Enable this to show the drop rate of all 'rare' items from all of Runescape's bosses",
			position = 1
	)
	default boolean showAllBossDropID() { return false; }
}

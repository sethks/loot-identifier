package com.gh.sks;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class RareLootIdentifierPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(RareLootIdentifierPlugin.class);
		RuneLite.main(args);
	}
}
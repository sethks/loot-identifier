package com.gh.sks;

import java.util.ArrayList;
import java.util.HashMap;

public class ListOfBosses
{
    public static ArrayList<String> listOfBosses = new ArrayList<>();
    public static HashMap<String, String> mapOfNUItems = new HashMap<>();
    public static HashMap<String, String> mapOfAllItems = new HashMap<>();

    public static void setListOfBosses()
    {

        //listOfBosses.add("Guard"); //temporary for testing.

        // Slayer Bosses
        listOfBosses.add("Dusk");
        listOfBosses.add("Dawn");
        listOfBosses.add("Abyssal Sire");
        listOfBosses.add("Kraken");
        listOfBosses.add("Cerberus");
        listOfBosses.add("Thermonuclear smoke devil");
        listOfBosses.add("Alchemical Hydra");

        //Wilderness Bosses
        listOfBosses.add("Chaos Fanatic");
        listOfBosses.add("Crazy archaeologist");
        listOfBosses.add("Scorpia");
        listOfBosses.add("King Black Dragon");
        listOfBosses.add("Chaos Elemental");
        listOfBosses.add("Vet'ion");
        listOfBosses.add("Venenatis");
        listOfBosses.add("Callisto");

        //?? Bosses
        listOfBosses.add("Obor");
        listOfBosses.add("Bryophyta");
        listOfBosses.add("Hespori");
        listOfBosses.add("Skotizo");
        listOfBosses.add("Sarachnis");
        listOfBosses.add("Kalphite Queen");

        // Skilling Bosses
        listOfBosses.add("Supply crate"); // Wintertodt
        listOfBosses.add("Zalcano");
        listOfBosses.add("Reward pool"); // Tempeross

        // Chambers of Xeric
        listOfBosses.add("Lizardman shaman");
        listOfBosses.add("Tekton");

        //Theatre of Blood
        listOfBosses.add("Monumental chest");

        // Corrupted Gauntlet
        listOfBosses.add("Reward chest");

        //Dagganoth Kings
        listOfBosses.add("Dagannoth Supreme");
        listOfBosses.add("Dagannoth Rex");
        listOfBosses.add("Dagannoth Prime");

        // God Wars 1
        listOfBosses.add("Kree'arra");
        listOfBosses.add("Commander Zilyana");
        listOfBosses.add("General Graardor");
        listOfBosses.add("K'ril Tsutsaroth");
        listOfBosses.add("Nex");

        // Quest Bosses
        listOfBosses.add("Zulrah");
        listOfBosses.add("Vorkath");
        listOfBosses.add("Corporeal Beast");
        listOfBosses.add("The Nightmare");
        listOfBosses.add("Phantom Muspah");
    }

    public static void setNUMap()
    {
        mapOfNUItems.put("Iron Bolts", "id=9140");
        mapOfNUItems.put("Onion Seed", "id=5319");
    }

    public static void setAllMap()
    {
        //TO-DO
    }



}

package com.crudalchemy.codeclicker.utility;

import static com.crudalchemy.codeclicker.models.UpgradeType.CLICK_EFFICIENCY;
import static com.crudalchemy.codeclicker.models.UpgradeType.GENERATOR_EFFICIENCY;
import static com.crudalchemy.codeclicker.models.UpgradeType.GLOBAL_LINE_PRODUCTION_MULTIPLIER;

import com.crudalchemy.codeclicker.Game;
import com.crudalchemy.codeclicker.models.Generator;
import com.crudalchemy.codeclicker.models.Upgrade;

public class InitializeStoreItems {

    public static void hardCodedStoreItems(Game game) {
        game.getGeneratorList().add(new Generator("Extra Monitor", null,"Extra Monitor Description", 4, 1.07, 1.67));
        game.getGeneratorList().add(new Generator("Firewall", null, "Firewall Description", 60, 1.15, 20));
        game.getGeneratorList().add(new Generator("Database", null, "Database Description", 720, 1.14, 90));
        game.getGeneratorList().add(new Generator("Vending Machine", null,"Vending Machine Description", 8640, 1.13, 360));
        Upgrade higherRes = new Upgrade("Higher Resolution", null, "Higher Resolution Description", 1000, GENERATOR_EFFICIENCY);
        Upgrade moreBricks = new Upgrade("More Bricks", null, "More Bricks Description", 5000, GENERATOR_EFFICIENCY);
        Upgrade javascript = new Upgrade("JavaScript", null, "JavaScript Description", 7000, GLOBAL_LINE_PRODUCTION_MULTIPLIER);
        Upgrade newKeyCaps = new Upgrade("New Keycaps", null, "Keycaps Description", 750, CLICK_EFFICIENCY);
        higherRes.setGenerator(game.getGeneratorList().get(0));
        moreBricks.setGenerator(game.getGeneratorList().get(1));
        game.getUpgradeList().add(higherRes);
        game.getUpgradeList().add(moreBricks);
        game.getUpgradeList().add(javascript);
        game.getUpgradeList().add(newKeyCaps);
    }
}